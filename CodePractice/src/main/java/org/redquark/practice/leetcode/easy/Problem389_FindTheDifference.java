package org.redquark.practice.leetcode.easy;

/**
 * @author Anirudh Sharma
 * <p>
 * Given two strings s and t which consist of only lowercase letters.
 * <p>
 * String t is generated by random shuffling string s and then add one more letter at a random position.
 * <p>
 * Find the letter that was added in t.
 */
public class Problem389_FindTheDifference {

    private static char findTheDifference(String s, String t) {
        char temp = 0;
        for (char c : s.toCharArray()) {
            temp ^= c;
        }
        for (char c : t.toCharArray()) {
            temp ^= c;
        }
        return temp;
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println("Extra character: " + findTheDifference(s, t));
        s = "a";
        t = "aa";
        System.out.println("Extra character: " + findTheDifference(s, t));
    }
}
