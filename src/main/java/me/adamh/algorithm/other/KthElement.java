package me.adamh.algorithm.other;

import me.adamh.algorithm.collection.DynamicBinaryMaxHeap;
import me.adamh.algorithm.collection.DynamicBinaryMinHeap;

public class KthElement {
    
    public static <T> T getKthSmallest(T[] array, int k) {
        if (array.length < k) {
            throw new IllegalArgumentException("Array length < k");
        }
        
        DynamicBinaryMinHeap<T> heap = new DynamicBinaryMinHeap<>(array);
        T result = null;
        
        for (int i = 0; i < k; i++) {
            result = heap.removeMin();
        }
        
        return result;
    }
    
    public static <T> T getKthLargest(T[] array, int k) {
        if (array.length < k) {
            throw new IllegalArgumentException("Array length < k");
        }
        
        DynamicBinaryMaxHeap<T> heap = new DynamicBinaryMaxHeap<>(array);
        
        T result = null;
        
        for (int i = 0; i < k; i++) {
            result = heap.removeMax();
        }
        
        return result;
    }
    
    public static <T extends Comparable<T>> T getKthLargestBubble(T[] array, int k) {
        int arrayLength = array.length;
        
        if (arrayLength < k) {
            throw new IllegalArgumentException("Array length < k");
        }
        
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < arrayLength - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        
        return array[arrayLength - k];
    }
}
