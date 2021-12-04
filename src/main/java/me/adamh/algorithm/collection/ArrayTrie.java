package me.adamh.algorithm.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ArrayTrie {
    
    private final static int ENGLISH_ALPHABET_SIZE = 26;
    TrieNode root = new TrieNode();
    
    public boolean isEmpty() {
        return Arrays.stream(root.children).allMatch(Objects::isNull);
    }
    
    public void insert(String word) {
        TrieNode current = root;
        
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        
        current.isWord = true;
    }
    
    public boolean find(String word) {
        TrieNode current = root;
        
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        
        return current.isWord;
    }
    
    public List<String> getSuggestions(String prefix) {
        List<String> results = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        TrieNode current = root;
        
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            current = current.children[index];
            if (current == null) {
                return results;
            }
            sb.append(c);
        }
        
        addSuggestions(current, sb, results);
        
        return results;
    }
    
    private void addSuggestions(TrieNode node, StringBuilder prefix, List<String> results) {
        if (node.isWord) {
            results.add(prefix.toString());
        }
        
        if (Arrays.stream(node.children).allMatch(Objects::isNull)) {
            return;
        }
        
        for (int i = 0; i < node.children.length; i++) {
            if (Objects.nonNull(node.children[i])) {
                char c = (char) ('a' + i);
                addSuggestions(node.children[i], prefix.append(c), results);
                prefix.setLength(prefix.length() - 1);
            }
        }
    }
    
    static class TrieNode {
        private final TrieNode[] children = new TrieNode[ENGLISH_ALPHABET_SIZE];
        private boolean isWord;
        
    }
    
}
