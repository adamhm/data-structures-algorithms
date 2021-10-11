package me.adamh.algorithm.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class ArrayStack<E> implements Iterable<E> {
    
    private static final int INITIAL_CAPACITY = 10;
    private E[] elements;
    private int topIndex = -1;
    private int size;
    private int capacity;
    
    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        elements = (E[]) new Object[capacity];
    }
    
    public ArrayStack() {
        this(INITIAL_CAPACITY);
    }
    
    @Override
    public Iterator<E> iterator() {
        return new ArrayStackIterator();
    }
    
    public boolean isEmpty() {
        return topIndex == -1;
    }
    
    public int size() {
        return size;
    }
    
    public void push(E element) {
        if (topIndex == capacity - 1) {
            grow();
        }
        
        elements[++topIndex] = element;
        size++;
    }
    
    public E pop() {
        if (topIndex == -1) {
            throw new NoSuchElementException();
        }
        
        E value = peek();
        elements[topIndex--] = null;
        size--;
        
        return value;
    }
    
    public E peek() {
        if (topIndex == -1) {
            throw new NoSuchElementException();
        }
        
        return elements[topIndex];
    }
    
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        this.forEach(element -> joiner.add(element.toString()));
        
        return joiner.toString();
    }
    
    private void grow() {
        int newLength = elements.length + (elements.length >> 1);
        elements = Arrays.copyOf(elements, newLength);
        capacity = newLength;
    }
    
    private class ArrayStackIterator implements Iterator<E> {
        
        private int currentIndex = topIndex;
        
        @Override
        public boolean hasNext() {
            return currentIndex > -1;
        }
        
        @Override
        public E next() {
            return elements[currentIndex--];
        }
        
    }
    
}
