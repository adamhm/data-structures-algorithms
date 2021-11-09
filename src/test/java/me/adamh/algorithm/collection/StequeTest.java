package me.adamh.algorithm.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StequeTest {
    
    Steque<String> steque;
    
    @BeforeEach
    void setUp() {
        steque = new Steque<>();
    }
    
    @Test
    void iterator() {
        steque.enqueue("Uno");
        steque.enqueue("Dos");
        steque.enqueue("Tres");
        List<String> expectedList = List.of("Uno", "Dos", "Tres");
        List<String> actualList = new ArrayList<>();
        steque.forEach(actualList::add);
        
        assertEquals(expectedList, actualList);
    }
    
    @Test
    void iterator_emptyCollection() {
        List<String> expectedList = List.of();
        List<String> actualList = new ArrayList<>();
        steque.forEach(actualList::add);
        
        assertEquals(expectedList, actualList);
    }
    
    @Test
    void isEmpty() {
        steque.enqueue("Uno");
        steque.pop();
        assertTrue(steque.isEmpty());
    }
    
    @Test
    void size() {
        steque.push("Uno");
        steque.pop();
        steque.enqueue("Dos");
        assertEquals(1, steque.size());
    }
    
    @Test
    void enqueue() {
        steque.enqueue("Uno");
        
        assertEquals(1, steque.size());
        assertEquals("Uno", steque.pop());
    }
    
    @Test
    void enqueue_after_enqueue() {
        steque.enqueue("Uno");
        steque.enqueue("Dos");
        
        assertEquals(2, steque.size());
        assertEquals("Uno", steque.pop());
        assertEquals("Dos", steque.pop());
    }
    
    @Test
    void enqueue_after_push() {
        steque.push("Uno");
        steque.enqueue("Dos");
        
        assertEquals("Uno", steque.pop());
    }
    
    @Test
    void push() {
        steque.push("Uno");
        
        assertEquals(1, steque.size());
        assertEquals("Uno", steque.pop());
    }
    
    @Test
    void push_after_push() {
        steque.push("Uno");
        steque.push("Dos");
        steque.push("Tres");
        
        assertEquals("Tres", steque.pop());
        assertEquals("Dos", steque.pop());
        assertEquals("Uno", steque.pop());
    }
    
    @Test
    void push_after_enqueue() {
        steque.enqueue("Uno");
        steque.push("Dos");
        
        assertEquals("Dos", steque.pop());
    }
    
    @Test
    void pop() {
        steque.push("Uno");
        
        assertEquals("Uno", steque.pop());
    }
    
    @Test
    void pop_emptyCollection() {
        assertThrows(NoSuchElementException.class, () -> steque.pop());
    }
    
    @Test
    void pop_multipleElement() {
        steque.enqueue("Tres");
        steque.push("Dos");
        steque.push("Uno");
        
        assertEquals("Uno", steque.pop());
    }
    
    @Test
    void toString_emptyCollection() {
        assertEquals("{}", steque.toString());
    }
    
    @Test
    void toString_notEmptyCollection() {
        steque.enqueue("Uno");
        steque.enqueue("Dos");
        steque.enqueue("Tres");
        
        assertEquals("{Uno, Dos, Tres}", steque.toString());
    }
    
}
