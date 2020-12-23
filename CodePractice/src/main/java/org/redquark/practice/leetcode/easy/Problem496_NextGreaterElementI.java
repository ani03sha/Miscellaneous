package org.redquark.practice.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Anirudh Sharma
 * <p>
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of
 * nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * <p>
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
 * If it does not exist, output -1 for this number.
 * <p>
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 */
public class Problem496_NextGreaterElementI {

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Base condition
        if (nums1 == null || nums1.length == 0) {
            return nums1;
        }
        // Map to store next greatest element
        Map<Integer, Integer> nextGreatestElement = new HashMap<>();
        // This stack will store the elements from the nums2
        Stack<Integer> nums2Stack = new Stack<>();
        // Loop through nums2
        for (int n : nums2) {
            // Check if the stack is not empty and the top of
            // stack is less than the current element, we will store it
            // in the map
            while (!nums2Stack.isEmpty() && nums2Stack.peek() < n) {
                nextGreatestElement.put(nums2Stack.pop(), n);
            }
            // Add the current element to the stack
            nums2Stack.push(n);
        }
        // Now, loop through the nums1
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nextGreatestElement.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));

        nums1 = new int[]{2, 4};
        nums2 = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
}
