package me.adamh.algorithm.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HashmapTrieTest {
    HashmapTrie trie;
    
    @BeforeEach
    void setUp() {
        trie = new HashmapTrie();
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
        List<String> expected = List.of("home", "homework", "homeless");
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
    
    @Test
    void remove() {
        trie.insert("homework");
        trie.remove("homework");
        assertFalse(trie.find("homework"));
    }
    
    @Test
    void remove_overlappingWords() {
        trie.insert("home");
        trie.insert("homework");
        
        trie.remove("homework");
        
        assertFalse(trie.find("homework"));
        assertTrue(trie.find("home"));
    }
    
    @Test
    void remove_overlappingWords2() {
        trie.insert("home");
        trie.insert("homework");
        
        trie.remove("home");
        
        assertFalse(trie.find("home"));
        assertTrue(trie.find("homework"));
    }
    
    @Test
    void remove_notFullWord() {
        trie.insert("home");
        trie.insert("homework");
        
        trie.remove("hom");
        
        assertTrue(trie.find("home"));
        assertTrue(trie.find("homework"));
    }
    
    @Test
    void remove_partialOverlapping() {
        trie.insert("home");
        trie.insert("homework");
        trie.insert("hospital");
        
        trie.remove("hospital");
        
        assertTrue(trie.find("home"));
        assertTrue(trie.find("homework"));
        assertFalse(trie.find("hospital"));
    }
    
    @Test
    void akarmi() {
        long n = count("abcbaba", 1);
        
        assertEquals(10, n);
    }
    
    private static long count(String s, int length) {
        long result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isValid(sub)) {
                    result++;
                } else if (sub.length() >= 3) {
                    break;
                }
            }
        }
        
        return result;
    }
    
    private static boolean isValid(String s) {
        boolean valid = true;
        int i = 0;
        
        while (i < s.length() / 2 && valid) {
            char c = s.charAt(i);
            if (s.charAt(i) != s.charAt(0) || s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                valid = false;
            }
            i++;
        }
        
        return valid;
    }
}