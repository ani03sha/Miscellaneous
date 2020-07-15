package org.redquark.practice.leetcode.hard;

/**
 * @author Anirudh Sharma
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */
public class Problem123_BestTimeToBuyStocksIII {

    private static int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;
        for (int price : prices) {
            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy + price);
            secondBuy = Math.max(secondBuy, firstSell - price);
            secondSell = Math.max(secondSell, secondBuy + price);
        }
        return secondSell;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println("Maximum profit: " + maxProfit(prices));
        prices = new int[]{1, 2, 3, 4, 5};
        System.out.println("Maximum profit: " + maxProfit(prices));
        prices = new int[]{7, 6, 4, 3, 1};
        System.out.println("Maximum profit: " + maxProfit(prices));
    }
}
