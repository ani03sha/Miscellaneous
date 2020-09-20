package org.redquark.practice.leetcode.hard;

/**
 * @author Anirudh Sharma
 * <p>
 * On a 2-dimensional grid, there are 4 types of squares:
 * <p>
 * 1 represents the starting square.  There is exactly one starting square.
 * 2 represents the ending square.  There is exactly one ending square.
 * 0 represents empty squares we can walk over.
 * -1 represents obstacles that we cannot walk over.
 * <p>
 * Return the number of 4-directional walks from the starting square to the ending square,
 * that walk over every non-obstacle square exactly once.
 * <p>
 * Note:
 * <p>
 * 1 <= grid.length * grid[0].length <= 20
 */
public class Problem980_UniquePathsIII {

    private static int totalPaths;

    private static int uniquePathsIII(int[][] grid) {
        totalPaths = 0;
        // Dimensions of grid
        int m = grid.length;
        int n = grid[0].length;
        // Count all the zeros in the grid
        int totalZeros = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 0) {
                    totalZeros++;
                }
            }
        }
        // Call dfs as soon as we encounter 1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, totalZeros);
                }
            }
        }
        return totalPaths;
    }

    private static void dfs(int[][] grid, int i, int j, int totalZeros) {
        // Base condition
        if (i < 0 || j < 0
                || i > grid.length - 1 || j > grid[0].length - 1
                || grid[i][j] == -1
                || (grid[i][j] == 2 && totalZeros != 0)
                || grid[i][j] == Integer.MAX_VALUE) {
            return;
        }
        if (grid[i][j] == 2 && totalZeros == 0) {
            totalPaths++;
        }
        if (grid[i][j] == 0) {
            totalZeros--;
        }
        int temp = grid[i][j];
        grid[i][j] = Integer.MAX_VALUE;
        dfs(grid, i + 1, j, totalZeros);
        dfs(grid, i - 1, j, totalZeros);
        dfs(grid, i, j + 1, totalZeros);
        dfs(grid, i, j - 1, totalZeros);
        grid[i][j] = temp;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };
        System.out.println("Number of unique paths: " + uniquePathsIII(grid));

        grid = new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2}
        };
        System.out.println("Number of unique paths: " + uniquePathsIII(grid));

        grid = new int[][]{
                {0, 1},
                {2, 0}
        };
        System.out.println("Number of unique paths: " + uniquePathsIII(grid));
    }
}
