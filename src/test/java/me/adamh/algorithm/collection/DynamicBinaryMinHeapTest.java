package me.adamh.algorithm.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicBinaryMinHeapTest {
    
    DynamicBinaryMinHeap<Integer> minHeap;
    
    @BeforeEach
    void setUp() {
        minHeap = new DynamicBinaryMinHeap<>();
    }
    
    @Test
    void insert() {
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
        
        assertEquals("[1, 3, 2]", minHeap.toString());
    }
    
    @Test
    void getMin() {
        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(3);
        
        assertEquals(1, minHeap.getMin());
    }
    
    @Test
    void removeMin() {
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
        
        int min = minHeap.removeMin();
        
        assertEquals(1, min);
        assertEquals("[2, 3]", minHeap.toString());
    }
    
    @Test
    void buildHeapFromArray() {
        Integer[] arr = {4, 10, 3, 5, 1};
        minHeap = new DynamicBinaryMinHeap<>(arr);
        
        assertEquals("[1, 4, 3, 5, 10]", minHeap.toString());
    }
    
}
