package me.adamh.algorithm.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    
    DoublyLinkedList<String> doublyLinkedList;
    
    @BeforeEach
    void setUp() {
        doublyLinkedList = new DoublyLinkedList<>();
    }
    
    @Test
    @DisplayName("Iterator returns the items in the right order")
    void iterator() {
        doublyLinkedList.add("Caroline");
        doublyLinkedList.add("John");
        List<String> expectedList = List.of("Caroline", "John");
        List<String> actualList = new ArrayList<>();
        doublyLinkedList.forEach(actualList::add);
        
        assertEquals(expectedList, actualList);
    }
    
    @Test
    void addFirst() {
        doublyLinkedList.add("Caroline");
        doublyLinkedList.addFirst("John");
        doublyLinkedList.forEach(System.out::println);
    }
    
    @Test
    void removeFirst() {
        doublyLinkedList.add("Caroline");
        doublyLinkedList.add("John");
        doublyLinkedList.forEach(System.out::println);
        assertAll(
            () -> assertEquals("Caroline", doublyLinkedList.removeFirst()),
            () -> assertEquals(1, doublyLinkedList.size())
        );
    }
    
    @Test
    void removeFirst_noElement() {
        assertNull(doublyLinkedList.removeFirst());
    }
    
    @Test
    void removeLast() {
        doublyLinkedList.add("Caroline");
        doublyLinkedList.add("John");
        doublyLinkedList.forEach(System.out::println);
        assertAll(
            () -> assertEquals("John", doublyLinkedList.removeLast()),
            () -> assertEquals(1, doublyLinkedList.size())
        );
    }
    
    @Test
    void removeLast_noElement() {
        assertAll(
            () -> assertNull(doublyLinkedList.removeLast()),
            () -> assertEquals(0, doublyLinkedList.size())
        );
    }
    
    @Test
    void isEmpty_emptyCollection() {
        doublyLinkedList.add("Caroline");
        doublyLinkedList.removeFirst();
        assertAll(
            () -> assertTrue(doublyLinkedList.isEmpty()),
            () -> assertEquals(0, doublyLinkedList.size())
        );
    }
    
    @Test
    void isEmpty_notEmptyCollection() {
        doublyLinkedList.add("Caroline");
        assertAll(
            () -> assertFalse(doublyLinkedList.isEmpty()),
            () -> assertEquals(1, doublyLinkedList.size())
        );
    }
    
    @Test
    void reverse() {
        doublyLinkedList.add("First");
        doublyLinkedList.add("Second");
        doublyLinkedList.add("Third");
        doublyLinkedList.reverse();
        List<String> expectedList = List.of("Third", "Second", "First");
        List<String> actualList = new ArrayList<>();
        doublyLinkedList.forEach(actualList::add);
        
        assertEquals(expectedList, actualList);
    }
    
    @Test
    void reverse_oneElement() {
        doublyLinkedList.add("First");
        doublyLinkedList.reverse();
        List<String> expectedList = List.of("First");
        List<String> actualList = new ArrayList<>();
        doublyLinkedList.forEach(actualList::add);
        
        assertEquals(expectedList, actualList);
    }
    
    @Test
    void reverse_emptyList() {
        doublyLinkedList.reverse();
        List<String> expectedList = Collections.emptyList();
        List<String> actualList = new ArrayList<>();
        doublyLinkedList.forEach(actualList::add);
        
        assertEquals(expectedList, actualList);
    }
}
