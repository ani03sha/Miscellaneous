package org.redquark.practice.leetcode.hard;

/**
 * @author Anirudh Sharma
 * <p>
 * Alice and Bob continue their games with piles of stones. There are several stones
 * arranged in a row, and each stone has an associated value which is an integer given
 * in the array stoneValue.
 * <p>
 * Alice and Bob take turns, with Alice starting first. On each player's turn, that player
 * can take 1, 2 or 3 stones from the first remaining stones in the row.
 * <p>
 * The score of each player is the sum of values of the stones taken. The score of each
 * player is 0 initially.
 * <p>
 * The objective of the game is to end with the highest score, and the winner is the player
 * with the highest score and there could be a tie. The game continues until all the stones
 * have been taken.
 * <p>
 * Assume Alice and Bob play optimally.
 * <p>
 * Return "Alice" if Alice will win, "Bob" if Bob will win or "Tie" if they end the game
 * with the same score.
 * <p>
 * Constraints:
 * <p>
 * 1 <= values.length <= 50000
 * -1000 <= values[i] <= 1000
 */
public class Problem1406_StoneGameIII {

    private static String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MIN_VALUE;
            for (int j = 0, value = 0; j < 3 && i + j < n; j++) {
                value += stoneValue[i + j];
                dp[i] = Math.max(dp[i], value - dp[i + j + 1]);
            }
        }
        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    public static void main(String[] args) {
        System.out.println(stoneGameIII(new int[]{1, 2, 3, 7}));
        System.out.println(stoneGameIII(new int[]{1, 2, 3, -9}));
        System.out.println(stoneGameIII(new int[]{1, 2, 3, 6}));
        System.out.println(stoneGameIII(new int[]{1, 2, 3, -1, -2, -3, 7}));
        System.out.println(stoneGameIII(new int[]{-1, -2, -3}));
    }
}
