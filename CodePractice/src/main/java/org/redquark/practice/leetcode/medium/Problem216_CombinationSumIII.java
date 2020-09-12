package org.redquark.practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh Sharma
 * <p>
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from
 * 1 to 9 can be used and each combination should be a unique set of numbers.
 * <p>
 * Note:
 * <p>
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 */
public class Problem216_CombinationSumIII {

    private static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0 || n <= 0) {
            return result;
        }
        dfs(1, n, 0, k, 0, new ArrayList<>(), result);
        return result;
    }

    private static void dfs(int start, int n, int counter, int k, int currentSum,
                            List<Integer> temp, List<List<Integer>> result) {
        if (counter > k) {
            return;
        }
        if (currentSum == n && counter == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (currentSum + i > n) {
                break;
            }
            temp.add(i);
            dfs(i + 1, n, counter + 1, k, currentSum + i, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
        System.out.println(combinationSum3(2, 8));
    }
}
