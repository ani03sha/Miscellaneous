package org.redquark.practice.gfg.interview;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a sorted array (sorted in non-decreasing order) of positive numbers,
 * find the smallest positive integer value that cannot be represented as
 * sum of elements of any subset of given set.
 */
public class FindSmallestInteger {

    private static int find(int[] nums) {
        // Smallest positive integer
        int smallest = 1;
        for (int i = 0; i < nums.length && nums[i] <= smallest; i++) {
            smallest += nums[i];
        }
        return smallest;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 5};
        System.out.println(find(nums));

        nums = new int[]{1, 2, 6, 10, 11, 15};
        System.out.println(find(nums));

        nums = new int[]{1, 1, 1, 1};
        System.out.println(find(nums));

        nums = new int[]{1, 1, 3, 4};
        System.out.println(find(nums));

    }
}
