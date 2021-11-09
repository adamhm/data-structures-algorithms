package me.adamh.algorithm.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class Steque<E> implements Iterable<E> {
    
    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    @Override
    public Iterator<E> iterator() {
        return new StequeIterator();
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public void enqueue(E element) {
        Node<E> newNode = Node.of(element);
        
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        
        size++;
    }
    
    public void push(E element) {
        Node<E> newNode = Node.of(element);
        
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        
        size++;
    }
    
    public E pop() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        
        E value = head.value;
        head = head.next;
        size--;
        
        if (size == 0) {
            tail = null;
        }
        
        return value;
    }
    
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        
        StequeIterator iterator = new StequeIterator();
        
        while (iterator.hasNext()) {
            joiner.add(iterator.next().toString());
        }
        
        return joiner.toString();
    }
    
    static class Node<E> {
        
        private final E value;
        private Node<E> next;
        
        private Node(E value) {
            this.value = value;
        }
        
        static <E> Node<E> of(E value) {
            return new Node<>(value);
        }
        
    }
    
    private class StequeIterator implements Iterator<E> {
        
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
