package me.adamh.algorithm.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomQueueTest {
    
    RandomQueue<String> randomQueue;
    
    @BeforeEach
    void setUp() {
        randomQueue = new RandomQueue<>();
    }
    
    @Test
    void iterator() {
        randomQueue.enqueue("Uno");
        randomQueue.enqueue("Dos");
        randomQueue.enqueue("Tres");
        
        assertEquals(3, randomQueue.size());
        randomQueue.forEach(System.out::println);
        System.out.println(randomQueue.toString());
    }
    
    @Test
    void size_emptyCollection() {
        randomQueue.enqueue("Uno");
        randomQueue.dequeue();
        assertEquals(0, randomQueue.size());
    }
    
    
    @Test
    void size_notEmptyCollection() {
        randomQueue.enqueue("Uno");
        randomQueue.enqueue("Dos");
        assertEquals(2, randomQueue.size());
    }
    
    @Test
    void isEmpty_emptyCollection() {
        randomQueue.enqueue("Uno");
        randomQueue.dequeue();
        assertTrue(randomQueue.isEmpty());
    }
    
    @Test
    void isEmpty_notEmptyCollection() {
        randomQueue.enqueue("Uno");
        assertFalse(randomQueue.isEmpty());
    }
    
    @Test
    void enqueue() {
        randomQueue.enqueue("Uno");
        assertEquals(1, randomQueue.size());
        assertEquals("Uno", randomQueue.sample());
    }
    
    @Test
    void dequeue() {
        randomQueue.enqueue("Uno");
        
        assertEquals("Uno", randomQueue.dequeue());
        assertEquals(0, randomQueue.size());
    }
    
    @Test
    void sample() {
        randomQueue.enqueue("Uno");
        
        assertEquals("Uno", randomQueue.sample());
        assertEquals(1, randomQueue.size());
    }
    
    @Test
    void toString_notEmptyCollection() {
        randomQueue.enqueue("Uno");
        randomQueue.enqueue("Dos");
        randomQueue.enqueue("Tres");
        
        assertEquals("{Uno, Dos, Tres}", randomQueue.toString());
    }
    
    @Test
    void toString_emptyCollection() {
        assertEquals("{}", randomQueue.toString());
    }
    
}
