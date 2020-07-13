package org.redquark.practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * Note:
 * <p>
 * 1. You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * 2. Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * 3. It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 * 4. You can return the answer in any order.
 */
public class Problem347_TopKFrequentElements {

    private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));

        maxHeap.addAll(frequencyMap.keySet());
        int[] result = new int[k];
        int index = 0;
        while (k > 0) {
            result[index] = maxHeap.remove();
            k--;
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        System.out.println("Top K frequent elements are: ");
        for (int i = 0; i < k; i++) {
            System.out.print(result[i] + "  ");
        }
    }
}
