package org.redquark.practice.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class Problem003_LongestSubstringWithoutRepeatingCharacters {

    private static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (end < s.length()) {
            if (set.add(s.charAt(end))) {
                end++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Longest substring: " + lengthOfLongestSubstring(s));
        s = "bbbbb";
        System.out.println("Longest substring: " + lengthOfLongestSubstring(s));
        s = "pwwkew";
        System.out.println("Longest substring: " + lengthOfLongestSubstring(s));
        s = "aab";
        System.out.println("Longest substring: " + lengthOfLongestSubstring(s));
    }
}

