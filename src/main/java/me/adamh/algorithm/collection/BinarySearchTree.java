package me.adamh.algorithm.collection;

import java.util.*;

@SuppressWarnings("unchecked")
public class BinarySearchTree<T> {
    
    private Node<T> root;
    private Comparator<T> comparator;
    private int size;
    
    public BinarySearchTree() {
        this.root = null;
    }
    
    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
        this.root = null;
    }
    
    public BinarySearchTree(T value) {
        this.root = Node.of(value);
    }
    
    public int size() {
        return size;
    }
    
    public boolean add(T value) {
        Node<T> node = add(root, value);
        
        if (node == null) {
            return false;
        }
        
        size++;
        root = node;
        
        return true;
    }
    
    private Node<T> add(Node<T> node, T value) {
        if (node == null) {
            return Node.of(value);
        }
        
        int comparison = comparator != null
            ? comparator.compare(value, node.value)
            : ((Comparable<T>) value).compareTo(node.value);
        
        if (comparison == 0) {
            return null;
        }
        
        if (comparison < 0) {
            node.left = add(node.left, value);
        } else {
            node.right = add(node.right, value);
        }
        
        return node;
    }
    
    public Node<T> find(T value) {
        return find(value, root);
    }
    
    private Node<T> find(T value, Node<T> node) {
        if (node == null) return null;
        
        int comparison = comparator != null
            ? comparator.compare(value, node.value)
            : ((Comparable<T>) value).compareTo(node.value);
        
        if (comparison == 0) return node;
        
        if (comparison < 0) return find(value, node.left);
        
        return find(value, node.right);
    }
    
    public Iterator<T> getIterator(TreeIterator type) {
        return new BreadthFirstIterator();
    }
    
    public static class Node<T> {
        
        T value;
        Node<T> left;
        Node<T> right;
        
        private Node(T value) {
            this.value = value;
        }
        
        static <T> Node<T> of(T value) {
            return new Node<>(value);
        }
        
    }
    
    public enum TreeIterator {
        BREADTH_FIRST, PRE_ORDER, IN_ORDER, POST_ORDER
    }
    
    private class BreadthFirstIterator implements Iterator<T> {
        private final Deque<Node<T>> nodeQueue = new ArrayDeque<>();
        
        private BreadthFirstIterator() {
            if (root != null) nodeQueue.offer(root);
        }
        
        @Override
        public boolean hasNext() {
            return !nodeQueue.isEmpty();
        }
        
        @Override
        public T next() {
            Node<T> node = nodeQueue.poll();
            
            if (node == null) throw new NoSuchElementException();
            
            if (node.left != null) {
                nodeQueue.offer(node.left);
            }
            
            if (node.right != null) {
                nodeQueue.offer(node.right);
            }
            
            return node.value;
        }
        
    }
    
}
