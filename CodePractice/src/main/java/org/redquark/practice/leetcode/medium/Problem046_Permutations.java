package org.redquark.practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a collection of distinct integers, return all possible permutations.
 */
public class Problem046_Permutations {

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            permutations.add(Collections.emptyList());
            return permutations;
        }
        findPermutations(0, nums, permutations);
        return permutations;
    }

    private static void findPermutations(int start, int[] nums, List<List<Integer>> permutations) {
        if (start == nums.length - 1) {
            List<Integer> currentList = new ArrayList<>();
            for (int n : nums) {
                currentList.add(n);
            }
            permutations.add(currentList);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            findPermutations(start + 1, nums, permutations);
            swap(nums, i, start);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
