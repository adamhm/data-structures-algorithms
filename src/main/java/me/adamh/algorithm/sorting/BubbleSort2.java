package me.adamh.algorithm.sorting;

/**
 * The improved version of bubble sort algorithm
 */
public class BubbleSort2<T extends Comparable<T>> {
    
    public void sort(T[] array) {
        int arrayLength = array.length;
        boolean swapped = true;
        int i = 0;
        
        while (swapped) {
            swapped = false;
            
            for (int j = 0; j < arrayLength - 1 - i; j++) {
                if (greater(array[j], array[j + 1])) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            
            i++;
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
