package org.redquark.practice.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Anirudh Sharma
 * <p>
 * en a circular array (the next element of the last element is the first element of the array),
 * print the Next Greater Number for every element.
 * The Next Greater Number of a number x is the first greater number to its traversing-order next
 * in the array, which means you could search circularly to find its next greater number.
 * If it doesn't exist, output -1 for this number.
 */
public class Problem503_NextGreaterElementII {

    private static int[] nextGreaterElements(int[] nums) {
        // Length of the given array
        int n = nums.length;
        // Output array
        int[] nextElement = new int[n];
        // Fill the array with the initial values
        Arrays.fill(nextElement, -1);
        // Stack to store the indices of nums
        Stack<Integer> indices = new Stack<>();
        // Loop through the nums array
        for (int i = 0; i < 2 * n; i++) {
            // Check if the stack is not empty and the top of
            // stack is less than the element at i % n
            while (!indices.isEmpty() && nums[indices.peek()] < nums[i % n]) {
                nextElement[indices.pop()] = nums[i % n];
            }
            if (i < n) {
                indices.push(i);
            }
        }
        return nextElement;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
    }
}
