package org.redquark.practice.leetcode.easy;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Problem136_SingleNumber {

    private static int singleNumber(int[] numbers) {
        int temp = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            temp ^= numbers[i];
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 2, 1};
        System.out.println("Single number is: " + singleNumber(input));
        input = new int[]{4, 1, 2, 1, 2};
        System.out.println("Single number is: " + singleNumber(input));
    }
}
