package org.redquark.practice.leetcode.easy;

/**
 * @author Anirudh Sharma
 * <p>
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class Problem415_AddStrings {

    private static String addStrings(String a, String b) {
        // Resultant string
        StringBuilder result = new StringBuilder();
        // Lengths of two strings
        int m = a.length() - 1;
        int n = b.length() - 1;
        // Carry
        int carry = 0;
        // Loop for all the characters in the string
        while (m >= 0 || n >= 0) {
            int sum = carry;
            // Check if characters are left in the first string
            if (m >= 0) {
                sum += a.charAt(m--) - '0';
            }
            // Check if characters are left in the second string
            if (n >= 0) {
                sum += b.charAt(n--) - '0';
            }
            // Add the sum's ones digit in the result
            result.insert(0, sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            result.insert(0, carry);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String a = "1234";
        String b = "4567";
        System.out.println("Sum: " + addStrings(a, b));
        a = "12342568840285456214578123425688402854562145783427";
        b = "1234256884028545621457812342568840285456214578123425688402854562145781234256884028545621457812342568840285456214578";
        System.out.println("Sum: " + addStrings(a, b));
    }
}
