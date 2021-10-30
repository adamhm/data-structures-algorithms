package me.adamh.algorithm.recursion;

public class ReverseString {
    
    public static String reverse(String string) {
        if (string.equals("")) {
            return "";
        }
        
        return reverse(string.substring(1)) + string.charAt(0);
    }
    
}
