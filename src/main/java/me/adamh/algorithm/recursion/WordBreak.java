package me.adamh.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreak {
    
    public static List<String> getWordList(Set<String> dictionary, String str) {
        return getWordList(dictionary, str, 0, new ArrayList<>());
    }
    
    public static String getWords(Set<String> dictionary, String str) {
        return String.join(" ", getWordList(dictionary, str));
    }
    
    private static List<String> getWordList(Set<String> dictionary, String str, int to, List<String> result) {
        if (to > str.length() - 1) {
            return result;
        }
        
        String word = str.substring(0, ++to);
        
        if (dictionary.contains(word.toLowerCase())) {
            result.add(word);
            return getWordList(dictionary, str.substring(to).trim(), 0, result);
        }
        
        return getWordList(dictionary, str, to, result);
    }
    
}
