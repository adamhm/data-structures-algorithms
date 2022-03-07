package me.adamh.algorithm.other;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthElementTest {
    
    @Test
    void getKthSmallest_legalArgument() {
        Integer[] array = {3, 1, 4, 5, 7, 2};
        
        assertEquals(4, KthElement.getKthSmallest(array, 4));
    }
    
    @Test
    void getKthSmallest_twoElements() {
        Integer[] array = {3, 1};
        
        assertEquals(3, KthElement.getKthSmallest(array, 2));
    }
    
    @Test
    void getKthSmallest_oneElement() {
        Integer[] array = {3};
        
        assertThrows(IllegalArgumentException.class, () -> KthElement.getKthSmallest(array, 2));
    }
    
    @Test
    void getKthLargest_legalArgument() {
        Integer[] array = {3, 1, 4, 5, 7, 2};
        
        assertEquals(5, KthElement.getKthLargest(array, 2));
    }
    
    @Test
    void getKthLargest_twoElement() {
        Integer[] array = {4, 7};
        
        assertEquals(4, KthElement.getKthLargest(array, 2));
    }
    
    @Test
    void getKthLargest_oneElement() {
        Integer[] array = {4};
        
        assertThrows(IllegalArgumentException.class, () -> KthElement.getKthLargest(array, 2));
    }
    
    @Test
    void getKthLargestBubble_legalArgument() {
        Integer[] array = {3, 1, 4, 5, 7, 2};
        
        assertEquals(5, KthElement.getKthLargestBubble(array, 2));
    }
    
    @Test
    void getKthLargestBubble_twoElement() {
        Integer[] array = {4, 7};
        
        assertEquals(4, KthElement.getKthLargestBubble(array, 2));
    }
    
    @Test
    void getKthLargestBubble_oneElement() {
        Integer[] array = {4};
        
        assertThrows(IllegalArgumentException.class, () -> KthElement.getKthLargestBubble(array, 2));
    }
}