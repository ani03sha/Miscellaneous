package org.redquark.practice.gfg.interview;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * An infinite array of 0s and 1s is given where every element is representing the city.A city marked with
 * 1 is infected.
 * <p>
 * The city at index 0 is always infected. A city with index i has value on a given day equal to the xor
 * of the values for cities with index i-1 and i for the previous day.
 * <p>
 * Initially, on day 1 only city with index 0 is infected. Given the nth day, the task is to find the
 * value of the generated binary number mod 1000000007 assuming that the initial city infected is the
 * least significant bit.
 */
public class GeneratedBinaryNumber {

    private static int find(int n) {
        int k = n % 8;
        if (k == 0) {
            return (int) (1L << (n - 1)) % 1000000007;
        }
        long a = 1L << (n - 1);
        long b = (3 * a) / 2;
        long c = (5 * a) / 4;
        long d = (3 * c) / 2;
        long e = (17 * a) / 16;
        long f = (3 * e) / 2;
        long g = (21 * a) / 16;
        long h = (1L << n) - 1;
        long[] nums = {-1, a, b, c, d, e, f, g, h};
        System.out.println(Arrays.toString(nums));
        return (int) (nums[n] % 1000000007);
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(find(n));

        n = 5;
        System.out.println(find(n));

        n = 7;
        System.out.println(find(n));
    }
}
