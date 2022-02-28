package me.adamh.algorithm.graph;


import java.util.*;

@SuppressWarnings("unchecked")
public class DirectedGraph {
    private final LinkedList<Integer>[] adj;
    
    public DirectedGraph(int count) {
        adj = new LinkedList[count];
        
        for (int i = 0; i < count; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    
    public void addEdge(int vertex1, int vertex2) {
        adj[vertex1].add(vertex2);
    }
    
    public boolean hasCycleRecursive(int start) {
        boolean[] visited = new boolean[adj.length];
        boolean[] recStack = new boolean[adj.length];
        
        return hasCycleRecursive(start, visited, recStack);
    }
    
    private boolean hasCycleRecursive(int vertex, boolean[] visited, boolean[] recStack) {
        if (!visited[vertex]) {
            visited[vertex] = true;
            recStack[vertex] = true;
            
            for (int neighbor : adj[vertex]) {
                if (!visited[neighbor] && hasCycleRecursive(neighbor, visited, recStack)) {
                    return true;
                } else if (recStack[neighbor]) {
                    return true;
                }
            }
        }
        
        recStack[vertex] = false;
        return false;
    }
    
    public boolean hasCycle(int start) {
        // 0 -> unvisited, 1 -> visited & stacked, 2 -> visited & popped
        byte[] state = new byte[adj.length];
        Deque<Integer> stack = new LinkedList<>();
        stack.push(start);
        state[start] = 1;
        // Adding start's neighbors to handle the case when 'start' is part
        // of the cycle. Otherwise, 'start' would be popped immediately!
        adj[start].forEach(neighbor -> {
            stack.push(neighbor);
            state[neighbor] = 1;
        });
        
        while (!stack.isEmpty()) {
            int current = stack.pop();
            state[current] = 2;
            
            for (int neighbor : adj[current]) {
                if (state[neighbor] == 1) {
                    return true;
                }
                
                stack.push(neighbor);
                state[neighbor] = 1;
            }
        }
        
        return false;
    }
    
    public List<Integer> getCycle(int start) {
        // 0 -> unvisited, 1 -> visited & stacked, 2 -> visited & popped
        byte[] state = new byte[adj.length];
        Map<Integer, Integer> parentMap = new HashMap<>();
        Deque<Integer> stack = new java.util.LinkedList<>();
        stack.push(start);
        state[start] = 1;
        parentMap.put(start, -1);
        // Adding start's neighbors to handle the case when 'start' is part
        // of the cycle. Otherwise, 'start' would be popped immediately!
        adj[start].forEach(neighbor -> {
            stack.push(neighbor);
            state[neighbor] = 1;
            parentMap.put(neighbor, start);
        });
        
        while (!stack.isEmpty()) {
            int current = stack.pop();
            state[current] = 2;
            
            for (int neighbor : adj[current]) {
                if (state[neighbor] == 1) {
                    List<Integer> cycle = new ArrayList<>();
                    int cycleStart = current;
                    do {
                        cycle.add(current);
                        current = parentMap.get(current);
                    } while (current != cycleStart && current != -1);
                    
                    return cycle;
                }
                
                stack.push(neighbor);
                state[neighbor] = 1;
                parentMap.put(neighbor, current);
            }
        }
        
        return Collections.emptyList();
    }
    
    public int[] topologicalSort() {
        boolean[] visited = new boolean[adj.length];
        int[] order = new int[adj.length];
        int orderPosition = adj.length - 1;
        
        for (int vertex = 0; vertex < adj.length; vertex++) {
            if (!visited[vertex]) {
                orderPosition = topSortDFS(vertex, visited, order, orderPosition);
            }
        }
        
        return order;
    }
    
    private int topSortDFS(int vertex, boolean[] visited, int[] sorted, int pos) {
        visited[vertex] = true;
        
        for (int neighbor : adj[vertex]) {
            if (!visited[neighbor]) {
                pos = topSortDFS(neighbor, visited, sorted, pos);
            }
        }
        
        sorted[pos] = vertex;
        
        return pos - 1;
    }
    
    public int[] topologicalSortKahn() {
        int[] order = new int[adj.length];
        int[] inDegree = new int[adj.length];
        
        for (LinkedList<Integer> neighbors : adj) {
            for (int neighbor : neighbors) {
                inDegree[neighbor]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int vertex : inDegree) {
            if (inDegree[vertex] == 0) {
                queue.offer(vertex);
            }
        }
        
        int pos = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            order[pos++] = current;
            
            for (int neighbor : adj[current]) {
                if (--inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return order;
    }
    
    public int[] topSort() {
        Deque<Integer> sorted = new LinkedList<>();
        boolean[] visited = new boolean[adj.length];
        
        for (int vertex = 0; vertex < adj.length; vertex++) {
            if (!visited[vertex]) {
                topSortRecursive(vertex, visited, sorted);
            }
        }
        
        return sorted.stream().mapToInt(v -> v).toArray();
    }
    
    public void topSortRecursive(int vertex, boolean[] visited, Deque<Integer> sorted) {
        visited[vertex] = true;
        
        for (int neighbor : adj[vertex]) {
            if (!visited[neighbor]) {
                topSortRecursive(neighbor, visited, sorted);
            }
        }
        
        sorted.addFirst(vertex);
    }
    
}
