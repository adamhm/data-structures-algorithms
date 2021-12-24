package me.adamh.algorithm.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    
    LinkedList<String> linkedList;
    
    @BeforeEach
    void setUp() {
        linkedList = new LinkedList<>();
    }
    
    @Test
    void add_oneElement() {
        linkedList.add("Hello");
        assertEquals("Hello", linkedList.removeFront());
    }
    
    @Test
    void add_multipleElements() {
        linkedList.addFront("World");
        linkedList.addFront("Hello");
        
        assertEquals("Hello", linkedList.removeFront());
    }
    
    @Test
    void reverse() {
        linkedList.add("First");
        linkedList.add("Second");
        linkedList.add("Third");
        linkedList.reverse();
        List<String> expectedList = List.of("Third", "Second", "First");
        List<String> actualList = new ArrayList<>();
        linkedList.forEach(actualList::add);
        
        assertEquals(expectedList, actualList);
    }
    
    @Test
    void reverse_oneElement() {
        linkedList.add("First");
        linkedList.reverse();
        List<String> expectedList = List.of("First");
        List<String> actualList = new ArrayList<>();
        linkedList.forEach(actualList::add);
        
        assertEquals(expectedList, actualList);
    }
    
    @Test
    void reverse_emptyList() {
        linkedList.reverse();
        List<String> expectedList = Collections.emptyList();
        List<String> actualList = new ArrayList<>();
        linkedList.forEach(actualList::add);
        
        assertEquals(expectedList, actualList);
    }
    
    @Test
    void iterator() {
        linkedList.add("Hello");
        linkedList.add("World");
        List<String> expectedList = List.of("Hello", "World");
        List<String> actualList = new ArrayList<>();
        linkedList.forEach(actualList::add);
        
        assertEquals(expectedList, actualList);
    }
    
    @Test
    void sizeIterative() {
        linkedList.add("Hello");
        linkedList.add("World");
        
        assertEquals(2, linkedList.sizeIterative());
    }
    
    @Test
    void size() {
        linkedList.add("Hello");
        linkedList.add("World");
        
        assertEquals(2, linkedList.size());
    }
    
    @Test
    void size_emptyList() {
        assertEquals(0, linkedList.size());
    }
    
    @Test
    void toString_withMultipleElements() {
        linkedList.add("Hello");
        linkedList.add("World!");
        assertEquals("{Hello, World!}", linkedList.toString());
    }
    
    @Test
    void toString_withOneElement() {
        linkedList.add("Element1");
        assertEquals("{Element1}", linkedList.toString());
    }
    
    @Test
    void toString_emptyCollection() {
        assertEquals("{}", linkedList.toString());
    }
    
}
