package me.adamh.algorithm.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    
    MergeSort<String> mergeSort = new MergeSort<>();
    
    @Test
    void sort() {
        String[] array = {"S", "A", "M", "P", "L", "E", "T", "E", "X", "T"};
        String[] sortedArray = {"A", "E", "E", "L", "M", "P", "S", "T", "T", "X"};

        
        mergeSort.sort(array);
        assertArrayEquals(sortedArray, array);
    }
    
}
