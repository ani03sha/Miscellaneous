package org.redquark.practice.leetcode.hard;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * <p>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Problem188_BestTimeToBuyStockIV {

    private static int maxProfit(int k, int[] prices) {
        if (prices.length < 2 || k < 1) {
            return 0;
        }
        if (k > prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                profit += Math.max(0, prices[i] - prices[i - 1]);
            }
            return profit;
        }
        // Buy array
        int[] buy = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        int[] sell = new int[k];
        for (int price : prices) {
            for (int j = 0; j < k; j++) {
                buy[j] = Math.max(buy[j], (j > 0 ? sell[j - 1] : 0) - price);
                sell[j] = Math.max(sell[j], buy[j] + price);
            }
        }
        return sell[k - 1];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{2, 4, 1};
        int k = 2;
        System.out.println("Max profit: " + maxProfit(k, prices));
        prices = new int[]{3, 2, 6, 5, 0, 3};
        k = 2;
        System.out.println("Max profit: " + maxProfit(k, prices));
    }
}
