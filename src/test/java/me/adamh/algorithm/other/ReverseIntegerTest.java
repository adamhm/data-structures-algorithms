package me.adamh.algorithm.other;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {
    
    @Test
    void reverse_negativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> ReverseInteger.reverse(-1));
    }
    
    @Test
    void reverse_zero() {
        assertEquals(0, ReverseInteger.reverse(0));
    }
    
    @Test
    void reverseWithZeroAtTheEnd() {
        assertThrows(IllegalArgumentException.class, () -> ReverseInteger.reverse(200));
    }
    
    @Test
    void reverse_positiveNumberWith3Digits() {
        assertEquals(321, ReverseInteger.reverse(123));
    }
    
    @Test
    void reverse_positiveNumberWith1Digits() {
        assertEquals(3, ReverseInteger.reverse(3));
    }
    
    @Test
    void reverse_positiveNumberWith7digits() {
        assertEquals(3957362, ReverseInteger.reverse(2637593));
    }
    
    @Test
    void reverseWithNegatives_negativeWith2Digits() {
        assertEquals(-31, ReverseInteger.reverseWithNegatives(-13));
    }
    
    @Test
    void reverseWithNegatives_positiveWith2Digits() {
        assertEquals(31, ReverseInteger.reverseWithNegatives(13));
    }
    
    
    
}