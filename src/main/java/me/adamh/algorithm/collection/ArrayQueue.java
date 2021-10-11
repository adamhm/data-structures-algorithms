package me.adamh.algorithm.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.StringJoiner;

/**
 * Non-resizable implementation of a queue data structure using a circular (ring) buffer
 */
public class ArrayQueue<E> implements Iterable<E> {
    
    private static final int INITIAL_CAPACITY = 10;
    
    private final E[] elements;
    private final int capacity;
    private int headIndex = 0;
    private int tailIndex = -1;
    
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        elements = (E[]) new Object[capacity];
    }
    
    public ArrayQueue() {
        this(INITIAL_CAPACITY);
    }
    
    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    public int size() {
        return tailIndex - headIndex + 1;
    }
    
    public boolean isFull() {
        return size() == capacity;
    }
    
    public void clear() {
        Arrays.fill(elements, null);
        headIndex = 0;
        tailIndex = -1;
    }
    
    public boolean offer(E element) {
        if (isFull()) {
            return false;
        }
        
        elements[++tailIndex % capacity] = element;
        
        return true;
    }
    
    public E poll() {
        E value = peek();
        headIndex++;
        
        return value;
    }
    
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        
        return elements[headIndex];
    }
    
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        
        this.forEach(element -> joiner.add(element.toString()));
        
        return joiner.toString();
    }
    
    private class ArrayQueueIterator implements Iterator<E> {
        
        int currentIndex = headIndex;
        
        @Override
        public boolean hasNext() {
            return currentIndex != headIndex + size();
        }
        
        @Override
        public E next() {
            E value = elements[currentIndex];
            currentIndex = (currentIndex + 1) % capacity;
            
            return value;
        }
        
    }
    
}
