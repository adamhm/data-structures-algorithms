package me.adamh.algorithm.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    BinarySearchTree<String> bst;
    
    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
    }
    
    @Test
    void size() {
        bst.add("Joe");
        bst.add("Caroline");
        assertEquals(2, bst.size());
    }
    
    @Test
    void size_emptyBST() {
        assertEquals(0, bst.size());
    }
    
    @Test
    void add() {
        assertTrue(bst.add("Caroline"));
        assertEquals(1, bst.size());
    }
    
    @Test
    void add_duplicatedElement() {
        bst.add("Caroline");
        assertFalse(bst.add("Caroline"));
        assertEquals(1, bst.size());
    }
    
    @Test
    void getIterator_breadthFirst() {
        bst.add("Caroline");
        bst.add("Joe");
        bst.add("Alyssa");
        bst.add("Bernadette");
        bst.add("Adele");
        bst.add("Kathy");
        bst.add("Holly");
        Iterator<String> iterator = bst.getIterator(BinarySearchTree.TreeIterator.BREADTH_FIRST);
        List<String> actual = new ArrayList<>();
        
        while (iterator.hasNext()) {
            actual.add(iterator.next());
        }
        
        List<String> expected =
            List.of("Caroline", "Alyssa", "Joe", "Adele", "Bernadette", "Holly", "Kathy");
        
        assertEquals(expected, actual);
    }
    
    @Test
    void find_existingValue() {
        bst.add("Caroline");
        bst.add("Joe");
        bst.add("Alyssa");
        bst.add("Bernadette");
        bst.add("Adele");
        bst.add("Kathy");
        bst.add("Holly");
        assertNotNull(bst.find("Joe"));
    }
    
    @Test
    void find_notExistingValue() {
        bst.add("Caroline");
        bst.add("Joe");
        bst.add("Alyssa");
        
        assertNull(bst.find("Bernadette"));
    }
    
    @Test
    void find_emptyTree() {
        assertNull(bst.find("Bernadette"));
    }
    
    @Test
    void name() {
        assertEquals(Optional.of(Optional.of("STRING")),
            Optional
                .of("string")
                .map(s -> Optional.of("STRING")));
    }
    
}