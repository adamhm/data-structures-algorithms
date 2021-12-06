package me.adamh.algorithm.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;

public class HashmapTrie {
    
    private final TrieNode root;
    
    public HashmapTrie() {
        root = new TrieNode();
    }
    
    public boolean isEmpty() {
        return root.children.isEmpty();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        
        for (char c : word.toCharArray()) {
            current = current.children.computeIfAbsent(c, chr -> new TrieNode());
        }
        
        current.isWord = true;
    }
    
    public boolean remove(String word) {
        TrieNode current = root;
        TrieNode lastCommonNode = root;
        char[] letters = word.toCharArray();
        char key = letters[0];
        BiPredicate<TrieNode, Integer> isLastCommonNode =
            (node, index) -> index != letters.length - 1 && (node.children.size() > 1 || node.isWord);
        
        for (int i = 0; i < letters.length; i++) {
            current = current.children.get(letters[i]);
            
            if (current == null) return false;
            
            if (isLastCommonNode.test(current, i)) {
                lastCommonNode = current;
                key = letters[i + 1];
            }
        }
        
        if (!current.isWord) return false;
        
        if (!current.children.isEmpty()) {
            current.isWord = false;
            return true;
        }
        
        lastCommonNode.children.remove(key);
        
        return true;
    }
    
    public void delete(String word) {
        delete(root, word, 0);
    }
    
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isWord) {
                return false;
            }
            current.isWord = false;
            return current.children.isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isWord;
        
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            return current.children.isEmpty();
        }
        return false;
    }
    
    public boolean find(String word) {
        TrieNode current = root;
        
        for (char c : word.toCharArray()) {
            current = current.children.get(c);
            if (current == null) return false;
        }
        
        return current.isWord;
    }
    
    public List<String> getSuggestions(String prefix) {
        List<String> results = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        TrieNode lastNode = root;
        
        for (char c : prefix.toCharArray()) {
            lastNode = lastNode.children.get(c);
            if (lastNode == null) {
                return results;
            }
            sb.append(c);
        }
        addSuggestions(lastNode, sb, results);
        
        return results;
    }
    
    private void addSuggestions(TrieNode node, StringBuilder prefix, List<String> results) {
        if (node.isWord) {
            results.add(prefix.toString());
        }
        
        if (node.children.isEmpty()) {
            return;
        }
        
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            addSuggestions(entry.getValue(), prefix.append(entry.getKey()), results);
            prefix.setLength(prefix.length() - 1);
        }
    }
    
    static class TrieNode {
        private final HashMap<Character, TrieNode> children;
        private boolean isWord;
        
        TrieNode() {
            children = new HashMap<>();
        }
        
    }
    
}
