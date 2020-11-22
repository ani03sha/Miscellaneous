package org.redquark.practice.dailybyte;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string, return whether or not it forms a palindrome ignoring case and non-alphabetical
 * characters.
 * Note: a palindrome is a sequence of characters that reads the same forwards and backwards.
 */
public class ValidPalindrome {

    private static boolean isValid(String s) {
        // Base condition
        if (s == null || s.isEmpty()) {
            return false;
        }
        // Remove all special characters and whitespace
        s = s.replaceAll("[^a-zA-Z]", "");
        // Convert all the characters in the string to one case only
        s = s.toLowerCase();
        // Two pointers
        int left = 0;
        int right = s.length() - 1;
        // Loop until the two pointers meet
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("level"));
        System.out.println(isValid("algorithms"));
        System.out.println(isValid("A man, a plan, a canal: Panama"));
    }
}
