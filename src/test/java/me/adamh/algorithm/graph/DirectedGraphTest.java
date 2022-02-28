package me.adamh.algorithm.graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DirectedGraphTest {
    
    @Test
    void hasCycleRecursive_cyclicGraph() {
        DirectedGraph diGraph = new DirectedGraph(5);
        diGraph.addEdge(0, 1);
        diGraph.addEdge(0, 2);
        diGraph.addEdge(1, 2);
        diGraph.addEdge(1, 3);
        diGraph.addEdge(3, 4);
        diGraph.addEdge(4, 1);
        
        assertTrue(diGraph.hasCycleRecursive(0));
    }
    
    @Test
    void hasCycleRecursive_acyclicGraph() {
        DirectedGraph diGraph = new DirectedGraph(5);
        diGraph.addEdge(0, 1);
        diGraph.addEdge(0, 2);
        diGraph.addEdge(1, 2);
        diGraph.addEdge(1, 3);
        diGraph.addEdge(3, 4);
        
        assertFalse(diGraph.hasCycleRecursive(0));
    }
    
    @Test
    void hasCycle_cyclicGraph() {
        DirectedGraph diGraph = new DirectedGraph(5);
        diGraph.addEdge(0, 1);
        diGraph.addEdge(0, 2);
        diGraph.addEdge(1, 2);
        diGraph.addEdge(1, 3);
        diGraph.addEdge(3, 4);
        diGraph.addEdge(4, 1);
        
        assertTrue(diGraph.hasCycle(0));
    }
    
    @Test
    void hasCycle_cyclicGraph2() {
        DirectedGraph diGraph = new DirectedGraph(5);
        diGraph.addEdge(0, 1);
        diGraph.addEdge(1, 2);
        diGraph.addEdge(2, 0);
        diGraph.addEdge(1, 3);
        diGraph.addEdge(3, 4);
        
        assertTrue(diGraph.hasCycle(0));
    }
    
    @Test
    void hasCycle_acyclicGraph() {
        DirectedGraph diGraph = new DirectedGraph(5);
        diGraph.addEdge(0, 1);
        diGraph.addEdge(0, 2);
        diGraph.addEdge(1, 2);
        diGraph.addEdge(1, 3);
        diGraph.addEdge(3, 4);
        
        assertFalse(diGraph.hasCycle(0));
    }
    
    @Test
    void getCycle_cyclicGraph() {
        DirectedGraph diGraph = new DirectedGraph(5);
        diGraph.addEdge(0, 1);
        diGraph.addEdge(0, 2);
        diGraph.addEdge(1, 2);
        diGraph.addEdge(1, 3);
        diGraph.addEdge(3, 4);
        diGraph.addEdge(4, 1);
        List<Integer> expected = List.of(1, 3, 4);
        List<Integer> actual = diGraph.getCycle(0);
        
        assertAll(
            () -> assertTrue(expected.containsAll(actual)),
            () -> assertTrue(actual.containsAll(expected))
        );
    }
    
    @Test
    void getCycle_cyclicGraph2() {
        DirectedGraph diGraph = new DirectedGraph(5);
        diGraph.addEdge(0, 1);
        diGraph.addEdge(1, 2);
        diGraph.addEdge(2, 0);
        diGraph.addEdge(1, 3);
        diGraph.addEdge(3, 4);
        List<Integer> expected = List.of(0, 1, 2);
        List<Integer> actual = diGraph.getCycle(0);
        
        assertAll(
            () -> assertTrue(expected.containsAll(actual)),
            () -> assertTrue(actual.containsAll(expected))
        );
    }
    
    @Test
    void getCycle_acyclicGraph() {
        DirectedGraph diGraph = new DirectedGraph(5);
        diGraph.addEdge(0, 1);
        diGraph.addEdge(0, 2);
        diGraph.addEdge(1, 2);
        diGraph.addEdge(1, 3);
        diGraph.addEdge(3, 4);
        
        assertEquals(Collections.emptyList(), diGraph.getCycle(0));
    }
    
    @Test
    void topologicalSort() {
        DirectedGraph diGraph = new DirectedGraph(5);
        diGraph.addEdge(0, 1);
        diGraph.addEdge(0, 2);
        diGraph.addEdge(1, 2);
        diGraph.addEdge(1, 3);
        diGraph.addEdge(3, 4);
        int[] expected1 = {0, 1, 3, 4, 2};
        int[] expected2 = {0, 1, 2, 3, 4};
        int[] actual = diGraph.topologicalSort();
        
        assertTrue(Arrays.equals(expected1, actual) || Arrays.equals(expected2, actual));
    }
    
    @Test
    void topologicalSortKahn() {
        DirectedGraph diGraph = new DirectedGraph(5);
        diGraph.addEdge(0, 1);
        diGraph.addEdge(0, 2);
        diGraph.addEdge(1, 2);
        diGraph.addEdge(1, 3);
        diGraph.addEdge(3, 4);
        int[] expected1 = {0, 1, 3, 4, 2};
        int[] expected2 = {0, 1, 2, 3, 4};
        int[] actual = diGraph.topologicalSortKahn();
        System.out.println(Arrays.toString(actual));
        assertTrue(Arrays.equals(expected1, actual) || Arrays.equals(expected2, actual));
    }
    
    @Test
    void topSort() {
        DirectedGraph diGraph = new DirectedGraph(5);
        diGraph.addEdge(0, 1);
        diGraph.addEdge(0, 2);
        diGraph.addEdge(1, 2);
        diGraph.addEdge(1, 3);
        diGraph.addEdge(3, 4);
        int[] expected1 = {0, 1, 3, 4, 2};
        int[] expected2 = {0, 1, 2, 3, 4};
        int[] actual = diGraph.topSort();
        System.out.println(Arrays.toString(actual));
        assertTrue(Arrays.equals(expected1, actual) || Arrays.equals(expected2, actual));
    }
}
