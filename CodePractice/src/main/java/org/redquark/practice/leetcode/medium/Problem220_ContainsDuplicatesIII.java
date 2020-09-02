package org.redquark.practice.leetcode.medium;

import java.util.TreeSet;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array of integers, find out whether there are two distinct indices i and j in the array
 * such that the absolute difference between numbers[i] and numbers[j] is at most t and the absolute difference
 * between i and j is at most k.
 */
public class Problem220_ContainsDuplicatesIII {

    private static boolean containsNearbyAlmostDuplicate(int[] numbers, int k, int t) {
        if (numbers == null || numbers.length == 0) return false;
        TreeSet<Long> set = new TreeSet<>();
        set.add((long) numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            if (i > k) set.remove((long) numbers[i - k - 1]);//\\
            long left = (long) numbers[i] - t;
            long right = (long) numbers[i] + t;
            if (left <= right && !set.subSet(left, right + 1).isEmpty()) return true;
            set.add((long) numbers[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 1};
        int k = 3;
        int t = 0;
        System.out.println("Nearby numbers exists? " + containsNearbyAlmostDuplicate(numbers, k, t));
        numbers = new int[]{1, 0, 1, 1};
        k = 1;
        t = 2;
        System.out.println("Nearby numbers exists? " + containsNearbyAlmostDuplicate(numbers, k, t));
        numbers = new int[]{1, 5, 9, 1, 5, 9};
        k = 2;
        t = 3;
        System.out.println("Nearby numbers exists? " + containsNearbyAlmostDuplicate(numbers, k, t));
    }
}
