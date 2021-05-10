package org.redquark.practice.interview;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array of integers nums, find the maximum length of a subarray where the product of all
 * its elements is positive.
 * <p>
 * A subarray of an array is a consecutive sequence of zero or more values taken out of that array.
 * <p>
 * Return the maximum length of a subarray with positive product.
 */
public class PositiveProduct {

    private static int getMaxLength(int[] nums) {
        // Maximum length of the subarray
        int maxLength = 0;
        // Length of the array
        int n = nums.length;
        // Loop for all the elements in the array
        for (int i = 0; i < n; ) {
            // For handling zeros, we need to keep
            // start and end pointers that will divide
            // the entire array into parts separated
            // by zeros
            int start = i;
            while (start < n && nums[start] == 0) {
                start++;
            }
            int end = start;
            // Counter for negative numbers
            int negativeCount = 0;
            // Indices of the first negative and last
            // negative values
            int firstNegativeIndex = -1;
            int lastNegativeIndex = -1;
            while (end < n && nums[end] != 0) {
                // Handle negative values
                if (nums[end] < 0) {
                    negativeCount++;
                    // If we have encountered the negative
                    // value for the first time
                    if (firstNegativeIndex == -1) {
                        firstNegativeIndex = end;
                    }
                    lastNegativeIndex = end;
                }
                end++;
            }
            // If the negativeCount is even, we can consider
            // all the negative values
            if (negativeCount % 2 == 0) {
                maxLength = Math.max(maxLength, end - start);
            }
            // If the negative count is odd, then we will
            // ignore the first negative value or the last
            // negative value; whichever gives the maximum
            // length of the subarray
            else {
                if (firstNegativeIndex != -1) {
                    maxLength = Math.max(maxLength, end - firstNegativeIndex - 1);
                }
                if (lastNegativeIndex != -1) {
                    maxLength = Math.max(maxLength, lastNegativeIndex - start);
                }
            }
            i = end + 1;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, -2, -3, 4};
        System.out.println(getMaxLength(nums));

        nums = new int[]{0, 1, -2, -3, -4};
        System.out.println(getMaxLength(nums));

        nums = new int[]{-1, -2, -3, 0, 1};
        System.out.println(getMaxLength(nums));

        nums = new int[]{-1, 2};
        System.out.println(getMaxLength(nums));

        nums = new int[]{1, 2, 3, 5, -6, 4, 0, 10};
        System.out.println(getMaxLength(nums));
    }
}
