package org.redquark.practice.interview;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array which contains integer values, we need to make all values of this array equal to some
 * integer value with minimum cost where the cost of changing an array value x to y is abs(x-y).
 */
public class MinimumCostToMakeArrayElementsEqual {

    private static int findCost(int[] nums) {
        // Length of the array
        int n = nums.length;
        int y = n % 2 == 1 ? nums[n / 2] : (nums[n / 2] + nums[(n - 1) / 2]) / 2;
        // Total cost
        int cost = 0;
        for (int x : nums) {
            cost += Math.abs(x - y);
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 100, 101};
        System.out.println(findCost(nums));

        nums = new int[]{4, 6};
        System.out.println(findCost(nums));
    }
}
