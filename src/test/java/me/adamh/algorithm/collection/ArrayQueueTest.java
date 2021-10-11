package me.adamh.algorithm.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {
    
    ArrayQueue<String> arrayQueue;
    
    @BeforeEach
    void setUp() {
        arrayQueue = new ArrayQueue<>();
    }
    
    @Test
    void isEmpty_emptyCollection() {
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    void isEmpty_notEmptyCollection() {
        arrayQueue.offer("Uno");
        
        assertFalse(arrayQueue.isEmpty());
    }
    
    
    @Test
    void size_emptyCollection() {
        assertEquals(0, arrayQueue.size());
    }
    
    @Test
    void size_notEmptyCollection() {
        arrayQueue.offer("Uno");
        arrayQueue.offer("Dos");
        
        assertEquals(2, arrayQueue.size());
    }
    
    @Test
    void iterator() {
        arrayQueue.offer("Uno");
        arrayQueue.offer("Dos");
        arrayQueue.offer("Tres");
        List<String> expectedList = List.of("Uno", "Dos", "Tres");
        List<String> actualList = new ArrayList<>();
        arrayQueue.forEach(actualList::add);
        
        assertEquals(expectedList, actualList);
    }
    
    @Test
    void clear() {
        arrayQueue.offer("Uno");
        arrayQueue.offer("Dos");
        arrayQueue.clear();
        
        assertAll(
            () -> assertEquals(0, arrayQueue.size()),
            () -> assertTrue(arrayQueue.isEmpty()),
            () -> assertNull(arrayQueue.peek())
        );
    }
    
    @Test
    void offer() {
        boolean inserted = arrayQueue.offer("Uno");
        
        assertAll(
            () -> assertEquals(1, arrayQueue.size()),
            () -> assertTrue(inserted)
        );
        
    }
    
    @Test
    @Disabled
    void offer_more_element_than_initial_capacity() {
        arrayQueue.offer("1");
        arrayQueue.offer("2");
        arrayQueue.offer("3");
        arrayQueue.offer("4");
        arrayQueue.offer("5");
        arrayQueue.offer("6");
        arrayQueue.offer("7");
        arrayQueue.offer("8");
        arrayQueue.offer("9");
        arrayQueue.offer("10");
        arrayQueue.offer("11");
        arrayQueue.offer("12");
        List<String> expectedList =
            List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        List<String> actualList = new ArrayList<>();
        arrayQueue.forEach(actualList::add);
        
        assertEquals(expectedList, actualList);
    }
    
    @Test
    void poll() {
        arrayQueue.offer("Uno");
        arrayQueue.offer("Dos");
        arrayQueue.offer("Tres");
        
        assertAll(
            () -> assertEquals("Uno", arrayQueue.poll()),
            () -> assertEquals(2, arrayQueue.size())
        );
    }
    
    @Test
    void peek_emptyCollection() {
        assertNull(arrayQueue.peek());
    }
    
    @Test
    void peek() {
        arrayQueue.offer("Uno");
        arrayQueue.offer("Dos");
        
        assertAll(
            () -> assertEquals("Uno", arrayQueue.peek()),
            () -> assertEquals(2, arrayQueue.size())
        );
    }
    
    @Test
    void peek_after_peek() {
        arrayQueue.offer("Uno");
        arrayQueue.offer("Dos");
        arrayQueue.peek();
        
        assertEquals("Uno", arrayQueue.peek());
    }
    
    @Test
    void toString_emptyCollection() {
        assertEquals("{}", arrayQueue.toString());
    }
    
    @Test
    void toString_notEmptyCollection() {
        arrayQueue.offer("Uno");
        arrayQueue.offer("Dos");
        arrayQueue.offer("Tres");
        
        assertEquals("{Uno, Dos, Tres}", arrayQueue.toString());
    }
    
}
