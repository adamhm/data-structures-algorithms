package me.adamh.algorithm.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallestIslandTest {
    
    @Test
    void getSize_mixed() {
        char[][] terrain = {
            {'W', 'L', 'W', 'W', 'L', 'W'},
            {'W', 'L', 'W', 'W', 'L', 'W'},
            {'W', 'L', 'W', 'W', 'W', 'W'},
            {'W', 'W', 'W', 'L', 'L', 'W'},
            {'L', 'L', 'W', 'L', 'L', 'W'},
            {'L', 'L', 'W', 'W', 'W', 'W'}
        };
        
        SmallestIsland island = new SmallestIsland(terrain);
        assertEquals(2, island.getSize());
    }
    
    @Test
    void getSize_noLand() {
        char[][] terrain = {
            {'W', 'W', 'W', 'W'},
            {'W', 'W', 'W', 'W'},
            {'W', 'W', 'W', 'W'},
            {'W', 'W', 'W', 'W'}
        };
        
        SmallestIsland island = new SmallestIsland(terrain);
        assertEquals(0, island.getSize());
    }
    
    @Test
    void getSize_noWater() {
        char[][] terrain = {
            {'L', 'L', 'L', 'L'},
            {'L', 'L', 'L', 'L'},
            {'L', 'L', 'L', 'L'},
            {'L', 'L', 'L', 'L'}
        };
        
        SmallestIsland island = new SmallestIsland(terrain);
        assertEquals(16, island.getSize());
    }
    
}