package me.adamh.algorithm.collection;

import java.util.Iterator;
import java.util.StringJoiner;

public class LinkedList<E> implements Iterable<E> {
    
    private LinkedListNode<E> head;
    
    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }
    
    public LinkedList() {
        head = null;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public int sizeIterative() {
        int size = 0;
        LinkedListNode<E> current = head;
        
        while (current != null) {
            size++;
            current = current.next;
        }
        
        return size;
    }
    
    public int size() {
        return getSize(head);
    }
    
    private int getSize(LinkedListNode<E> node) {
        if (node == null) return 0;
        
        return 1 + getSize(node.next);
    }
    
    public void add(E element) {
        LinkedListNode<E> newNode = new LinkedListNode<>(element, null);
        
        if (head == null) {
            head = newNode;
        } else {
            LinkedListNode<E> lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
    }
    
    public void addLast(E element) {
        add(element);
    }
    
    public void addFront(E element) {
        LinkedListNode<E> newNode = new LinkedListNode<>(element, null);
        
        if (head == null) {
            newNode.next = head;
        }
        head = newNode;
    }
    
    public boolean remove(E element) {
        if (head == null) {
            return false;
        }
        
        if (head.value.equals(element)) {
            head = null;
            return true;
        }
        
        LinkedListNode<E> prevNode = head;
        LinkedListNode<E> node = head.next;
        
        while (prevNode.next != null) {
            if (prevNode.next.value.equals(element)) {
                prevNode.next = prevNode.next.next;
                return true;
            }
        }
        
        return false;
    }
    
    public E removeFront() {
        if (head == null) {
            return null;
        }
        
        E value = head.value;
        head = head.next;
        
        return value;
    }
    
    public void reverse() {
        LinkedListNode<E> current = head, prevNode = null, nextNode;
        
        while (current != null) {
            nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }
        
        head = prevNode;
    }
    
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        this.forEach(element -> joiner.add(String.valueOf(element)));
        
        return joiner.toString();
    }
    
    static class LinkedListNode<E> {
        
        private final E value;
        private LinkedListNode<E> next;
        
        public LinkedListNode(E value, LinkedListNode<E> next) {
            this.value = value;
            this.next = next;
        }
        
    }
    
    private class LinkedListIterator implements Iterator<E> {
        private LinkedListNode<E> current = head;
        
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
