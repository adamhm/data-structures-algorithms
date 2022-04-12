package me.adamh.algorithm.sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Sorting with insertion sort")
class InsertionSortTest {
    
    InsertionSort<String> insertionSort = new InsertionSort<>();
    
    @Test
    void sort() {
        String[] array = {"S", "A", "M", "P", "L", "E", "T", "E", "X", "T"};
        String[] sortedArray = {"A", "E", "E", "L", "M", "P", "S", "T", "T", "X"};
        
        insertionSort.sort(array);
        
        assertArrayEquals(sortedArray, array);
    }
    
}
