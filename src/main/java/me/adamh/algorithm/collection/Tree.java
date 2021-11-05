package me.adamh.algorithm.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Tree {
    
    public static void main(String[] args) {
        TreeNode<String> nodeD = new TreeNode<>("d");
        TreeNode<String> nodeE = new TreeNode<>("e");
        TreeNode<String> nodeB = new TreeNode<>(nodeD, nodeE, "b");
        TreeNode<String> nodeF = new TreeNode<>("f");
        TreeNode<String> nodeC = new TreeNode<>(null, nodeF, "c");
        TreeNode<String> nodeA = new TreeNode<>(nodeB, nodeC, "a");
        nodeA.left = nodeB;
        //printNodesStackDF(nodeA);
        //printNodesRecursiveDF(nodeA);
        //printNodesBreadthFirst(nodeA);
        //printNodesBFRecursive(nodeA);
        System.out.println(includesBF(nodeA, "e"));
        System.out.println(includesBF(nodeA, "j"));
        System.out.println(includesDFRecursive(nodeA, "e"));
        System.out.println(includesDFRecursive(nodeA, "j"));
        TreeNode<Integer> intNodeD = new TreeNode<>(4);
        TreeNode<Integer> intNodeE = new TreeNode<>(5);
        TreeNode<Integer> intNodeB = new TreeNode<>(intNodeD, intNodeE, 2);
        TreeNode<Integer> intNodeF = new TreeNode<>(6);
        TreeNode<Integer> intNodeC = new TreeNode<>(null, intNodeF, 3);
        TreeNode<Integer> intNodeA = new TreeNode<>(intNodeB, intNodeC, 1);
        System.out.println(sumDF(intNodeA));
        System.out.println(sumBF(intNodeA));
        System.out.println("Min value: " + minValueIterative(intNodeA));
        System.out.println("Min value: " + minValueRecursive(intNodeA));
        System.out.println("Max root to leaf path sum: " + maxPathSum(intNodeA));
    }
    
    public static int maxPathSum(TreeNode<Integer> node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        
        if (node.left == null && node.right == null) {
            return node.value;
        }
        
        int leftMax = maxPathSum(node.left);
        int rightMax = maxPathSum(node.right);
        
        return Math.max(leftMax, rightMax) + node.value;
    }
    
    public static int minValueIterative(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
        stack.push(root);
        int minValue = Integer.MAX_VALUE;
        
        while (!stack.isEmpty()) {
            TreeNode<Integer> node = stack.pop();
            if (node.value < minValue) {
                minValue = node.value;
            }
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        
        return minValue;
    }
    
    public static int minValueRecursive(TreeNode<Integer> node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        
        int leftMin = minValueRecursive(node.left);
        int rightMin = minValueRecursive(node.right);
        
        return Math.min(node.value, Math.min(leftMin, rightMin));
    }
    
    public static int sumBF(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        
        int result = 0;
        
        Deque<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
            result += node.value;
            
            if (node.left != null) {
                queue.offer(node.left);
            }
            
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        
        return result;
    }
    
    public static int sumDF(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        
        return root.value + sumDF(root.left) + sumDF(root.right);
    }
    
    public static boolean includesBF(TreeNode<String> root, String target) {
        Objects.requireNonNull(root);
        Deque<TreeNode<String>> queue = new ArrayDeque<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode<String> node = queue.poll();
            
            if (node.value.equals(target)) {
                return true;
            }
            
            if (node.left != null) {
                queue.offer(node.left);
            }
            
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        
        return false;
    }
    
    public static boolean includesDFRecursive(TreeNode<String> node, String target) {
        if (node == null) {
            return false;
        }
        
        if (target.equals(node.value)) {
            return true;
        }
        
        return includesDFRecursive(node.left, target)
            || includesDFRecursive(node.right, target);
    }
    
    public static void printNodesDepthFirst(TreeNode<String> root) {
        Deque<TreeNode<String>> stack = new ArrayDeque<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode<String> current = stack.pop();
            System.out.println(current.value);
            
            if (current.right != null)
                stack.push(current.right);
            if (current.left != null)
                stack.push(current.left);
        }
    }
    
    public static void printNodesRecursiveDF(TreeNode<String> root) {
        if (root == null) return;
        
        System.out.println(root.value);
        printNodesRecursiveDF(root.left);
        printNodesRecursiveDF(root.right);
    }
    
    public static void printNodesBreadthFirst(TreeNode<String> root) {
        Deque<TreeNode<String>> queue = new ArrayDeque<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode<String> current = queue.poll();
            System.out.println(current.value);
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }
    
    public static void printNodesBFRecursive(TreeNode<String> root) {
        Deque<TreeNode<String>> queue = new ArrayDeque<>();
        queue.offer(root);
        printNodesBFRecursive(queue);
    }
    
    private static void printNodesBFRecursive(Deque<TreeNode<String>> queue) {
        if (queue.isEmpty()) return;
        
        TreeNode<String> node = queue.poll();
        System.out.println(node.value);
        
        if (node.left != null) {
            queue.offer(node.left);
        }
        
        if (node.right != null) {
            queue.offer(node.right);
        }
        
        printNodesBFRecursive(queue);
    }
    
    static class TreeNode<T> {
        
        TreeNode<T> left;
        TreeNode<T> right;
        private final T value;
        
        public TreeNode(T element) {
            this.value = element;
            this.left = null;
            this.right = null;
        }
        
        public TreeNode(TreeNode<T> left, TreeNode<T> right, T element) {
            this.value = element;
            this.left = left;
            this.right = right;
        }
        
    }
    
}
