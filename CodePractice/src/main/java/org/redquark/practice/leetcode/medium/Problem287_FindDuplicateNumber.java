package org.redquark.practice.leetcode.medium;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least
 * one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * <p>
 * Note:
 * <p>
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class Problem287_FindDuplicateNumber {

    private static int findDuplicate(int[] numbers) {
        int slow = numbers[0];
        int fast = numbers[0];
        slow = numbers[slow];
        fast = numbers[numbers[fast]];
        while (slow != fast) {
            slow = numbers[slow];
            fast = numbers[numbers[fast]];
        }
        slow = numbers[0];
        while (slow != fast) {
            slow = numbers[slow];
            fast = numbers[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 3, 4, 2, 2};
        System.out.println("Duplicate number is: " + findDuplicate(numbers));
        numbers = new int[]{3, 1, 3, 4, 2};
        System.out.println("Duplicate number is: " + findDuplicate(numbers));
    }
}
