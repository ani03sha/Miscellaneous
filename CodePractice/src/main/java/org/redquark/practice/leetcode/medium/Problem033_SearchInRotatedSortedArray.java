package org.redquark.practice.leetcode.medium;

/**
 * @author Anirudh Sharma
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index,
 * otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 */
public class Problem033_SearchInRotatedSortedArray {

    private static int search(int[] numbers, int target) {
        // Pointers
        int start = 0;
        int end = numbers.length - 1;
        // Loop for the entire array
        while (start <= end) {
            // Middle of the start and end
            int middle = start + (end - start) / 2;
            // Check if the middle element is the target
            if (numbers[middle] == target) {
                return middle;
            }
            if (numbers[start] <= numbers[middle]) {
                if (numbers[start] <= target && target < numbers[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            } else {
                if (numbers[middle] < target && target <= numbers[end]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println("Index: " + search(numbers, target));
        target = 3;
        System.out.println("Index: " + search(numbers, target));
    }
}
