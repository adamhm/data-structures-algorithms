package me.adamh.algorithm.sorting;

public class HeapSort<T extends Comparable<T>> {
    
    public void sort(T[] array) {
        // Creating a binary max heap from the array
        int start = array.length / 2 - 1;
        for (int i = start; i >= 0; i--) {
            heapify(array, array.length, i);
        }
        
        // Sorting
        for (int j = array.length - 1; j >=0; j--) {
            swap(array, j, 0);
            heapify(array, j, 0);
        }
    }
    
    private void heapify(T[] array, int length, int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        
        if (left < length && less(array[largest], array[left])) {
            largest = left;
        }
        
        if (right < length && less(array[largest], array[right])) {
            largest = right;
        }
        
        if (largest != index) {
            swap(array, index, largest);
            heapify(array, length, largest);
        }
    }
    
    private void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    
    private boolean less(T v1, T v2) {
        return v1.compareTo(v2) < 0;
    }
}
