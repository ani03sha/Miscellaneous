package org.redquark.practice.leetcode.medium;

/**
 * @author Anirudh Sharma
 * <p>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * Constraints:
 * <p>
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 109.
 */
public class Problem062_UniquePaths {

    private static int uniquePaths(int m, int n) {
        // DP Array
        int[][] dp = new int[m][n];
        // For the first row
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        // For the first column
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // For the remaining columns
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println("Number of unique paths for " + m + "X" + n + " grid: " + uniquePaths(m, n));

        m = 3;
        n = 2;
        System.out.println("Number of unique paths for " + m + "X" + n + " grid: " + uniquePaths(m, n));

        m = 3;
        n = 3;
        System.out.println("Number of unique paths for " + m + "X" + n + " grid: " + uniquePaths(m, n));
    }
}
