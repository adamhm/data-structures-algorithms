package me.adamh.algorithm.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {
    ArrayStack<String> arrayStack;
    
    @BeforeEach
    void setUp() {
        arrayStack = new ArrayStack<>();
    }
    
    @Test
    void iterator() {
        arrayStack.push("Uno");
        arrayStack.push("Dos");
        arrayStack.push("Tres");
        List<String> expectedList = List.of("Tres", "Dos", "Uno");
        List<String> actualList = new ArrayList<>();
        arrayStack.forEach(actualList::add);
        
        assertEquals(expectedList, actualList);
    }
    
    @Test
    void isEmpty_emptyCollection() {
        assertTrue(arrayStack.isEmpty());
    }
    
    @Test
    void isEmpty_notEmptyCollection() {
        arrayStack.push("Uno");
        assertFalse(arrayStack.isEmpty());
    }
    
    @Test
    void push() {
        arrayStack.push("Uno");
        arrayStack.push("Dos");
        assertEquals(2, arrayStack.size());
    }
    
    @Test
    void push_more_element_than_initial_capacity() {
        arrayStack.push("1");
        arrayStack.push("2");
        arrayStack.push("3");
        arrayStack.push("4");
        arrayStack.push("5");
        arrayStack.push("6");
        arrayStack.push("7");
        arrayStack.push("8");
        arrayStack.push("9");
        arrayStack.push("10");
        arrayStack.push("11");
        arrayStack.push("12");
        List<String> expectedList =
            List.of("12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1");
        List<String> actualList = new ArrayList<>();
        arrayStack.forEach(actualList::add);
        
        assertEquals(expectedList, actualList);
    }
    
    @Test
    void pop_once() {
        arrayStack.push("Uno");
        arrayStack.push("Dos");
        arrayStack.push("Tres");
        
        assertEquals("Tres", arrayStack.pop());
    }
    
    @Test
    void pop_twice() {
        arrayStack.push("Uno");
        arrayStack.push("Dos");
        arrayStack.push("Tres");
        arrayStack.pop();
        
        assertEquals("Dos", arrayStack.pop());
    }
    
    @Test
    void pop_fromEmptyStack() {
        assertThrows(NoSuchElementException.class, () -> arrayStack.pop());
    }
    
    @Test
    void peek_once() {
        arrayStack.push("Uno");
        arrayStack.push("Dos");
        
        assertEquals("Dos", arrayStack.peek());
    }
    
    @Test
    void peek_twice() {
        arrayStack.push("Uno");
        arrayStack.push("Dos");
        arrayStack.peek();
        
        assertEquals("Dos", arrayStack.peek());
    }
    
    @Test
    void toString_emptyCollection() {
        assertEquals("{}", arrayStack.toString());
    }
    
    @Test
    void toString_notEmptyCollection() {
        arrayStack.push("Uno");
        arrayStack.push("Dos");
        arrayStack.push("Tres");
        
        assertEquals("{Tres, Dos, Uno}", arrayStack.toString());
    }
    
    @Test
    void testMethod() {
        LinkedList<String> list = new LinkedList<>();
        list.add("Hello");
        list.add("World");
        System.out.println(list);
    
    }
}
