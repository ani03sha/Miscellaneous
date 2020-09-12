package org.redquark.practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * <p>
 * Constraints:
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * Each element of candidate is unique.
 * 1 <= target <= 500
 */
public class Problem039_CombinationSum {

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(candidates, 0, target, 0, temp, result);
        return result;
    }

    private static void dfs(int[] candidates, int start, int target, int sum,
                            List<Integer> temp, List<List<Integer>> result) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            dfs(candidates, i, target, sum + candidates[i], temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));

        candidates = new int[]{2, 3, 5};
        target = 8;
        System.out.println(combinationSum(candidates, target));
    }
}
