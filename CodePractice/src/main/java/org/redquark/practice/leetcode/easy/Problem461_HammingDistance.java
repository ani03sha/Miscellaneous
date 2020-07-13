package org.redquark.practice.leetcode.easy;

/**
 * @author Anirudh Sharma
 * <p>
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * <p>
 * Given two integers x and y, calculate the Hamming distance.
 */
public class Problem461_HammingDistance {

    private static int hammingDistance(int x, int y) {
        int counter = 0;
        while (x > 0 || y > 0) {
            counter += (x % 2) ^ (y % 2);
            x >>= 1;
            y >>= 1;
        }
        return counter;
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        System.out.println("Hamming distance between " + x + " and " + y + " is: " + hammingDistance(x, y));
    }
}
