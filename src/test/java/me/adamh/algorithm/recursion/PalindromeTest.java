package me.adamh.algorithm.recursion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static me.adamh.algorithm.recursion.Palindrome.isPalindrome;

class PalindromeTest {
    
    @Test
    @DisplayName("The string is a real palindrome")
    void isPalindrome_realPalindrome() {
        assertTrue(isPalindrome("kayak"));
    }
    
    @Test
    @DisplayName("The string is not a palindrome")
    void isPalindrome_notPalindrome() {
        assertFalse(isPalindrome("king"));
    }
    
    @Test
    @DisplayName("The string is empty")
    void isPalindrome_emptyString() {
        assertTrue(isPalindrome(""));
    }
    
    @Test
    @DisplayName("The string contains one char")
    void isPalindrome_oneCharacter() {
        assertTrue(isPalindrome("8"));
    }
    
    @Test
    @DisplayName("The string is null")
    void isPalindrome_withNullArg() {
        assertThrows(NullPointerException.class,
            () -> isPalindrome(null));
    }
    
}