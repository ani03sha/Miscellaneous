package org.redquark.practice.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array of integers, find if the array contains any duplicates.
 * <p>
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 */
public class Problem217_ContainsDuplicatesI {

    private static boolean containsDuplicate(int[] numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (int n : numbers) {
            if (numberSet.contains(n)) {
                return true;
            } else {
                numberSet.add(n);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 1};
        System.out.println("Duplicates exist? " + containsDuplicate(numbers));
        numbers = new int[]{1, 2, 3, 4};
        System.out.println("Duplicates exist? " + containsDuplicate(numbers));
        numbers = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("Duplicates exist? " + containsDuplicate(numbers));
    }
}
