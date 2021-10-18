package me.adamh.algorithm.other;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StringAlgorithms {
    
    public static long binaryToDecimal(String binary) {
        if (Objects.isNull(binary) || binary.isBlank()) {
            return 0L;
        }
        
        long result = 0;
        
        for (int tail = binary.length() - 1, i = tail; i >= 0; i--) {
            char character = binary.charAt(i);
            
            if (character != '1' && character != '0') {
                throw new IllegalArgumentException();
            }
            
            if (character == '1') {
                result += Math.pow(2, tail - i);
            }
        }
        
        return result;
    }
    
    public static boolean isAnagram(String s1, String s2) {
        if (Objects.isNull(s1) || Objects.isNull(s2) || s1.length() != s2.length()) {
            return false;
        }
        
        List<String> c1 = Arrays.stream(s1.split(""))
            .collect(Collectors.toList());
        List<String> c2 = Arrays.stream(s2.split(""))
            .collect(Collectors.toList());
        c1.removeAll(c2);
        
        return c1.isEmpty();
    }
    
    public static boolean isPalindrome(String string) {
        Objects.requireNonNull(string);
        
        StringBuilder builder = new StringBuilder(string);
        
        return builder.reverse().toString().equals(string);
    }
    
    public static String[] replace(String s1, String s2) {
        if (Objects.isNull(s1) || Objects.isNull(s2)) {
            throw new NullPointerException();
        }
        
        s1 = s1 + s2;
        s2 = s1.substring(0, s2.length());
        s1 = s1.substring(s2.length());
        
        return new String[]{s1, s2};
    }
    
    public static String reverse(String string) {
        if (Objects.isNull(string) || string.isBlank()) {
            return string;
        }
        
        StringBuilder builder = new StringBuilder(string);
        
        return builder.reverse().toString();
    }
    
    public static String reverse2(String string) {
        if (Objects.isNull(string) || string.isBlank()) {
            return string;
        }
        
        char[] chars = string.toCharArray();
        char[] reversedChars = new char[chars.length];
        
        for (int i = 0, length = chars.length; i < length; i++) {
            reversedChars[length - 1 - i] = chars[i];
        }
        
        return new String(reversedChars);
    }
    
}
