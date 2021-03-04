package org.redquark.practice.gfg;

import java.util.Arrays;

public class FibonacciSequence {

    private static final int[] lookup = new int[100];

    private static int recursive(int n) {
        if (n <= 1) {
            return n;
        }
        return recursive(n - 1) + recursive(n - 2);
    }

    private static int memoization(int n) {
        if (lookup[n] == -1) {
            if (n <= 1) {
                lookup[n] = n;
            } else {
                lookup[n] = memoization(n - 1) + memoization(n - 2);
            }
        }
        return lookup[n];
    }

    private static int tabulation(int n) {
        int[] table = new int[n + 1];
        table[0] = 0;
        table[1] = 1;
        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }

    public static void main(String[] args) {
        int n = 40;
        long start = System.currentTimeMillis();
        int result = recursive(n);
        long end = System.currentTimeMillis();
        System.out.println("Recursive result " + result + " calculated in: " + (end - start) + " seconds");

        Arrays.fill(lookup, -1);
        start = System.currentTimeMillis();
        result = memoization(n);
        end = System.currentTimeMillis();
        System.out.println("Memoization result " + result + " calculated in: " + (end - start) + " seconds");

        start = System.currentTimeMillis();
        result = tabulation(n);
        end = System.currentTimeMillis();
        System.out.println("Tabulation result " + result + " calculated in: " + (end - start) + " seconds");
    }
}
