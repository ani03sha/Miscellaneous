package org.redquark.practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh Sharma
 * <p>
 * For a non-negative integer X, the array-form of X is an array of its digits in left to right order.
 * For example, if X = 1231, then the array form is [1,2,3,1].
 * <p>
 * Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
 * <p>
 * Note：
 * <p>
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * If A.length > 1, then A[0] != 0
 */
public class Problem989_AddToArrayForm {

    private static List<Integer> addToArrayForm(int[] A, int K) {
        // Resultant list
        List<Integer> result = new ArrayList<>();
        // Length of the array
        int n = A.length;
        // Loop for the array
        for (int i = n - 1; i >= 0; i--) {
            result.add(0, (A[i] + K) % 10);
            K = (A[i] + K) / 10;
        }
        while (K > 0) {
            result.add(0, K % 10);
            K /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4};
        int K = 34;
        System.out.println("Sum: " + addToArrayForm(A, K).toString());
        A = new int[]{8, 9, 9, 6};
        K = 106;
        System.out.println("Sum: " + addToArrayForm(A, K).toString());
        A = new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        K = 1;
        System.out.println("Sum: " + addToArrayForm(A, K).toString());
        A = new int[]{0};
        K = 23;
        System.out.println("Sum: " + addToArrayForm(A, K).toString());
        A = new int[]{0};
        K = 10000;
        System.out.println("Sum: " + addToArrayForm(A, K).toString());
    }
}
