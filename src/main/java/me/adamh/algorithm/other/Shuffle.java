package me.adamh.algorithm.other;

import java.util.Arrays;
import java.util.Random;

/**
 * The modern Fisher-Yates algorithm to shuffle a sequence of items
 */
public class Shuffle {
    
    private final static Random RANDOM = new Random();
    
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        shuffle(ints);
        System.out.println(Arrays.toString(ints));
        
        Character[] chars = {'A', 'B', 'C', 'D', 'E', 'F'};
        shuffle(chars);
        System.out.println(Arrays.toString(chars));
    }
    
    static <E> void shuffle(E[] array) {
        for (int i = array.length; i > 1; i--) {
            int randomIndex = RANDOM.nextInt(i);
            swap(array, randomIndex, i - 1);
        }
    }
    
    private static <E> void swap(E[] array, int index1, int index2) {
        E temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
