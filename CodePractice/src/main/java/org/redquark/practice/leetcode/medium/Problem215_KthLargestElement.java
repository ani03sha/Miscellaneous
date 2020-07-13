package org.redquark.practice.leetcode.medium;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Anirudh Sharma
 * <p>
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class Problem215_KthLargestElement {

    private static int findKthLargest(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int n : nums) {
            maxHeap.add(n);
        }
        while (k > 1) {
            maxHeap.remove();
            k--;
        }
        return maxHeap.remove();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println("The " + k + "th largest element is: " + findKthLargest(nums, k));

        nums = new int[]{3, 2, 1, 5, 6, 4};
        k = 2;
        System.out.println("The " + k + "th largest element is: " + findKthLargest(nums, k));
    }
}
