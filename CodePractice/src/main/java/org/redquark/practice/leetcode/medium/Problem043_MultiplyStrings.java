package org.redquark.practice.leetcode.medium;

/**
 * @author Anirudh Sharma
 * <p>
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2,
 * also represented as a string
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class Problem043_MultiplyStrings {

    private static String multiply(String a, String b) {
        // Resultant string
        StringBuilder result = new StringBuilder();
        // Lengths of strings
        int i = a.length();
        int j = b.length();
        // Position array
        int[] position = new int[i + j];
        // Loop for all the characters in the string
        for (int k = i - 1; k >= 0; k--) {
            for (int l = j - 1; l >= 0; l--) {
                int product = (a.charAt(k) - '0') * (b.charAt(l) - '0');
                // Positions
                int p1 = k + l;
                int p2 = k + l + 1;
                int sum = product + position[p2];
                position[p1] += sum / 10;
                position[p2] = sum % 10;
            }
        }
        // Loop for the position array
        for (int p : position) {
            if (!(result.length() == 0 && p == 0)) {
                result.append(p);
            }
        }
        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        String a = "2";
        String b = "3";
        System.out.println("Product of " + a + " and " + b + " is: " + multiply(a, b));
        a = "123";
        b = "456";
        System.out.println("Product of " + a + " and " + b + " is: " + multiply(a, b));
    }
}
