package me.adamh.algorithm.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack<String> stack;
    
    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }
    
    @Test
    void iterator() {
        stack.push("Uno");
        stack.push("Dos");
        stack.push("Tres");
        List<String> expectedList = List.of("Tres", "Dos", "Uno");
        List<String> actualList = new ArrayList<>();
        stack.forEach(actualList::add);
        
        assertEquals(expectedList, actualList);
    }
    
    @Test
    void isEmpty_emptyCollection() {
        assertTrue(stack.isEmpty());
    }
    
    @Test
    void isEmpty_notEmptyCollection() {
        stack.push("Uno");
        assertFalse(stack.isEmpty());
    }
    
    @Test
    void push() {
        stack.push("Uno");
        stack.push("Dos");
        assertEquals(2, stack.size());
    }
    
    @Test
    void pop_once() {
        stack.push("Uno");
        stack.push("Dos");
        stack.push("Tres");
        
        assertEquals("Tres", stack.pop());
    }
    
    @Test
    void pop_twice() {
        stack.push("Uno");
        stack.push("Dos");
        stack.push("Tres");
        stack.pop();
        
        assertEquals("Dos", stack.pop());
    }
    
    @Test
    void pop_fromEmptyStack() {
        assertThrows(NoSuchElementException.class, () -> stack.pop());
    }
    
    @Test
    void peek_once() {
        stack.push("Uno");
        stack.push("Dos");
        
        assertEquals("Dos", stack.peek());
    }
    
    @Test
    void peek_twice() {
        stack.push("Uno");
        stack.push("Dos");
        stack.peek();
        
        assertEquals("Dos", stack.peek());
    }
    
    @Test
    void toString_emptyCollection() {
        assertEquals("{}", stack.toString());
    }
    
    @Test
    void toString_notEmptyCollection() {
        stack.push("Uno");
        stack.push("Dos");
        
        assertEquals("{Dos, Uno}", stack.toString());
    }
    
}
