package org.redquark.practice.leetcode.easy;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * <p>
 * Follow up: Could you solve it without loops/recursion?
 */
public class Problem342_PowerOfFour {

    private static boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        double i = Math.log(n) / Math.log(4);
        return i == Math.floor(i);
    }

    public static void main(String[] args) {
        System.out.println("256 is power of four: " + isPowerOfFour(256));
        System.out.println("1024 is power of four: " + isPowerOfFour(1024));
        System.out.println("2048 is power of four: " + isPowerOfFour(2048));
    }
}
