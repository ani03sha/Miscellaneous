package org.redquark.practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array nums sorted in ascending order, return true if and only if you can split it into 1 or more subsequences
 * such that each subsequence consists of consecutive integers and has length at least 3.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 10000
 */
public class Problem659_SplitArrayIntoConsecutiveSubsequences {

    private static boolean isPossible(int[] numbers) {
        // Map that will store the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        // Appending frequency
        Map<Integer, Integer> appendingFrequency = new HashMap<>();
        // Loop through the array to find the frequency of each number
        for (int n : numbers) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
        // Loop again to create the subsequences
        for (int n : numbers) {
            // If n is completely used and no more instances of n are left
            if (frequencyMap.get(n) == 0) {
                // We don't have to do anything
                continue;
            }
            if (appendingFrequency.getOrDefault(n, 0) > 0) {
                // Append to existing sequence
                appendingFrequency.put(n, appendingFrequency.get(n) - 1);
                appendingFrequency.put(n + 1, appendingFrequency.getOrDefault(n + 1, 0) + 1);
            } else if (frequencyMap.getOrDefault(n + 1, 0) > 0
                    && frequencyMap.getOrDefault(n + 2, 0) > 0) {
                frequencyMap.put(n + 1, frequencyMap.get(n + 1) - 1);
                frequencyMap.put(n + 2, frequencyMap.get(n + 2) - 1);
                appendingFrequency.put(n + 3, appendingFrequency.getOrDefault(n + 3, 0) + 1);
            } else {
                return false;
            }
            frequencyMap.put(n, frequencyMap.get(n) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 3, 4, 5};
        System.out.println("Is it possible to split: " + isPossible(input));
        input = new int[]{1, 2, 3, 3, 4, 4, 5, 5};
        System.out.println("Is it possible to split: " + isPossible(input));
        input = new int[]{1, 2, 3, 4, 4, 5};
        System.out.println("Is it possible to split: " + isPossible(input));
    }
}
