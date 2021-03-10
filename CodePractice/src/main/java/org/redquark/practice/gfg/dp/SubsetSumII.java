package org.redquark.practice.gfg.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a set of non-negative integers, and a value sum, return any one subset of the given set
 * with sum equal to given sum.
 */
public class SubsetSumII {

    private static List<Integer> howSumRecursively(int[] nums, int target) {
        List<Integer> combination = new ArrayList<>();
        return howSumRecursivelyHelper(nums, target, combination);
    }

    private static List<Integer> howSumRecursivelyHelper(int[] nums, int target, List<Integer> combination) {
        if (target == 0) {
            return combination;
        }
        if (target < 0) {
            return null;
        }
        for (int n : nums) {
            List<Integer> remainder = howSumRecursivelyHelper(nums, target - n, combination);
            if (remainder != null) {
                remainder.add(n);
                return remainder;
            }
        }
        return null;
    }

    private static List<Integer> howSumMemoization(int[] nums, int target) {
        List<Integer> combination = new ArrayList<>();
        Map<Integer, List<Integer>> lookup = new HashMap<>();
        return howSumMemoizationHelper(nums, target, combination, lookup);
    }

    private static List<Integer> howSumMemoizationHelper(int[] nums, int target, List<Integer> combination, Map<Integer, List<Integer>> lookup) {
        if (target == 0) {
            return combination;
        }
        if (target < 0) {
            return null;
        }
        if (lookup.containsKey(target)) {
            return lookup.get(target);
        }
        for (int n : nums) {
            List<Integer> remainder = howSumMemoizationHelper(nums, target - n, combination, lookup);
            if (remainder != null) {
                remainder.add(n);
                lookup.put(target, remainder);
                return remainder;
            }
        }
        lookup.put(target, null);
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3};
        int target = 7;
        long start = System.currentTimeMillis();
        List<Integer> combination = howSumRecursively(nums, target);
        long end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + combination);
        start = System.currentTimeMillis();
        combination = howSumMemoization(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + combination);

        nums = new int[]{5, 3, 4, 7};
        target = 7;
        start = System.currentTimeMillis();
        combination = howSumRecursively(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + combination);
        start = System.currentTimeMillis();
        combination = howSumMemoization(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + combination);

        nums = new int[]{2, 4};
        target = 17;
        start = System.currentTimeMillis();
        combination = howSumRecursively(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + combination);
        start = System.currentTimeMillis();
        combination = howSumMemoization(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + combination);

        nums = new int[]{2, 3, 5};
        target = 25;
        start = System.currentTimeMillis();
        combination = howSumRecursively(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + combination);
        start = System.currentTimeMillis();
        combination = howSumMemoization(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + combination);

        nums = new int[]{7, 14};
        target = 300;
        start = System.currentTimeMillis();
        combination = howSumRecursively(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + combination);
        start = System.currentTimeMillis();
        combination = howSumMemoization(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + combination);
    }
}
