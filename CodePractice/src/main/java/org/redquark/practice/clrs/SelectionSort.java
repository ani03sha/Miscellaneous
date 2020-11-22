package org.redquark.practice.clrs;

import java.util.Arrays;

public class SelectionSort {

    private static int[] sort(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        for (int i = 0; i < A.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[minIndex] > A[j]) {
                    minIndex = j;
                }
            }
            int temp = A[minIndex];
            A[minIndex] = A[i];
            A[i] = temp;
        }
        return A;
    }

    private static int[] reverseSort(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        for (int i = 0; i < A.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[minIndex] < A[j]) {
                    minIndex = j;
                }
            }
            int temp = A[minIndex];
            A[minIndex] = A[i];
            A[i] = temp;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = new int[]{5, 2, 4, 6, 1, 3};
        System.out.println("Non-decreasing: " + Arrays.toString(sort(A)));
        System.out.println("Non-increasing " + Arrays.toString(reverseSort(A)));

        A = new int[]{};
        System.out.println("Non-decreasing: " + Arrays.toString(sort(A)));
        System.out.println("Non-increasing " + Arrays.toString(reverseSort(A)));

        A = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println("Non-decreasing: " + Arrays.toString(sort(A)));
        System.out.println("Non-increasing " + Arrays.toString(reverseSort(A)));

        A = new int[]{5, 4, 5, 4, 2, 3, 1, 2, 1, 4};
        System.out.println("Non-decreasing: " + Arrays.toString(sort(A)));
        System.out.println("Non-increasing " + Arrays.toString(reverseSort(A)));

        A = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        System.out.println("Non-decreasing: " + Arrays.toString(sort(A)));
        System.out.println("Non-increasing " + Arrays.toString(reverseSort(A)));
    }
}
