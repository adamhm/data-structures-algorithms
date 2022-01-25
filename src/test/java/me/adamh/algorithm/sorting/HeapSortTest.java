package me.adamh.algorithm.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {
    
    HeapSort<String> heapSort = new HeapSort<>();
    
    @Test
    void sort() {
        String[] array = {"S", "A", "M", "P", "L", "E", "T", "E", "X", "T"};
        String[] sortedArray = {"A", "E", "E", "L", "M", "P", "S", "T", "T", "X"};
        
        heapSort.sort(array);
        
        assertArrayEquals(sortedArray, array);
    }
    
}