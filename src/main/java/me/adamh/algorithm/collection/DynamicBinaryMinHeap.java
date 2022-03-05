package me.adamh.algorithm.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class DynamicBinaryMinHeap<E> {
    
    private final ArrayList<E> heap;
    
    public DynamicBinaryMinHeap() {
        this.heap = new ArrayList<>();
    }
    
    public DynamicBinaryMinHeap(int initialCapacity) {
        this.heap = new ArrayList<>(initialCapacity);
    }
    
    public DynamicBinaryMinHeap(E[] array) {
        int start = array.length / 2 - 1;
        this.heap = new ArrayList<>(Arrays.asList(array));
        
        for (int i = start; i >= 0; i--) {
            shiftDown(i);
        }
    }
    
    public int size() {
        return heap.size();
    }
    
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    
    public void insert(E element) {
        heap.add(element);
        shiftUp(heap.size() - 1);
    }
    
    public E getMin() {
        return heap.isEmpty() ? null : heap.get(0);
    }
    
    public E removeMin() {
        if (heap.isEmpty()) {
            return null;
        }
        
        int lastIndex = heap.size() - 1;
        swap(0, lastIndex);
        E smallest = heap.get(lastIndex);
        heap.remove(lastIndex);
        
        if (!heap.isEmpty()) {
            shiftDown(0);
        }
        
        return smallest;
    }
    
    @Override
    public String toString() {
        return heap.toString();
    }
    
    @SuppressWarnings("unchecked")
    private void shiftUp(int index) {
        if (index == 0) {
            return;
        }
        
        int parentIndex = (index - 1) / 2;
        Comparable<E> parent = (Comparable<E>) heap.get(parentIndex);
        
        if (parent.compareTo(heap.get(index)) > 0) {
            swap(parentIndex, index);
            shiftUp(parentIndex);
        }
    }
    
    @SuppressWarnings("unchecked")
    private void shiftDown(int index) {
        int smallestIndex = index;
        Comparable<E> smallest = (Comparable<E>) heap.get(index);
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        
        if (leftIndex < heap.size() && smallest.compareTo(heap.get(leftIndex)) > 0) {
            smallestIndex = leftIndex;
            smallest = (Comparable<E>) heap.get(smallestIndex);
        }
        
        if (rightIndex < heap.size() && smallest.compareTo(heap.get(rightIndex)) > 0) {
            smallestIndex = rightIndex;
        }
        
        if (smallestIndex != index) {
            swap(index, smallestIndex);
            shiftDown(smallestIndex);
        }
    }
    
    private void swap(int index1, int index2) {
        E temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
    
}
