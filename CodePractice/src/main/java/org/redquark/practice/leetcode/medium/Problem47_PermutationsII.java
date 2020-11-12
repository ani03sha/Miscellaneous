package org.redquark.practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem47_PermutationsII {

    private static List<List<Integer>> permuteUnique(int[] nums) {
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
        Set<Integer> unique = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (unique.contains(nums[i])) {
                continue;
            }
            unique.add(nums[i]);
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
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
        System.out.println(permuteUnique(new int[]{1, 2, 3}));
    }
}
