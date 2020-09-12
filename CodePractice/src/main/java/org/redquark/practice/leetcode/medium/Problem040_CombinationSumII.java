package org.redquark.practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique
 * combinations in candidates where the candidate numbers sums to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 */
public class Problem040_CombinationSumII {

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private static void dfs(int[] candidates, int index, int target,
                            List<Integer> temp, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i == index || candidates[i] != candidates[i - 1]) {
                temp.add(candidates[i]);
                dfs(candidates, i + 1, target - candidates[i], temp, result);
                temp.remove(temp.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));

        candidates = new int[]{2, 5, 2, 1, 2};
        target = 5;
        System.out.println(combinationSum2(candidates, target));
    }
}
