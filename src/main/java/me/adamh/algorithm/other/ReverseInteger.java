package me.adamh.algorithm.other;

public class ReverseInteger {
    
    public static int reverse(int number) {
        
        if (number < 0) {
            throw new IllegalArgumentException("Negative number");
        }
        
        if (number % 10 == 0 && number != 0) {
            throw new IllegalArgumentException("The number cannot be reversed (zero in the ones' place");
        }
        
        int result = 0;
        
        while (number != 0) {
            int digit = number % 10;
            number = number / 10;
            result = 10 * result + digit;
        }
        
        return result;
    }
    
    public static int reverseWithNegatives(int number) {
        if (number % 10 == 0 && number != 0) {
            throw new IllegalArgumentException("The number cannot be reversed (zero in the ones' place");
        }
        
        return number < 0 ? reverse(number * -1) * -1 : reverse(number);
    }
    
    public static int reverseRecursive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative number");
        }
        
        if (number % 10 == 0 && number != 0) {
            throw new IllegalArgumentException("The number cannot be reversed (zero in the ones' place");
        }
        
        return reverseRecursive(number, 0);
    }
    
    private static int reverseRecursive(int number, int result) {
        if (number == 0) return result;
        
        return reverseRecursive(number / 10, 10 * result + number % 10);
    }
    
}
