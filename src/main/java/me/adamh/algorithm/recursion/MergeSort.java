package me.adamh.algorithm.recursion;

import java.util.Arrays;

public class MergeSort {
    
    public static void main(String[] args) {
        int[] data = new int[]{-5, 20, 10, 3, 2, 0};
        mergeSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
        System.out.println("stop");
    }
    
    public static void mergeSort(int[] data, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(data, start, mid);
            mergeSort(data, mid + 1, end);
            merge(data, start, mid, end);
        }
    }
    
    private static void merge(int[] data, int start, int mid, int end) {
        // build temp array to avoid modifying the original contents
        int[] temp = new int[end - start + 1];
        
        // left array: start -> mid, right array: mid + 1 -> end
        int i = start, j = mid + 1, k = 0;
        
        // while both sub-array have values, try and merge them in sorted order
        while (i <= mid && j <= end) {
            if (data[i] <= data[j]) {
                temp[k] = data[i];
                i++;
                k++;
            } else {
                temp[k] = data[j];
                j++;
                k++;
            }
        }
        // We will run out of data in the left/right sub-array
        // So, we'll have to place all the remained data from the
        // left/right sub-array into the original array
        
        // Add the rest of the values from the left sub-array into the result
        while (i <= mid) {
            temp[k] = data[i];
            i++;
            k++;
        }
        
        // Add the rest of the values from the right sub-array into the result
        while (j <= end) {
            temp[k] = data[j];
            j++;
            k++;
        }
        
        // Copy the temp array into the original array
        for (i = start; i <= end; i++) {
            data[i] = temp[i - start];
        }
    }
    
}
