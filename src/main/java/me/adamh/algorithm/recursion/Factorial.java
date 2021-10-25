package me.adamh.algorithm.recursion;

public class Factorial {
    public static int get(int num) {
        return num == 1 ? 1 : num-- * get(num);
    }
}
