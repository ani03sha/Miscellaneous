package org.redquark.practice.leetcode.easy;

/**
 * @author Anirudh Sharma
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 */
public class Problem121_BestTimeToBuyStocks {

    private static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int maxProfit = Integer.MIN_VALUE;
        int minValue = prices[0];
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - minValue);
            minValue = Math.min(minValue, price);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println("Maximum profit is: " + maxProfit(prices));
        prices = new int[]{7, 6, 4, 3, 1};
        System.out.println("Maximum profit is: " + maxProfit(prices));
    }
}
