package me.adamh.algorithm.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IslandCounterTest {
    @Test
    void getCount_mixed() {
        char[][] terrain = {
            {'W', 'L', 'W', 'W', 'L', 'W'},
            {'W', 'L', 'W', 'W', 'L', 'W'},
            {'W', 'L', 'L', 'W', 'W', 'W'},
            {'W', 'W', 'W', 'L', 'L', 'W'},
            {'L', 'L', 'W', 'L', 'L', 'W'},
            {'L', 'L', 'W', 'W', 'W', 'W'}
        };
        
        IslandCounter counter = new IslandCounter(terrain);
        assertEquals(4, counter.getCount());
    }
    
    @Test
    void getCount_noLand() {
        char[][] terrain = {
            {'W', 'W', 'W', 'W'},
            {'W', 'W', 'W', 'W'},
            {'W', 'W', 'W', 'W'},
            {'W', 'W', 'W', 'W'}
        };
        
        IslandCounter counter = new IslandCounter(terrain);
        assertEquals(0, counter.getCount());
    }
    
    @Test
    void getCount_noWater() {
        char[][] terrain = {
            {'L', 'L', 'L', 'L'},
            {'L', 'L', 'L', 'L'},
            {'L', 'L', 'L', 'L'},
            {'L', 'L', 'L', 'L'}
        };
        
        IslandCounter counter = new IslandCounter(terrain);
        assertEquals(1, counter.getCount());
    }
}