package org.redquark.practice.gfg.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s and a dictionary of strings wordDict, count ways in which s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * <p>
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class WordBreakII {

    private static int countConstructRecursively(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) {
            return 1;
        }
        int totalCount = 0;
        for (String word : wordDict) {
            if (s.indexOf(word) == 0) {
                totalCount += countConstructRecursively(s.substring(word.length()), wordDict);
            }
        }
        return totalCount;
    }


    private static int countConstructMemoization(String s, List<String> wordDict) {
        Map<String, Integer> lookup = new HashMap<>();
        return countConstructMemoizationHelper(s, wordDict, lookup);
    }

    private static int countConstructMemoizationHelper(String s, List<String> wordDict, Map<String, Integer> lookup) {
        if (s == null || s.isEmpty()) {
            return 1;
        }
        if (lookup.containsKey(s)) {
            return lookup.get(s);
        }
        int totalCount = 0;
        for (String word : wordDict) {
            if (s.indexOf(word) == 0) {
                totalCount += countConstructMemoizationHelper(s.substring(word.length()), wordDict, lookup);
            }
        }
        lookup.put(s, totalCount);
        return totalCount;
    }

    private static int countConstructTabulation(String s, List<String> wordDict) {
        int n = s.length();
        int[] lookup = new int[n + 1];
        lookup[0] = 1;
        for (int i = 0; i <= n; i++) {
            if (lookup[i] != 0) {
                String suffix = s.substring(i);
                for (String word : wordDict) {
                    if (i + word.length() <= n && suffix.indexOf(word) == 0) {
                        lookup[i + word.length()] += lookup[i];
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
        int canConstruct = countConstructRecursively(s, wordDict);
        long end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + canConstruct);
        start = System.currentTimeMillis();
        canConstruct = countConstructMemoization(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + canConstruct);
        start = System.currentTimeMillis();
        canConstruct = countConstructTabulation(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken using tabulation: " + (end - start) + " milliseconds and the output is: " + canConstruct);

        s = "skateboard";
        wordDict = Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar");
        start = System.currentTimeMillis();
        canConstruct = countConstructRecursively(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + canConstruct);
        start = System.currentTimeMillis();
        canConstruct = countConstructMemoization(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + canConstruct);
        start = System.currentTimeMillis();
        canConstruct = countConstructTabulation(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken using tabulation: " + (end - start) + " milliseconds and the output is: " + canConstruct);

        s = "enterapotentpot";
        wordDict = Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t");
        start = System.currentTimeMillis();
        canConstruct = countConstructRecursively(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + canConstruct);
        start = System.currentTimeMillis();
        canConstruct = countConstructMemoization(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + canConstruct);
        start = System.currentTimeMillis();
        canConstruct = countConstructTabulation(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken using tabulation: " + (end - start) + " milliseconds and the output is: " + canConstruct);

        s = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
        wordDict = Arrays.asList("e", "ee", "eee", "eeee", "eeeee");
        start = System.currentTimeMillis();
        canConstruct = countConstructRecursively(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + canConstruct);
        start = System.currentTimeMillis();
        canConstruct = countConstructMemoization(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + canConstruct);
        start = System.currentTimeMillis();
        canConstruct = countConstructTabulation(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken using tabulation: " + (end - start) + " milliseconds and the output is: " + canConstruct);
    }
}
