package org.redquark.practice.leetcode.medium;

/**
 * Alex and Lee continue their games with piles of stones. There are a number of piles
 * arranged in a row, and each pile has a positive integer number of stones piles[i].
 * <p>
 * The objective of the game is to end with the most stones.
 * <p>
 * Alex and Lee take turns, with Alex starting first.  Initially, M = 1.
 * <p>
 * On each player's turn, that player can take all the stones in the first X remaining piles,
 * where 1 <= X <= 2M.  Then, we set M = max(M, X).
 * <p>
 * The game continues until all the stones have been taken.
 * <p>
 * Assuming Alex and Lee play optimally, return the maximum number of stones Alex can get.
 * <p>
 * Constraints:
 * <p>
 * 1 <= piles.length <= 100
 * 1 <= piles[i] <= 10 ^ 4
 */
public class Problem1140_StoneGameII {

    private static int stoneGameII(int[] piles) {
        int n = piles.length;
        if (n == 0) {
            return 0;
        }
        int[] sum = new int[n + 1];
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 0; i < n; i++) {
            sum[i] = 0;
        }
        for (int i = n - 1; i >= 0; i--) {
            sum[i] = piles[i] + sum[i + 1];
        }
        for (int i = 0; i <= n; i++) {
            dp[i][n] = sum[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                for (int k = 1; k <= 2 * j && i + k <= n; k++) {
                    dp[i][j] = Math.max(dp[i][j], sum[i] - dp[i + k][Math.max(j, k)]);
                }
            }
        }
        return dp[0][1];
    }

    public static void main(String[] args) {
        System.out.println(stoneGameII(new int[]{2, 7, 9, 4, 4}));
    }
}
