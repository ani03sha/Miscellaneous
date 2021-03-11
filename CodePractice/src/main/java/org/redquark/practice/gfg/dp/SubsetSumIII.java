package org.redquark.practice.gfg.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a set of non-negative integers, and a value sum, return the shortest subset of the given set
 * with sum equal to given sum.
 */
public class SubsetSumIII {

    private static List<Integer> bestSumRecursively(int[] nums, int target) {
        return bestSumRecursivelyHelper(nums, target);
    }

    private static List<Integer> bestSumRecursivelyHelper(int[] nums, int target) {
        if (target == 0) {
            return new ArrayList<>();
        }
        if (target < 0) {
            return null;
        }
        List<Integer> shortestCombination = null;
        for (int n : nums) {
            List<Integer> currentCombination = bestSumRecursivelyHelper(nums, target - n);
            if (currentCombination != null) {
                currentCombination.add(n);
                if (shortestCombination == null || currentCombination.size() < shortestCombination.size()) {
                    shortestCombination = currentCombination;
                }
            }
        }
        return shortestCombination;
    }

    private static List<Integer> bestSumMemoization(int[] nums, int target) {
        Map<Integer, List<Integer>> lookup = new HashMap<>();
        return bestSumMemoizationHelper(nums, target, lookup);
    }

    private static List<Integer> bestSumMemoizationHelper(int[] nums, int target, Map<Integer, List<Integer>> lookup) {
        if (target == 0) {
            return new ArrayList<>();
        }
        if (target < 0) {
            return null;
        }
        if (lookup.containsKey(target)) {
            return lookup.get(target);
        }
        List<Integer> shortestCombination = null;
        for (int n : nums) {
            List<Integer> currentCombination = bestSumMemoizationHelper(nums, target - n, lookup);
            if (currentCombination != null) {
                List<Integer> updatedCurrentCombination = new ArrayList<>();
                updatedCurrentCombination.add(n);
                updatedCurrentCombination.addAll(currentCombination);
                if (shortestCombination == null || updatedCurrentCombination.size() < shortestCombination.size()) {
                    shortestCombination = updatedCurrentCombination;
                }
            }
        }
        lookup.put(target, shortestCombination);
        return shortestCombination;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 4, 7};
        int target = 7;
        long start = System.currentTimeMillis();
        List<Integer> shortestCombination = bestSumRecursively(nums, target);
        long end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + shortestCombination);
        start = System.currentTimeMillis();
        shortestCombination = bestSumMemoization(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + shortestCombination);

        nums = new int[]{2, 3, 5};
        target = 8;
        start = System.currentTimeMillis();
        shortestCombination = bestSumRecursively(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + shortestCombination);
        start = System.currentTimeMillis();
        shortestCombination = bestSumMemoization(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + shortestCombination);

        nums = new int[]{1, 4, 5};
        target = 8;
        start = System.currentTimeMillis();
        shortestCombination = bestSumRecursively(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + shortestCombination);
        start = System.currentTimeMillis();
        shortestCombination = bestSumMemoization(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + shortestCombination);

        nums = new int[]{1, 2};
        target = 4;
        start = System.currentTimeMillis();
        shortestCombination = bestSumRecursively(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + shortestCombination);
        start = System.currentTimeMillis();
        shortestCombination = bestSumMemoization(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + shortestCombination);

        nums = new int[]{1, 2, 5, 25};
        target = 50;
        start = System.currentTimeMillis();
        shortestCombination = bestSumRecursively(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + shortestCombination);
        start = System.currentTimeMillis();
        shortestCombination = bestSumMemoization(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + shortestCombination);
    }
}
