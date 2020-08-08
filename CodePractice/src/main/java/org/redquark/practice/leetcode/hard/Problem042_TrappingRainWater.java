package org.redquark.practice.leetcode.hard;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining
 */
public class Problem042_TrappingRainWater {

    private static int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int sum = 0;
        // Left and right pointers
        int left = 0;
        int right = n - 1;
        // Left max and right max
        int leftMax = 0;
        int rightMax = 0;
        // Loop until the pointers meet
        while (left <= right) {
            if (height[left] < height[right]) {
                if (leftMax < height[left]) {
                    leftMax = height[left];
                } else {
                    sum += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    sum += rightMax - height[right];
                }
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped rain water in " + Arrays.toString(height) + " is: " + trap(height));
    }
}
