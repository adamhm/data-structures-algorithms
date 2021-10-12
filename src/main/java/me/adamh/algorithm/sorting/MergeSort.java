package me.adamh.algorithm.sorting;

public class MergeSort<T extends Comparable<T>> {
    
    public void sort(T[] array) {
        if (array.length > 1) {
            T[] left = leftHalf(array);
            T[] right = rightHalf(array);
            
            sort(left);
            sort(right);
            merge(array, left, right);
        }
    }
    
    @SuppressWarnings("unchecked")
    T[] leftHalf(T[] array) {
        int size = array.length / 2;
        T[] target = (T[]) new Comparable[size];
        System.arraycopy(array, 0, target, 0, size);
        
        return target;
    }

    @SuppressWarnings("unchecked")
    T[] rightHalf(T[] array) {
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        T[] target = (T[]) new Comparable[rightSize];
        System.arraycopy(array, leftSize, target, 0, rightSize);
        
        return target;
    }
    
    private void merge(T[] result, T[] left, T[] right) {
        int resultLength = result.length;
        int leftLength = left.length;
        int rightLength = right.length;
        int t1 = 0;
        int t2 = 0;
        
        for (int i = 0; i < resultLength; i++) {
            if (t2 >= rightLength
                || (t1 < leftLength && lessThanOrEqual(left[t1], right[t2]))) {
                result[i] = left[t1];
                t1++;
            } else {
                result[i] = right[t2];
                t2++;
            }
        }
    }
    
    private boolean lessThanOrEqual(T v1, T v2) {
        return v1.compareTo(v2) <= 0;
    }
}
