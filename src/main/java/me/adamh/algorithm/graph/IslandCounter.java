package me.adamh.algorithm.graph;

public class IslandCounter {
    
    private char[][] grid;
    
    public IslandCounter(char[][] grid) {
        this.grid = grid;
    }
    
    public int getCount() {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (explore(row, col, visited)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean explore(int row, int col, boolean[][] visited) {
        if (!isValidLand(row, col)) return false;
        
        if (visited[row][col]) {
            return false;
        }
        
        visited[row][col] = true;
        int[][] vectors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        for (int[] vector : vectors) {
            explore(row + vector[0], col + vector[1], visited);
        }
        
        return true;
    }
    
    private boolean isValidLand(int row, int col) {
        return row >= 0 && row < grid.length
            && col >= 0 && col < grid[0].length
            && grid[row][col] == 'L';
    }
    
}
