package org.redquark.practice.gfg.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set
 * with sum equal to given sum.
 */
public class SubsetSum {

    private static boolean canSumRecursively(int[] nums, int target) {
        if (target == 0) {
            return true;
        }
        for (int n : nums) {
            int remainder = target - n;
            if (remainder >= 0 && canSumRecursively(nums, remainder)) {
                return true;
            }
        }
        return false;
    }

    private static boolean canSumMemoization(int[] nums, int target) {
        Map<Integer, Boolean> lookup = new HashMap<>();
        return canSumMemoizationHelper(nums, target, lookup);
    }

    private static boolean canSumMemoizationHelper(int[] nums, int target, Map<Integer, Boolean> lookup) {
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }
        if (lookup.containsKey(target)) {
            return lookup.get(target);
        }
        for (int n : nums) {
            if (canSumMemoizationHelper(nums, target - n, lookup)) {
                lookup.put(target, true);
                return true;
            }
        }
        lookup.put(target, false);
        return false;
    }

    private static boolean canSumTabulation(int[] nums, int target) {
        boolean[] lookup = new boolean[target + 1];
        lookup[0] = true;
        for (int i = 0; i <= target; i++) {
            if (lookup[i]) {
                for (int n : nums) {
                    if (i + n <= target) {
                        lookup[i + n] = true;
                    }
                }
            }
        }
        return lookup[target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3};
        int target = 7;
        long start = System.currentTimeMillis();
        boolean ifPossible = canSumRecursively(nums, target);
        long end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + ifPossible);
        start = System.currentTimeMillis();
        ifPossible = canSumMemoization(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + ifPossible);
        start = System.currentTimeMillis();
        ifPossible = canSumTabulation(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken using tabulation: " + (end - start) + " milliseconds and the output is: " + ifPossible);

        nums = new int[]{5, 3, 4, 7};
        target = 7;
        start = System.currentTimeMillis();
        ifPossible = canSumRecursively(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + ifPossible);
        start = System.currentTimeMillis();
        ifPossible = canSumMemoization(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + ifPossible);
        start = System.currentTimeMillis();
        ifPossible = canSumTabulation(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken using tabulation: " + (end - start) + " milliseconds and the output is: " + ifPossible);

        nums = new int[]{2, 4};
        target = 17;
        start = System.currentTimeMillis();
        ifPossible = canSumRecursively(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + ifPossible);
        start = System.currentTimeMillis();
        ifPossible = canSumMemoization(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + ifPossible);
        start = System.currentTimeMillis();
        ifPossible = canSumTabulation(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken using tabulation: " + (end - start) + " milliseconds and the output is: " + ifPossible);

        nums = new int[]{2, 3, 5};
        target = 25;
        start = System.currentTimeMillis();
        ifPossible = canSumRecursively(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + ifPossible);
        start = System.currentTimeMillis();
        ifPossible = canSumMemoization(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + ifPossible);
        start = System.currentTimeMillis();
        ifPossible = canSumTabulation(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken using tabulation: " + (end - start) + " milliseconds and the output is: " + ifPossible);

        nums = new int[]{7, 14};
        target = 320;
        start = System.currentTimeMillis();
        ifPossible = canSumRecursively(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + ifPossible);
        start = System.currentTimeMillis();
        ifPossible = canSumMemoization(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + ifPossible);
        start = System.currentTimeMillis();
        ifPossible = canSumTabulation(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken using tabulation: " + (end - start) + " milliseconds and the output is: " + ifPossible);
    }
}
