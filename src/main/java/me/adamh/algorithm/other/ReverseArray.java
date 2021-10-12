package me.adamh.algorithm.other;

import java.util.Arrays;

public class ReverseArray {
    
    public static void main(String[] args) {
        String[] strings = {"T", "E", "S", "T", "A", "R", "R", "A", "Y"};
        reverseArray(strings);
        System.out.println(Arrays.toString(strings));
    }
    
    private static <T> void reverseArray(T[] array) {
        for (int i = 0, length = array.length; i < length / 2; i++) {
            swap(array, i, length - 1 - i);
        }
    }
    
    private static <T> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
