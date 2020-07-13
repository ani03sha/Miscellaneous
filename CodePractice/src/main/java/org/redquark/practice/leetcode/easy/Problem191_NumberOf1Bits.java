package org.redquark.practice.leetcode.easy;

/**
 * @author Anirudh Sharma
 * <p>
 * Write a function that takes an unsigned integer and return the number of '1' bits it has
 * (also known as the Hamming weight).
 * <p>
 * Note:
 * <p>
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be
 * given as signed integer type and should not affect your implementation, as the internal binary representation of the
 * integer is the same whether it is signed or unsigned.
 * <p>
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore,
 * in Example 3 above the input represents the signed integer -3.
 * <p>
 * Follow up:
 * <p>
 * If this function is called many times, how would you optimize it?
 */
public class Problem191_NumberOf1Bits {

    private static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Number of 1's in 11 are: " + hammingWeight(11));
        System.out.println("Number of 1's in 15 are: " + hammingWeight(15));
        System.out.println("Number of 1's in -3 are: " + hammingWeight(-3));
    }
}
