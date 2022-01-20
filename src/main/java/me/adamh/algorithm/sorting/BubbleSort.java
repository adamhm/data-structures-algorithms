package me.adamh.algorithm.sorting;

/**
 * The simplest version of bubble sort
 */
public class BubbleSort<T extends Comparable<T>> {
    
    public void sort(T[] array) {
        int arrayLength = array.length;
        
        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = 0; j < arrayLength - 1; j++) {
                if (greater(array[j], array[j + 1])) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
    
    private void swap(T[] array, int sourceIndex, int targetIndex) {
        T temp = array[targetIndex];
        array[targetIndex] = array[sourceIndex];
        array[sourceIndex] = temp;
    }
    
    private boolean greater(T v1, T v2) {
        return v1.compareTo(v2) > 0;
    }
    
}
