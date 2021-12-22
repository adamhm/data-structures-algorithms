package me.adamh.algorithm.collection;

import java.util.Iterator;

public class DoublyLinkedList<E> implements Iterable<E> {
    
    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    public DoublyLinkedList() {
        head = tail = null;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new DoublyLinkedListIterator();
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public int size() {
        return size;
    }
    
    public void addLast(E element) {
        if (head == null) {
            head = tail = new Node<>(element, null, null);
        } else {
            Node<E> newNode = new Node<>(element, tail, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    public void addFirst(E element) {
        if (head == null) {
            addLast(element);
        } else {
            head = new Node<>(element, null, head);
            size++;
        }
    }
    
    public void add(E element) {
        addLast(element);
    }
    
    public E removeFirst() {
        if (head == null) {
            return null;
        }
        
        if (head.next == null) {
            E value = head.value;
            head = tail = null;
            size = 0;
            return value;
        }
        
        E value = head.value;
        head = head.next;
        size--;
        
        return value;
    }
    
    public E removeLast() {
        if (tail == null) {
            return null;
        }
        
        if (tail.previous == null) {
            E value = tail.value;
            head = tail = null;
            size = 0;
            
            return value;
        }
        
        E value = tail.value;
        tail = tail.previous;
        size--;
        
        return value;
    }
    
    public void reverse() {
        Node<E> tempHead = head, current = tail, prevNode;
        
        while (current != null) {
            prevNode = current.previous;
            current.previous = current.next;
            current.next = prevNode;
            current = prevNode;
        }
        
        head = tail;
        tail = tempHead;
    }
    
    static class Node<E> {
        
        private final E value;
        private Node<E> previous;
        private Node<E> next;
        
        public Node(E value, Node<E> previous, Node<E> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
        
    }
    
    private class DoublyLinkedListIterator implements Iterator<E> {
        
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
