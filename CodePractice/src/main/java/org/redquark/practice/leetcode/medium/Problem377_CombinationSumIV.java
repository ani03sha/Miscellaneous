package org.redquark.practice.leetcode.medium;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an integer array with all positive numbers and no duplicates, find the number of possible
 * combinations that add up to a positive integer target.
 * <p>
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 */
public class Problem377_CombinationSumIV {

    private static int combinationSum4(int[] numbers, int target) {
        int[] dp = new int[target + 1];
        Arrays.sort(numbers);
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n : numbers) {
                if (n > i) {
                    break;
                }
                dp[i] += dp[i - n];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        int target = 4;
        System.out.println(combinationSum4(numbers, target));
    }
}
