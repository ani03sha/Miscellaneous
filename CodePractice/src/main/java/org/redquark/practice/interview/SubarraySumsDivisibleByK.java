package org.redquark.practice.interview;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
 */
public class SubarraySumsDivisibleByK {

    private static int subarraysDivByK(int[] A, int K) {
        // Array to store the modulus of the cumulative sum
        int[] modulus = new int[K];
        // Cumulative sum
        int sum = 0;
        // Loop through the array
        for (int a : A) {
            sum += (a % K + K) % K;
            modulus[(sum % K)]++;
        }
        // Variable to store the result
        int count = modulus[0];
        // Loop through the modulus array
        for (int m : modulus) {
            count += m * (m - 1) / 2;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = new int[]{4, 5, 0, -2, -3, 1};
        int K = 5;
        System.out.println(subarraysDivByK(A, K));
    }
}
