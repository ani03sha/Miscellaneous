package org.redquark.practice.gfg.dp;

public class UglyNumbers {

    private static int getNthUglyNo(int n) {
        // Array to store the ugly numbers
        int[] ugly = new int[n];
        // The first ugly number will be 1
        ugly[0] = 1;
        // Variables to keep track of count of
        // numbers which are multiples of 2,3 and 5.
        int n2 = 0;
        int n3 = 0;
        int n5 = 0;
        // Variables to store the next multiples
        // of 2, 3 and 5
        int next2 = ugly[n2] * 2;
        int next3 = ugly[n3] * 3;
        int next5 = ugly[n5] * 5;
        // Next ugly number
        int nextUglyNumber = ugly[0];
        // Loop from 1 to n
        for (int i = 1; i < n; i++) {
            // Next ugly number
            nextUglyNumber = Math.min(next2, Math.min(next3, next5));
            ugly[i] = nextUglyNumber;
            // Check which index to increment
            if (nextUglyNumber == next2) {
                n2++;
                next2 = ugly[n2] * 2;
            }
            if (nextUglyNumber == next3) {
                n3++;
                next3 = ugly[n3] * 3;
            }
            if (nextUglyNumber == next5) {
                n5++;
                next5 = ugly[n5] * 5;
            }
        }
        return nextUglyNumber;
    }

    public static void main(String[] args) {
        System.out.println(getNthUglyNo(11));
        System.out.println(getNthUglyNo(150));
    }
}
