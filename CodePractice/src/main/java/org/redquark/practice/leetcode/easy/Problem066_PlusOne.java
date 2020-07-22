package org.redquark.practice.leetcode.easy;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element
 * in the array contains a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 */
public class Problem066_PlusOne {

    private static int[] plusOne(int[] digits) {
        // Length of the array
        int n = digits.length;
        // Loop for each digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        // Resultant array
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{1, 2, 3};
        System.out.println("Plus one yields to: " + Arrays.toString(plusOne(digits)));
        digits = new int[]{1, 9, 9, 9};
        System.out.println("Plus one yields to: " + Arrays.toString(plusOne(digits)));
    }
}
