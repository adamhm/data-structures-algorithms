package me.adamh.algorithm.other;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringAlgorithmsTest {
    
    @Test
    void binaryToDecimal() {
        assertEquals(5L, StringAlgorithms.binaryToDecimal("101"));
        assertEquals(12L, StringAlgorithms.binaryToDecimal("1100"));
        assertThrows(IllegalArgumentException.class,
            () -> StringAlgorithms.binaryToDecimal("11x0"));
    }
    
    @Test
    void isAnagram() {
        String s1 = "top";
        String s2 = "pot";
        String s3 = "sun";
        String s4 = "son";
        
        assertTrue(StringAlgorithms.isAnagram(s1, s2));
        assertFalse(StringAlgorithms.isAnagram(s3, s4));
    }
    
    @Test
    void isPalindrome() {
        String s1 = "bob";
        String s2 = "joe";
        
        assertTrue(StringAlgorithms.isPalindrome(s1));
        assertFalse(StringAlgorithms.isPalindrome(s2));
    }
    
    @Test
    void replace() {
        String s1 = "world";
        String s2 = "hello";
        String[] actual = StringAlgorithms.replace(s1, s2);
        
        assertEquals("hello", actual[0]);
        assertEquals("world", actual[1]);
    }
    
    @Test
    void reverse() {
        String s1 = "temple";
        
        assertEquals("elpmet", StringAlgorithms.reverse(s1));
    }
    
    @Test
    void reverse2() {
        String s1 = "temple";
        
        assertEquals("elpmet", StringAlgorithms.reverse2(s1));
    }
    
}
