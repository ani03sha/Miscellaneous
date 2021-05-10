package org.redquark.practice.interview;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array arr[] of size N, the task is to cut the entire array into a minimum number of subarrays
 * such that for each subarray, the GCD of the first and last element of the subarray is greater than 1
 */
public class MinimumCutsForGCD {

    private static int calculateCuts(int[] A) {
        // Length of the array
        int n = A.length;
        // Left and right pointers
        int left;
        int right = n - 1;
        // Count of cuts
        int cuts = 0;
        // Loop from right to left
        while (right >= 0) {
            for (left = 0; left <= right; left++) {
                // Find the GCD of left and right
                if (gcd(A[left], A[right]) > 1) {
                    cuts++;
                    right = left - 1;
                    break;
                }
                if (left == right && gcd(A[left], A[right]) == 1) {
                    return 0;
                }
            }
        }
        return cuts;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, b % a);
    }

    public static void main(String[] args) {
        int[] A = new int[]{2, 3, 4, 4, 4, 3};
        System.out.println(calculateCuts(A));
    }
}
