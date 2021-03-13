package org.redquark.practice.gfg.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * <p>
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class WordBreak {

    private static boolean wordBreakRecursively(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        for (String word : wordDict) {
            if (s.indexOf(word) == 0) {
                String suffix = s.substring(word.length());
                if (wordBreakRecursively(suffix, wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean wordBreakMemoization(String s, List<String> wordDict) {
        Map<String, Boolean> lookup = new HashMap<>();
        return wordBreakMemoizationHelper(s, wordDict, lookup);
    }

    private static boolean wordBreakMemoizationHelper(String s, List<String> wordDict, Map<String, Boolean> lookup) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        if (lookup.containsKey(s)) {
            return lookup.get(s);
        }
        for (String word : wordDict) {
            if (s.indexOf(word) == 0) {
                String suffix = s.substring(word.length());
                if (wordBreakMemoizationHelper(suffix, wordDict, lookup)) {
                    lookup.put(s, true);
                    return true;
                }
            }
        }
        lookup.put(s, false);
        return false;
    }

    private static boolean wordBreakTabulation(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] lookup = new boolean[n + 1];
        lookup[0] = true;
        for (int i = 0; i <= n; i++) {
            if (lookup[i]) {
                String suffix = s.substring(i);
                for (String word : wordDict) {
                    if (i + word.length() <= n && suffix.indexOf(word) == 0) {
                        lookup[i + word.length()] = true;
                    }
                }
            }
        }
        return lookup[n];
    }

    public static void main(String[] args) {
        String s = "abcdef";
        List<String> wordDict = Arrays.asList("ab", "abc", "cd", "def", "abcd");
        long start = System.currentTimeMillis();
        boolean canConstruct = wordBreakRecursively(s, wordDict);
        long end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + canConstruct);
        start = System.currentTimeMillis();
        canConstruct = wordBreakMemoization(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output ismilliseconds and the output is: " + canConstruct);
        start = System.currentTimeMillis();
        canConstruct = wordBreakTabulation(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken using tabulation: " + (end - start) + " milliseconds and the output ismilliseconds and the output is: " + canConstruct);

        s = "skateboard";
        wordDict = Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar");
        start = System.currentTimeMillis();
        canConstruct = wordBreakRecursively(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + canConstruct);
        start = System.currentTimeMillis();
        canConstruct = wordBreakMemoization(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + canConstruct);
        start = System.currentTimeMillis();
        canConstruct = wordBreakTabulation(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken using tabulation: " + (end - start) + " milliseconds and the output ismilliseconds and the output is: " + canConstruct);

        s = "enterapotentpot";
        wordDict = Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t");
        start = System.currentTimeMillis();
        canConstruct = wordBreakRecursively(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + canConstruct);
        start = System.currentTimeMillis();
        canConstruct = wordBreakMemoization(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + canConstruct);
        start = System.currentTimeMillis();
        canConstruct = wordBreakTabulation(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken using tabulation: " + (end - start) + " milliseconds and the output ismilliseconds and the output is: " + canConstruct);

        s = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
        wordDict = Arrays.asList("e", "ee", "eee", "eeee", "eeeee");
        start = System.currentTimeMillis();
        canConstruct = wordBreakRecursively(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + canConstruct);
        start = System.currentTimeMillis();
        canConstruct = wordBreakMemoization(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + canConstruct);
        start = System.currentTimeMillis();
        canConstruct = wordBreakTabulation(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken using tabulation: " + (end - start) + " milliseconds and the output ismilliseconds and the output is: " + canConstruct);
    }
}
