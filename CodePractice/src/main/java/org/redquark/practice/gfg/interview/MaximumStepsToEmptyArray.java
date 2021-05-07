package org.redquark.practice.gfg.interview;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Anirudh Sharma
 * <p>
 * iven an array arr[] of size N. In each operation, pick an array element X and remove all array
 * elements in the range [X – 1, X + 1].
 * <p>
 * The task is to find the maximum number of steps required such that no coins left in the array.
 */
public class MaximumStepsToEmptyArray {

    private static int countSteps(int[] nums) {
        // Map to store the frequency of array elements
        Map<Integer, Integer> frequencyMap = new TreeMap<>();
        // Populate the map
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        // Number of steps required
        int steps = 0;
        // Traverse the map
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            // Get the smallest element of the map
            int min = entry.getKey();
            // If it's frequency is greater than 0
            if (entry.getValue() > 0) {
                // We will update the step count and remove min
                steps++;
                frequencyMap.replace(min, 0);
                // Do similar steps for min + 1
                if (frequencyMap.getOrDefault(min + 1, 0) > 0) {
                    frequencyMap.replace(min + 1, 0);
                }
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 3, 2, 6, 7, 4};
        System.out.println(countSteps(nums));

        nums = new int[]{6, 7, 5, 1};
        System.out.println(countSteps(nums));
    }
}
