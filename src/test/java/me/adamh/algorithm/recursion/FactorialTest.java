package me.adamh.algorithm.recursion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {
    
    @Test
    void get() {
        assertEquals(2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10,
            Factorial.get(10));
    }
}
