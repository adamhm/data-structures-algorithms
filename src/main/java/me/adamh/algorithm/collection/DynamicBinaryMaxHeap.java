package me.adamh.algorithm.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class DynamicBinaryMaxHeap<E> {
    
    private final ArrayList<E> heap;
    
    public DynamicBinaryMaxHeap() {
        this.heap = new ArrayList<>();
    }
    
    public DynamicBinaryMaxHeap(int initialCapacity) {
        this.heap = new ArrayList<>(initialCapacity);
    }
    
    public DynamicBinaryMaxHeap(E[] array) {
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
    
    public E getMax() {
        return heap.isEmpty() ? null : heap.get(0);
    }
    
    public E removeMax() {
        if (heap.isEmpty()) {
            return null;
        }
        
        int lastIndex = heap.size() - 1;
        swap(0, lastIndex);
        E largest = heap.get(lastIndex);
        heap.remove(lastIndex);
        
        if (!heap.isEmpty()) {
            shiftDown(0);
        }
        
        return largest;
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
        
        if (parent.compareTo(heap.get(index)) < 0) {
            swap(parentIndex, index);
            shiftUp(parentIndex);
        }
    }
    
    @SuppressWarnings("unchecked")
    private void shiftDown(int index) {
        int largestIndex = index;
        Comparable<E> largest = (Comparable<E>) heap.get(index);
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        
        if (leftIndex < heap.size() && largest.compareTo(heap.get(leftIndex)) < 0) {
            largestIndex = leftIndex;
            largest = (Comparable<E>) heap.get(largestIndex);
        }
        
        if (rightIndex < heap.size() && largest.compareTo(heap.get(rightIndex)) < 0) {
            largestIndex = rightIndex;
        }
        
        if (largestIndex != index) {
            swap(index, largestIndex);
            shiftDown(largestIndex);
        }
    }
    
    private void swap(int index1, int index2) {
        E temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
    
}
