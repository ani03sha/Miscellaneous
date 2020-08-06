package org.redquark.practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array target and an integer n. In each iteration, you will read a number from  list = {1,2,3..., n}.
 * <p>
 * Build the target array using the following operations:
 * <p>
 * Push: Read a new element from the beginning list, and push it in the array.
 * Pop: delete the last element of the array.
 * If the target array is already built, stop reading more elements.
 * You are guaranteed that the target array is strictly increasing, only containing numbers between 1 to n inclusive.
 * <p>
 * Return the operations to build the target array.
 * <p>
 * You are guaranteed that the answer is unique.
 */
public class Problem1441_BuiltArrayWithStackOperations {

    private static List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int temp = 0;
        for (int i = 1; temp != target.length; i++) {
            if (target[temp] == i) {
                result.add("Push");
                temp++;
            } else {
                result.add("Push");
                result.add("Pop");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] target = {1, 3};
        int n = 3;
        System.out.println(buildArray(target, n));
    }
}
