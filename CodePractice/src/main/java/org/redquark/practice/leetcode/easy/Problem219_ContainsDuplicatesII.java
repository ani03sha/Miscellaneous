package org.redquark.practice.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j
 * in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
public class Problem219_ContainsDuplicatesII {

    private static boolean containsNearbyDuplicate(int[] numbers, int k) {
        Map<Integer, Integer> numbersMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbersMap.containsKey(numbers[i])) {
                int index = numbersMap.get(numbers[i]);
                if (Math.abs(i - index) <= k) {
                    return true;
                }
            }
            numbersMap.put(numbers[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 1};
        int k = 3;
        System.out.println("Duplicates exist? " + containsNearbyDuplicate(numbers, k));
        numbers = new int[]{1, 0, 1, 1};
        k = 1;
        System.out.println("Duplicates exist? " + containsNearbyDuplicate(numbers, k));
        numbers = new int[]{1, 2, 3, 1, 2, 3};
        k = 2;
        System.out.println("Duplicates exist? " + containsNearbyDuplicate(numbers, k));
    }
}
