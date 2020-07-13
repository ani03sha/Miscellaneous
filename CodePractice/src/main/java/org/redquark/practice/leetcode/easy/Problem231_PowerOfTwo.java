package org.redquark.practice.leetcode.easy;

/**
 * @author Anirudh Sharma
 * Given an integer, write a function to determine if it is a power of two.
 */
public class Problem231_PowerOfTwo {

    private static boolean isPowerOfTwo(int n) {
        long i = 1;
        while (i < n) {
            i *= 2;
        }
        return i == n;
    }

    public static void main(String[] args) {
        System.out.println("16 is a power of 2: " + isPowerOfTwo(16));
        System.out.println("218 is a power of 2: " + isPowerOfTwo(218));
    }
}
