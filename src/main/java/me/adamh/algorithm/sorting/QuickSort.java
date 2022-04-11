package me.adamh.algorithm.sorting;

public class QuickSort<T extends Comparable<T>> {
    
    public void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }
    
    private void quickSort(T[] array, int lowerBound, int upperBound) {
        if (lowerBound < upperBound) {
            int loc = partition(array, lowerBound, upperBound);
            quickSort(array, lowerBound, loc - 1);
            quickSort(array, loc + 1, upperBound);
        }
    }
    
    private int partition(T[] array, int lowerBound, int upperBound) {
        T pivot = array[lowerBound];
        int start = lowerBound;
        int end = upperBound;
        
        while (start < end) {
            while (lessOrEqual(array[start], pivot)) {
                start++;
            }
            
            while (greater(array[end], pivot)) {
                end--;
            }
            
            if (start < end) {
                swap(array, start, end);
            }
        }
        
        swap(array, lowerBound, end);
        return end;
    }
    
    private boolean lessOrEqual(T t1, T t2) {
        return t1.compareTo(t2) <= 0;
    }
    
    private boolean greater(T t1, T t2) {
        return t1.compareTo(t2) > 0;
    }
    
    private void swap(T[] array, int i1, int i2) {
        T temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }
    
}
