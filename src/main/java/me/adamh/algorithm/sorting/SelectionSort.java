package me.adamh.algorithm.sorting;

public class SelectionSort<T extends Comparable<T>> {
    
    public void sort(T[] array) {
        int arrayLength = array.length;
        
        for (int i = 0; i < arrayLength - 1; i++) {
            
            int minIndex = i;
            
            for (int j = i + 1; j < arrayLength; j++) {
                if (less(array[j], array[minIndex])) {
                    minIndex = j;
                }
            }
            
            swap(array, i, minIndex);
        }
    }
    
    private boolean less(T v1, T v2) {
        return v1.compareTo(v2) < 0;
    }
    
    private void swap(T[] array, int i1, int i2) {
        T temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }
    
}
