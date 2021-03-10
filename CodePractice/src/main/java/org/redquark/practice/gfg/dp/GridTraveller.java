package org.redquark.practice.gfg.dp;

/**
 * Count all the possible paths from top left to bottom right of a mXn matrix with
 * the constraints that from each cell you can either move only to right or down
 */
public class GridTraveller {

    private static int numberOfPathsRecursive(int m, int n) {
        // Special case
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        return numberOfPathsRecursive(m - 1, n) + numberOfPathsRecursive(m, n - 1);
    }

    private static long numberOfPathsMemoization(int m, int n) {
        long[][] lookup = new long[m + 1][n + 1];
        return numberOfPathsMemoizationHelper(m, n, lookup);
    }

    private static long numberOfPathsMemoizationHelper(int m, int n, long[][] lookup) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        if (lookup[m][n] != 0) {
            return lookup[m][n];
        }
        lookup[m][n] = numberOfPathsMemoizationHelper(m - 1, n, lookup) +
                numberOfPathsMemoizationHelper(m, n - 1, lookup);
        return lookup[m][n];
    }

    public static void main(String[] args) {
        int m = 18;
        int n = 18;
        long start = System.currentTimeMillis();
        long totalPaths = numberOfPathsRecursive(m, n);
        long end = System.currentTimeMillis();
        System.out.println("Time taken for calculating " + totalPaths + " paths recursively: " + (end - start) + " milliseconds");

        start = System.currentTimeMillis();
        totalPaths = numberOfPathsMemoization(m, n);
        end = System.currentTimeMillis();
        System.out.println("Time taken for calculating " + totalPaths + " paths using memoization: " + (end - start) + " milliseconds");
    }
}
