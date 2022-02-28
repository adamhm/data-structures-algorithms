package me.adamh.algorithm.graph;

import me.adamh.algorithm.collection.LinkedList;

import java.util.*;

@SuppressWarnings("unchecked")
public class UndirectedGraph {
    
    private final LinkedList<Integer>[] adj;
    
    public UndirectedGraph(int count) {
        adj = new LinkedList[count];
        
        for (int i = 0; i < count; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    
    public void addEdge(int vertex1, int vertex2) {
        adj[vertex1].add(vertex2);
        adj[vertex2].add(vertex1);
    }
    
    public void deepFirstSearch(int root) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(root);
        boolean[] visited = new boolean[adj.length];
        
        while (!stack.isEmpty()) {
            int current = stack.pop();
            
            if (!visited[current]) {
                System.out.println(current + " ");
                visited[current] = true;
                for (int neighbor : adj[current]) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
    
    public void recursiveDFS(int root) {
        recursiveDFS(root, new boolean[adj.length]);
    }
    
    private void recursiveDFS(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.println(vertex + " ");
        
        adj[vertex].forEach(neighbor -> {
            if (!visited[neighbor]) {
                recursiveDFS(neighbor, visited);
            }
        });
    }
    
    public void breadthFirstSearch(int root) {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[adj.length];
        queue.offer(root);
        visited[root] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            System.out.println(current + " ");
            adj[current].forEach(vertex -> {
                if (!visited[vertex]) {
                    queue.offer(vertex);
                    visited[vertex] = true;
                }
            });
        }
    }
    
    public void recursiveBFS(int root) {
        boolean[] visited = new boolean[adj.length];
        visited[root] = true;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(root);
        recursiveBFS(queue, visited);
    }
    
    private void recursiveBFS(Deque<Integer> queue, boolean[] visited) {
        if (queue.isEmpty()) {
            return;
        }
        
        int vertex = queue.poll();
        System.out.println(vertex + " ");
        
        adj[vertex].forEach(neighbor -> {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.offer(neighbor);
            }
        });
        
        recursiveBFS(queue, visited);
    }
    
    public boolean hasPath(int source, int target) {
        boolean[] visited = new boolean[adj.length];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        visited[source] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == target) {
                return true;
            }
            adj[current].forEach(vertex -> {
                if (!visited[vertex]) {
                    queue.add(vertex);
                    visited[vertex] = true;
                }
            });
        }
        
        return false;
    }
    
    public boolean hasPathRecursive(int source, int target) {
        return hasPathRecursive(source, target, new boolean[adj.length]);
    }
    
    private boolean hasPathRecursive(int source, int target, boolean[] visited) {
        if (source == target) {
            return true;
        }
        
        if (visited[source]) {
            return false;
        }
        
        visited[source] = true;
        
        for (int neighbor : adj[source]) {
            if (hasPathRecursive(neighbor, target, visited)) {
                return true;
            }
        }
        
        return false;
    }
    
