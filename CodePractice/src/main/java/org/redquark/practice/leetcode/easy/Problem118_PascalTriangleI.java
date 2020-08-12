package org.redquark.practice.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 */
public class Problem118_PascalTriangleI {

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> firstRow = Collections.singletonList(1);
        result.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            // Get the previous row
            List<Integer> previousRow = result.get(i - 1);
            // Current row
            List<Integer> currentRow = new ArrayList<>();
            // Add the first element
            currentRow.add(1);
            // Loop for remaining elements
            for (int j = 1; j < i; j++) {
                currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
            }
            currentRow.add(1);
            result.add(currentRow);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Rows: " + generate(5));
        System.out.println("Rows: " + generate(6));
        System.out.println("Rows: " + generate(0));
    }
}
