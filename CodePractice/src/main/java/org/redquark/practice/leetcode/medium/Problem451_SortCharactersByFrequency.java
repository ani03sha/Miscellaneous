package org.redquark.practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string, sort it in decreasing order based on the frequency of characters.
 */
public class Problem451_SortCharactersByFrequency {

    private static String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        Queue<Character> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            maxHeap.add(entry.getKey());
        }
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.remove();
            result.append(String.valueOf(c).repeat(Math.max(0, frequencyMap.get(c))));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println("Sorted string is: " + frequencySort(s));
        s = "cccaaa";
        System.out.println("Sorted string is: " + frequencySort(s));
        s = "Aabb";
        System.out.println("Sorted string is: " + frequencySort(s));
    }
}