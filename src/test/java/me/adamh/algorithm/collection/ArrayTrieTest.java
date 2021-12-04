package me.adamh.algorithm.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTrieTest {
    
    ArrayTrie trie;
    
    @BeforeEach
    void setUp() {
        trie = new ArrayTrie();
    }
    
    @Test
    void isEmpty() {
        trie.insert("test");
        assertFalse(trie.isEmpty());
    }
    
    @Test
    void insert() {
        trie.insert("test");
        assertTrue(trie.find("test"));
    }
    
    @Test
    void find_existingWord() {
        trie.insert("test");
        assertTrue(trie.find("test"));
    }
    
    @Test
    void find_wordNotExists() {
        trie.insert("test");
        assertFalse(trie.find("set"));
    }
    
    @Test
    void find_wordsWithSamePrefix() {
        trie.insert("test");
        trie.insert("testimonial");
        assertTrue(trie.find("test"));
        assertTrue(trie.find("testimonial"));
    }
    
    @Test
    void find_notWholeWord() {
        trie.insert("testimonial");
        assertFalse(trie.find("testim"));
    }
    
    @Test
    void getSuggestions() {
        trie.insert("home");
        trie.insert("homework");
        trie.insert("homeless");
        trie.insert("shirt");
        trie.insert("rock");
        trie.insert("girl");
        trie.insert("boy");
        List<String> expected = List.of("home", "homeless", "homework");
        List<String> actual = trie.getSuggestions("hom");
        
        assertEquals(expected, actual);
    }
    
    @Test
    void getSuggestions_noResults() {
        trie.insert("home");
        trie.insert("homework");
        trie.insert("homeless");
        trie.insert("shirt");
        trie.insert("rock");
        trie.insert("girl");
        trie.insert("boy");
        List<String> expected = Collections.emptyList();
        List<String> actual = trie.getSuggestions("hox");
        
        assertEquals(expected, actual);
    }
    
}