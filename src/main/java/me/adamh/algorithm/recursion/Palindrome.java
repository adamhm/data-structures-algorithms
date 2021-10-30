package me.adamh.algorithm.recursion;

import java.util.Objects;

public class Palindrome {
    
    public static boolean isPalindrome(String string) {
        Objects.requireNonNull(string);
        
        if (string.length() < 2) {
            return true;
        }
        
        return string.charAt(0) == string.charAt(string.length() - 1)
            && isPalindrome(string.substring(1, string.length() - 1));
    }
    
}
