package me.adamh.algorithm.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicBinaryMaxHeapTest {
    
    DynamicBinaryMaxHeap<Integer> maxHeap;
    
    @BeforeEach
    void setUp() {
        maxHeap = new DynamicBinaryMaxHeap<>();
    }
    
    @Test
    void insert() {
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);
        
        assertEquals("[3, 1, 2]", maxHeap.toString());
    }
    
    @Test
    void getMax() {
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);
        
        assertEquals(3, maxHeap.getMax());
    }
    
    @Test
    void removeMax() {
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);
        
        int max = maxHeap.removeMax();
        
        assertEquals(3, max);
        assertEquals("[2, 1]", maxHeap.toString());
    }
    
    @Test
    void buildHeapFromArray() {
        Integer[] arr = {4, 10, 3, 5, 1};
        maxHeap = new DynamicBinaryMaxHeap<>(arr);
        
        assertEquals("[10, 5, 3, 4, 1]", maxHeap.toString());
    }
    
}