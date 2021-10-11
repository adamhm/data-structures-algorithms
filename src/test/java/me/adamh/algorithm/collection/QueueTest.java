package me.adamh.algorithm.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    
    Queue<String> queue;
    
    @BeforeEach
    void setUp() {
        queue = new Queue<>();
    }
    
    @Test
    void isEmpty_emptyCollection() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void isEmpty_notEmptyCollection() {
        queue.offer("Uno");
        assertFalse(queue.isEmpty());
    }
    
    
    @Test
    void size_emptyCollection() {
        assertEquals(0, queue.size());
    }
    
    @Test
    void size_notEmptyCollection() {
        queue.offer("Uno");
        queue.offer("Dos");
        assertEquals(2, queue.size());
    }
    
    @Test
    void iterator() {
        queue.offer("Uno");
        queue.offer("Dos");
        queue.offer("Tres");
        List<String> expectedList = List.of("Uno", "Dos", "Tres");
        List<String> actualList = new ArrayList<>();
        queue.forEach(actualList::add);
        
        assertEquals(expectedList, actualList);
    }
    
    @Test
    void clear() {
        queue.offer("Uno");
        queue.offer("Dos");
        queue.clear();
        assertAll(
            () -> assertEquals(0, queue.size()),
            () -> assertTrue(queue.isEmpty()),
            () -> assertThrows(NoSuchElementException.class, () -> queue.peek())
        );
    }
    
    @Test
    void offer() {
        queue.offer("Uno");
        assertEquals(1, queue.size());
    }
    
    @Test
    void poll() {
        queue.offer("Uno");
        queue.offer("Dos");
        queue.offer("Tres");
        assertAll(
            () -> assertEquals("Uno", queue.poll()),
            () -> assertEquals(2, queue.size())
        );
    }
    
    @Test
    void peek_emptyCollection() {
        assertThrows(NoSuchElementException.class, () -> queue.peek());
    }
    
    @Test
    void peek() {
        queue.offer("Uno");
        queue.offer("Dos");
        assertAll(
            () -> assertEquals("Uno", queue.peek()),
            () -> assertEquals(2, queue.size())
        );
    }
    
    @Test
    void peek_after_peek() {
        queue.offer("Uno");
        queue.offer("Dos");
        queue.peek();
        assertEquals("Uno", queue.peek());
    }
    
    @Test
    void toString_emptyCollection() {
        assertEquals("{}", queue.toString());
    }
    
    @Test
    void toString_notEmptyCollection() {
        queue.offer("Uno");
        queue.offer("Dos");
        queue.offer("Tres");
        
        assertEquals("{Uno, Dos, Tres}", queue.toString());
    }
    
}
