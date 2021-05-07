package org.redquark.practice.gfg.interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AddOne {

    private static List<Integer> add(List<Integer> nums) {
        // Length of the array
        int n = nums.size();
        // List to store the final result
        LinkedList<Integer> result = new LinkedList<>();
        // Get the last digit
        int lastDigit = nums.get(n - 1);
        // Add one to it
        lastDigit += 1;
        // Set this value in the list
        result.addFirst(lastDigit % 10);
        // Get the carry
        int carry = lastDigit / 10;
        // Loop for remaining digits
        for (int i = n - 2; i >= 0; i--) {
            lastDigit = carry + nums.get(i);
            result.addFirst(lastDigit % 10);
            carry = lastDigit / 10;
        }
        // If there is still a carry present
        if (carry == 1) {
            result.addFirst(1);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        System.out.println(add(nums));

        nums = Arrays.asList(9, 9, 9);
        System.out.println(add(nums));
    }
}
