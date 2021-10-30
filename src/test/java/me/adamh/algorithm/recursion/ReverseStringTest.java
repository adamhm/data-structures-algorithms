package me.adamh.algorithm.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {
    
    @Test
    void reverse() {
        String str = "Hello, World";
        assertEquals("world", ReverseString.reverse("dlrow"));
        assertEquals("dlroW ,olleH", ReverseString.reverse(str));
    }
    
}