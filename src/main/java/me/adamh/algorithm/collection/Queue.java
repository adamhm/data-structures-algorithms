package me.adamh.algorithm.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class Queue<E> implements Iterable<E> {
    
    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    public boolean isEmpty() {
        return head == null;
    }
    
    int size() {
        return size;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
    }
    
    public void clear() {
        head = tail = null;
        size = 0;
    }
    
    public void offer(E element) {
        Node<E> newNode = new Node<>(element);
        
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        
        size++;
    }
    
    public void enqueue(E element) {
        offer(element);
    }
    
    public E poll() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        
        E value = peek();
        head = head.next;
        size--;
        
        if (size == 0) {
            tail = null;
        }
        
        return value;
    }
    
    public E dequeue() {
        return poll();
    }
    
    public E peek() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        
        return head.value;
    }
    
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        QueueIterator iterator = new QueueIterator();
        
        while(iterator.hasNext()) {
            joiner.add(iterator.next().toString());
        }
        
        return joiner.toString();
    }
    
    static class Node<E> {
        
        private final E value;
        private Node<E> next;
        
        public Node(E value) {
            this.value = value;
        }
        
    }
    
    private class QueueIterator implements Iterator<E> {
        Node<E> current = head;
        
        @Override
        public boolean hasNext() {
            return current != null;
        }
        
        @Override
        public E next() {
            E value = current.value;
            current = current.next;
            
            return value;
        }
        
    }
    
}
