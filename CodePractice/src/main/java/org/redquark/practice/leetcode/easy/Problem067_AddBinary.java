package org.redquark.practice.leetcode.easy;

/**
 * @author Anirudh Sharma
 * <p>
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Constraints:
 * <p>
 * Each string consists only of '0' or '1' characters.
 * 1 <= a.length, b.length <= 10^4
 * Each string is either "0" or doesn't contain any leading zero.
 */
public class Problem067_AddBinary {

    private static String addBinary(String a, String b) {
        // Resultant string
        StringBuilder result = new StringBuilder();
        // Length of both the strings
        int i = a.length() - 1;
        int j = b.length() - 1;
        // Carry
        int carry = 0;
        // Loop for each character in the strings
        while (i >= 0 || j >= 0) {
            // Sum of both the bits
            int sum = carry;
            // Check if characters left in the first string
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            // Check if characters are left in the second string
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            // Bit to be stored
            result.insert(0, sum % 2);
            // Update the carry left
            carry = sum / 2;
        }
        // Check if we have carry left
        if (carry > 0) {
            result.insert(0, 1);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println("Sum of " + a + " and " + b + " is: " + addBinary(a, b));

        a = "1010";
        b = "1011";
        System.out.println("Sum of " + a + " and " + b + " is: " + addBinary(a, b));
    }
}
