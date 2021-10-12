package me.adamh.algorithm.other;

public class FindMinAndMax {
    
    private static class Result {
        
        final int min;
        final int max;
        
        private Result(int min, int max) {
            this.min = min;
            this.max = max;
        }
        
        public static Result of(int min, int max) {
            return new Result(min, max);
        }
        
    }
    
    public static void main(String[] args) {
        int[] array = {1, 3, 7, 9, 1, 2, 6, 8, 5, -3, 1, 0};
        
        Result result = findMinAndMax(array);
        System.out.printf("Min: %s, Max: %s%n", result.min, result.max);
    }
    
    private static Result findMinAndMax(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int number : array) {
            max = Math.max(number, max);
            min = Math.min(number, min);
        }
        
        return Result.of(min, max);
    }
    
}
