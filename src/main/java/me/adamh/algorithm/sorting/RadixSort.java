package me.adamh.algorithm.sorting;

public class RadixSort {
    
    public static void sort(int[] array) {
        int max = getMax(array);
        
        for (int pos = 1; max / pos > 0; pos *= 10) {
            countSort(array, pos);
        }
    }
    
    private static void countSort(int[] array, int pos) {
        final int KEY = 10;
        int[] count = new int[KEY];
        
        for (int i = 0; i < array.length; i++) {
            ++count[(array[i] / pos) % 10];
        }
        
        for (int i = 1; i < KEY; i++) {
            count[i] += count[i - 1];
        }
        
        int[] temp = new int[array.length];
        
        for (int i = array.length - 1; i >= 0; i--) {
            int digit = (array[i] / pos) % 10;
            int index = --count[digit];
            temp[index] = array[i];
        }
        
        System.arraycopy(temp, 0, array, 0, array.length);
    }
    
    private static int getMax(int[] array) {
        int result = Integer.MIN_VALUE;
        
        for (int value : array) {
            if (value > result) {
                result = value;
            }
        }
        
        return result;
    }
    
}
