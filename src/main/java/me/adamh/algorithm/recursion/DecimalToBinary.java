package me.adamh.algorithm.recursion;

public class DecimalToBinary {
    
    public static String getBinary(int decimal, String result) {
        if (decimal == 0) {
            return result;
        }
        
        result = decimal % 2 + result;
        
        return getBinary(decimal / 2, result);
    }
    
}
