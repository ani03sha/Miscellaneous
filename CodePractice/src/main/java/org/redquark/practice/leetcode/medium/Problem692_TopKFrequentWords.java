package org.redquark.practice.leetcode.medium;

import java.util.*;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a non-empty list of words, return the k most frequent elements.
 * <p>
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency,
 * then the word with the lower alphabetical order comes first.
 * <p>
 * Note:
 * 1. You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * 2. Input words contain only lowercase letters.
 * <p>
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 */
public class Problem692_TopKFrequentWords {

    private static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        Queue<String> maxHeap = new PriorityQueue<>((o1, o2) -> {
            if ((int) frequencyMap.get(o1) != frequencyMap.get(o2)) {
                return frequencyMap.get(o2) - frequencyMap.get(o1);
            }
            return o1.compareTo(o2);
        });
        maxHeap.addAll(frequencyMap.keySet());
        List<String> result = new ArrayList<>();
        while (k > 0) {
            String current = maxHeap.remove();
            result.add(current);
            k--;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        System.out.println("Top " + k + " frequent words are: " + topKFrequent(words, k));
        words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        k = 2;
        System.out.println("Top " + k + " frequent words are: " + topKFrequent(words, k));
    }
}
