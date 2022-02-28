package me.adamh.algorithm.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UndirectedGraphTest {
    private UndirectedGraph graph;
    
    @BeforeEach
    public void setup() {
        graph = new UndirectedGraph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(5, 6);
        graph.addEdge(7, 7);
    }
    
    @Test
    void deepFirstSearch() {
        System.out.println("DFS:");
        graph.deepFirstSearch(0);
    }
    
    @Test
    void recursiveDFS() {
        System.out.println("Recursive DFS:");
        graph.recursiveDFS(0);
    }
    
    @Test
    void breadthFirstSearch() {
        System.out.println("BFS:");
        graph.breadthFirstSearch(0);
    }
    
    @Test
    void recursiveBFS() {
        System.out.println("Recursive BFS:");
        graph.recursiveBFS(0);
    }
    
    @Test
    void hasPath_validPath() {
        assertTrue(graph.hasPath(0, 4));
    }
    
    @Test
    void hasPath_invalidPath() {
        assertFalse(graph.hasPath(2, 5));
    }
    
    @Test
    void hasPathRecursive_validPath() {
        assertTrue(graph.hasPathRecursive(0, 4));
    }
    
    @Test
    void hasPathRecursive_invalidPath() {
        assertFalse(graph.hasPathRecursive(2, 5));
    }
    
    @Test
    void connectedComponents() {
        assertEquals(3, graph.connectedComponents());
    }
    
    @Test
    void connectedComponentsBFS() {
        assertEquals(3, graph.connectedComponentsBFS());
    }
    
    @Test
    void largestComponent() {
        assertEquals(5, graph.largestComponent());
    }
    
    @Test
    void largestComponentRecursive() {
        assertEquals(5, graph.largestComponentRecursive());
    }
    
    @Test
    void shortestPathDistance() {
        assertEquals(2, graph.shortestPathDistance(0, 4));
    }
    
    @Test
    void shortestPathDistance_noPath() {
        assertEquals(-1, graph.shortestPathDistance(0, 7));
    }
    
    @Test
    void shortestPathDistance_sourceEqualsTarget() {
        assertEquals(0, graph.shortestPathDistance(0, 0));
    }
    
    @Test
    void shortestPathDistance_multiplePaths() {
        assertEquals(1, graph.shortestPathDistance(0, 2));
    }
    
    @Test
    void shortestPathDistanceFrom4To3() {
        assertEquals(3, graph.shortestPathDistance(4, 3));
    }
    
    @Test
    void shortestPath() {
        List<Integer> expected = List.of(0, 2, 4);
        assertEquals(expected, graph.shortestPath(0, 4));
    }
    
    @Test
    void shortestPath_noPath() {
        assertNull(graph.shortestPath(0, 7));
    }
    
    @Test
    void getNodes() {
        graph = new UndirectedGraph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(0, 4);
        graph.addEdge(4, 5);
        graph.addEdge(1, 6);
        graph.addEdge(5, 6);
        graph.addEdge(3, 5);
        
        List<Integer> expected = List.of(3, 5, 6);
        List<Integer> actual = graph.getNodes(0, 2);
        
        assertEquals(expected.size(), actual.size());
        
        assertAll(
            () -> assertTrue(expected.containsAll(actual)),
            () -> assertTrue(actual.containsAll(expected))
        );
    }
    
    @Test
    void getNodes_noNodeInDistance() {
        graph = new UndirectedGraph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(0, 4);
        graph.addEdge(4, 5);
        graph.addEdge(1, 6);
        graph.addEdge(5, 6);
        graph.addEdge(3, 5);
        
        List<Integer> expected = Collections.emptyList();
        List<Integer> actual = graph.getNodes(0, 3);
        
        assertEquals(expected.size(), actual.size());
        
        assertAll(
            () -> assertTrue(expected.containsAll(actual)),
            () -> assertTrue(actual.containsAll(expected))
        );
    }
    
    @Test
    void hasCycle_noCycle() {
        graph = new UndirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        
        assertFalse(graph.hasCycle(0));
    }
    
    @Test
    void hasCycle_cycleExists() {
        graph = new UndirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        
        assertTrue(graph.hasCycle(0));
    }
    
}
