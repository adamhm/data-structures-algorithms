package me.adamh.algorithm.other;

public class DecimalToBinary {
    public static String getBinary(int decimal) {
        StringBuilder result = new StringBuilder();
        
        while (decimal != 0) {
            result.append(decimal % 2);
            decimal = decimal / 2;
        }
        
        return result.reverse().toString();
    }
    
}
