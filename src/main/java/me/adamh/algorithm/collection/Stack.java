package me.adamh.algorithm.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class Stack<E> implements Iterable<E> {
    
    private Node<E> head;
    private int size;
    
    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public int size() {
        return size;
    }
    
    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        
        if (head != null) {
            newNode.next = head;
        }
        
        head = newNode;
        size++;
    }
    
    public E pop() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        
        E value = head.value;
        head = head.next;
        size--;
        
        return value;
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
        
        StackIterator iterator = new StackIterator();
        
        while (iterator.hasNext()) {
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
    
    private class StackIterator implements Iterator<E> {
        private Node<E> current = head;
        
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
