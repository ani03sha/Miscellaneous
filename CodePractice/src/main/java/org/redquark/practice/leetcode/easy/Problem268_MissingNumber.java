package org.redquark.practice.leetcode.easy;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 * <p>
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant
 * extra space complexity?
 */
public class Problem268_MissingNumber {

    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return (nums.length) * (nums.length + 1) / 2 - sum;
    }
}
