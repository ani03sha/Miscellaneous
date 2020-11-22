package org.redquark.practice.clrs;

import java.util.Arrays;

public class InsertionSort {

    private static int[] sort(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        for (int i = 1; i < A.length; i++) {
            int key = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > key) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = key;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = new int[]{5, 2, 4, 6, 1, 3};
        System.out.println(Arrays.toString(sort(A)));

        A = new int[]{};
        System.out.println(Arrays.toString(sort(A)));

        A = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(sort(A)));

        A = new int[]{5, 4, 5, 4, 2, 3, 1, 2, 1, 4};
        System.out.println(Arrays.toString(sort(A)));

        A = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        System.out.println(Arrays.toString(sort(A)));

    }
}
