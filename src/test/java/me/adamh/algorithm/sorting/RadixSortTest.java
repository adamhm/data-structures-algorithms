package me.adamh.algorithm.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadixSortTest {
    
    @Test
    void sort() {
        int[] array = {28, 117, 41, 235, 320, 145, 600, 4, 37};
        int[] expected = {4, 28, 37, 41, 117, 145, 235, 320, 600};
        
        RadixSort.sort(array);
        
        assertArrayEquals(expected, array);
    }
    
}