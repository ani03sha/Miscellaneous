package org.redquark.practice.leetcode.hard;

/**
 * @author Anirudh Sharma
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * The array may contain duplicates.
 */
public class Problem154_FindMinimumInRotatedSortedArray {

    private static int findMin(int[] numbers) {
        // Start and end pointers
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            // Find the middle of start and end
            int middle = start + (end - start) / 2;
            // Check if the middle element is the smallest
            if (numbers[middle] == numbers[end]) {
                end--;
            } else if (numbers[middle] > numbers[end]) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }
        return numbers[end];
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println("Minimum element: " + findMin(numbers));
        numbers = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Minimum element: " + findMin(numbers));
    }
}