    public int connectedComponents() {
        boolean[] visited = new boolean[adj.length];
        int count = 0;
        
        for (int i = 0; i < adj.length; i++) {
            if (explore(i, visited)) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean explore(int vertex, boolean[] visited) {
        if (visited[vertex]) return false;
        
        visited[vertex] = true;
        
        for (int neighbor : adj[vertex]) {
            explore(neighbor, visited);
        }
        
        return true;
    }
    
    public int connectedComponentsBFS() {
        int count = 0;
        boolean[] visited = new boolean[adj.length];
        Queue<Integer> queue = new java.util.LinkedList<>();
        
        for (int i = 0; i < adj.length; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            queue.offer(i);
            
            while (!queue.isEmpty()) {
                int current = queue.poll();
                
                adj[current].forEach(neighbor -> {
                    if (!visited[neighbor]) {
                        queue.offer(neighbor);
                        visited[neighbor] = true;
                    }
                });
            }
            
            count++;
        }
        
        return count;
    }
    
    public int largestComponent() {
        int largest = 0;
        boolean[] visited = new boolean[adj.length];
        Queue<Integer> queue = new java.util.LinkedList<>();
        
        for (int i = 0; i < adj.length; i++) {
            if (visited[i]) continue;
            
            int size = 0;
            visited[i] = true;
            queue.offer(i);
            
            while (!queue.isEmpty()) {
                int current = queue.poll();
                size++;
                
                adj[current].forEach(neighbor -> {
                    if (!visited[neighbor]) {
                        queue.offer(neighbor);
                        visited[neighbor] = true;
                    }
                });
            }
            
            if (size > largest) {
                largest = size;
            }
        }
        
        return largest;
    }
    
    public int largestComponentRecursive() {
        boolean[] visited = new boolean[adj.length];
        int largest = 0;
        
        for (int i = 0; i < adj.length; i++) {
            int size = exploreSize(i, visited);
            
            if (size > largest) {
                largest = size;
            }
        }
        
        return largest;
    }
    
    private int exploreSize(int vertex, boolean[] visited) {
        if (visited[vertex]) return 0;
        
        visited[vertex] = true;
        
        int size = 1; // this represents the current vertex
        
        for (int neighbor : adj[vertex]) {
            size += exploreSize(neighbor, visited);
        }
        
        return size;
    }
    
    public int shortestPathDistance(int start, int target) {
        boolean[] visited = new boolean[adj.length];
        int[] distance = new int[adj.length];
        Queue<Integer> queue = new java.util.LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            
            if (vertex == target) {
                return distance[vertex];
            }
            
            for (int neighbor : adj[vertex]) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    distance[neighbor] = distance[vertex] + 1;
                    visited[neighbor] = true;
                }
            }
        }
        
        return -1;
    }
    
    public List<Integer> shortestPath(int v1, int v2) {
        boolean[] visited = new boolean[adj.length];
        int[] parent = new int[adj.length];
        Queue<Integer> queue = new java.util.LinkedList<>();
        queue.add(v1);
        parent[v1] = -1;
        visited[v1] = true;
        
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            
            if (currentNode == v2) {
                return reconstructPath(parent, currentNode);
            }
            
            for (int neighbor : adj[currentNode]) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                    parent[neighbor] = currentNode;
                }
            }
        }
        
        return null;
    }
    
    private List<Integer> reconstructPath(int[] parent, int currentNode) {
        int curr = currentNode;
        List<Integer> path = new ArrayList<>();
        
        while (curr != -1) {
            path.add(curr);
            curr = parent[curr];
        }
        
        Collections.reverse(path);
        
        return path;
    }
    
    public List<Integer> getNodes(int vertex, int distance) {
        List<Integer> resultList = new ArrayList<>();
        boolean[] visited = new boolean[adj.length];
        int[] dist = new int[adj.length];
        Queue<Integer> queue = new java.util.LinkedList<>();
        queue.offer(vertex);
        dist[vertex] = 0;
        visited[vertex] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (dist[current] == distance) {
                resultList.add(current);
            }
            
            for (int neighbor : adj[current]) {
                if (!visited[neighbor] && dist[current] < distance) {
                    queue.add(neighbor);
                    dist[neighbor] = dist[current] + 1;
                    visited[neighbor] = true;
                }
            }
        }
        
        return resultList;
    }
    
    public boolean hasCycle(int start) {
        // 0 -> unvisited, 1 -> added, 2 -> visited
        byte[] state = new byte[adj.length];
        
        Queue<Integer> queue = new java.util.LinkedList<>();
        queue.offer(start);
        state[start] = 1; // added to the queue
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            state[current] = 2; // visited
            
            for (int neighbor : adj[current]) {
                switch (state[neighbor]) {
                    case 1:
                        return true; // CYCLE FOUND!
                    case 0:
                        queue.add(neighbor);
                        state[neighbor] = 1; //added
                    default:
                }
            }
        }
        
        return false;
    }
    
}
