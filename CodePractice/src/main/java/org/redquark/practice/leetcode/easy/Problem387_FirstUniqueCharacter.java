package org.redquark.practice.leetcode.easy;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
 * <p>
 * Note: You may assume the string contains only lowercase English letters.
 */
public class Problem387_FirstUniqueCharacter {

    private static int firstUniqueCharacter(String s) {
        int[] frequencyMap = new int[26];
        for (char c : s.toCharArray()) {
            frequencyMap[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            if (frequencyMap[c - 'a'] == 1) {
                return s.indexOf(c);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println("First unique character lies at index: " + firstUniqueCharacter(s));
        s = "loveleetcode";
        System.out.println("First unique character lies at index: " + firstUniqueCharacter(s));
        s = "abababcc";
        System.out.println("First unique character lies at index: " + firstUniqueCharacter(s));
    }
}
