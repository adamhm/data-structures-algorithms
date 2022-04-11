package me.adamh.algorithm.sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("Sorting with selection sort")
class QuickSortTest {
    
    QuickSort<String> quickSort = new QuickSort<>();
    
    @Test
    void sort() {
        String[] array = {"S", "A", "M", "P", "L", "E", "T", "E", "X", "T"};
        String[] sortedArray = {"A", "E", "E", "L", "M", "P", "S", "T", "T", "X"};
        
        quickSort.sort(array);
        
        assertArrayEquals(sortedArray, array);
    }
    
}
