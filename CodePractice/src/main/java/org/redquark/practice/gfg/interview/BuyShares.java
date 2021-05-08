package org.redquark.practice.gfg.interview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Anirudh Sharma
 * <p>
 * A person wants to the buy the shares at price m$/share. The shares has the following behaviour
 * a)The price of the share remains same through out the date
 * b)At the end of the day the share price either reduces by 1$ or become double
 * <p>
 * calculate the minimum number of days after which he will be able to buy the shares of
 * company given the price of the share on Day 0 is n$/share
 * <p>
 * input format:
 * the input consists of 2 lines each containing an integer. First line denotes n,
 * intial price of the stock and next line denotes m the price at which the person wants to buy the stock.
 * <p>
 * constraints 0 < n,m <= 10000
 * <p>
 * sample test cases:
 * <p>
 * input1:
 * 10
 * 1
 * output
 * 9
 * <p>
 * input2:
 * 3
 * 4
 * output2:
 * 2
 */
public class BuyShares {

    private static int calculateDays(int n, int m) {
        // Number of days required
        int numberOfDays = 0;
        // Queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        // Add price for day 0 in the queue
        queue.offer(n);
        // Loop until queue becomes empty
        while (!queue.isEmpty()) {
            // Get the current size of the queue
            int size = queue.size();
            // Loop until we get the value of m
            for (int i = 0; i < size; i++) {
                // Current value in the head of the queue
                Integer current = queue.poll();
                if (current != null) {
                    // Check if this value is equal to the m
                    if (current == m) {
                        return numberOfDays;
                    }
                    // Add price which is less than one
                    queue.offer(current - 1);
                    // Add price which is twice the previous price
                    queue.offer(2 * current);
                }
            }
            numberOfDays++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 10;
        int m = 1;
        System.out.println(calculateDays(n, m));

        n = 3;
        m = 4;
        System.out.println(calculateDays(n, m));
    }
}
