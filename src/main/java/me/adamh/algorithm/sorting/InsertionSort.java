package me.adamh.algorithm.sorting;

public class InsertionSort<T extends Comparable<T>> {
    
    public void sort(T[] array) {
        int arrayLength = array.length;
        
        for (int i = 1; i < arrayLength; i++) {
            /*for (int j = i; j > 0 && less(array[j], array[j - 1]); j--) {
                swap(array, j, j - 1);
            }*/
            int j = i;
            while(j > 0 && less(array[j], array[j - 1])) {
                swap(array, j, j - 1);
                j--;
            }
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
