package me.adamh.algorithm.recursion;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WordBreakTest {
    
    private static final Set<String> dictionary =
        Set.of("this", "sentence", "can", "break", "into", "words", "cat", "dog");
    
    @Test
    void getWords() {
        String original = "thissentencecanbreakintowords";
        String expected = "this sentence can break into words";
        
        assertEquals(expected, WordBreak.getWords(dictionary, original));
    }
    
    @Test
    void getWords_emptyString() {
        String original = "";
        
        assertEquals("", WordBreak.getWords(dictionary, original));
    }
    
    @Test
    void getWords_withWhitespace() {
        String original = "thissentence canbreakinto words";
        String expected = "this sentence can break into words";
        
        assertEquals(expected, WordBreak.getWords(dictionary, original));
    }
    
    @Test
    void getWords_withUpperAndLowerCaseLetters() {
        String original = "This Sentence CanBreakIntoWords";
        String expected = "This Sentence Can Break Into Words";
        
        assertEquals(expected, WordBreak.getWords(dictionary, original));
    }
    
    @Test
    void getWordList() {
        String original = "thissentencecanbreakintowords";
        List<String> expected =
            List.of("this", "sentence", "can", "break", "into", "words");
        
        assertEquals(expected, WordBreak.getWordList(dictionary, original));
    }
    
    @Test
    void getWordList_emptyString() {
        String original = "";
        
        assertEquals(Collections.emptyList(), WordBreak.getWordList(dictionary, original));
    }
    
    @Test
    void getWordList_withWhitespace() {
        String original = "thissentence canbreakinto words";
        List<String> expected =
            List.of("this", "sentence", "can", "break", "into", "words");
        
        assertEquals(expected, WordBreak.getWordList(dictionary, original));
    }
    
    @Test
    void getWordList_withUpperAndLowerCaseLetters() {
        String original = "This Sentence CanBreakIntoWords";
        List<String> expected =
            List.of("This", "Sentence", "Can", "Break", "Into", "Words");
        
        assertEquals(expected, WordBreak.getWordList(dictionary, original));
    }
    
}