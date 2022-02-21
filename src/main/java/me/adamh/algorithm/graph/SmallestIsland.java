package me.adamh.algorithm.graph;

public class SmallestIsland {
    
    private final char[][] grid;
    
    public SmallestIsland(char[][] grid) {
        this.grid = grid;
    }
    
    public int getSize() {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int minimumSize = Integer.MAX_VALUE;
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                int size = explore(row, col, visited);
                if (size != 0) {
                    minimumSize = Math.min(minimumSize, size);
                }
            }
        }
        
        return minimumSize == Integer.MAX_VALUE ? 0 : minimumSize;
    }
    
    private int explore(int row, int col, boolean[][] visited) {
        if (!isValidLand(row, col)) return 0;
        
        if (visited[row][col]) {
            return 0;
        }
        
        int size = 1;
        
        visited[row][col] = true;
        int[][] vectors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        for (int[] vector : vectors) {
            size += explore(row + vector[0], col + vector[1], visited);
        }
        
        return size;
    }
    
    private boolean isValidLand(int row, int col) {
        return row >= 0 && row < grid.length
            && col >= 0 && col < grid[0].length
            && grid[row][col] == 'L';
    }
    
}
