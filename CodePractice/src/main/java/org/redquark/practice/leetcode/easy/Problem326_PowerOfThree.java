package org.redquark.practice.leetcode.easy;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an integer, write a function to determine if it is a power of three.
 * <p>
 * Follow up:
 * Could you do it without using any loop / recursion?
 */
public class Problem326_PowerOfThree {

    private static boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
