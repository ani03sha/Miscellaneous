package org.redquark.practice.gfg.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given a string s and a dictionary of strings wordDict, return all ways in which s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * <p>
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class WordBreakIII {

    private static List<List<String>> allConstructRecursively(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) {
            return Collections.singletonList(new ArrayList<>());
        }
        List<List<String>> totalWays = new ArrayList<>();
        for (String word : wordDict) {
            if (s.indexOf(word) == 0) {
                String suffix = s.substring(word.length());
                List<List<String>> suffixWays = allConstructRecursively(suffix, wordDict);
                suffixWays.forEach(a -> a.add(0, word));
                totalWays.addAll(suffixWays);
            }
        }
        return totalWays;
    }

    private static List<List<String>> allConstructMemoization(String s, List<String> wordDict) {
        Map<String, List<List<String>>> lookup = new HashMap<>();
        return allConstructMemoizationHelper(s, wordDict, lookup);
    }

    private static List<List<String>> allConstructMemoizationHelper(String s, List<String> wordDict, Map<String, List<List<String>>> lookup) {
        if (s == null || s.isEmpty()) {
            return Collections.singletonList(new ArrayList<>());
        }
        if (lookup.containsKey(s)) {
            return lookup.get(s);
        }
        List<List<String>> totalWays = new ArrayList<>();
        for (String word : wordDict) {
            if (s.indexOf(word) == 0) {
                String suffix = s.substring(word.length());
                List<List<String>> suffixWays = allConstructMemoizationHelper(suffix, wordDict, lookup)
                        .stream()
                        .map(ArrayList::new)
                        .collect(Collectors.toList());
                suffixWays.forEach(a -> a.add(0, word));
                totalWays.addAll(suffixWays);
            }
        }
        lookup.put(s, totalWays);
        return totalWays;
    }

    public static void main(String[] args) {
        String s = "abcdef";
        List<String> wordDict = Arrays.asList("ab", "abc", "cd", "def", "abcd");
        long start = System.currentTimeMillis();
        List<List<String>> allWays = allConstructRecursively(s, wordDict);
        long end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + allWays);
        start = System.currentTimeMillis();
        allWays = allConstructMemoization(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + allWays);

        s = "skateboard";
        wordDict = Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar");
        start = System.currentTimeMillis();
        allWays = allConstructRecursively(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + allWays);
        start = System.currentTimeMillis();
        allWays = allConstructMemoization(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + allWays);

        s = "enterapotentpot";
        wordDict = Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t");
        start = System.currentTimeMillis();
        allWays = allConstructRecursively(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + allWays);
        start = System.currentTimeMillis();
        allWays = allConstructMemoization(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + allWays);

        s = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
        wordDict = Arrays.asList("e", "ee", "eee", "eeee", "eeeee");
        start = System.currentTimeMillis();
        allWays = allConstructRecursively(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken recursively: " + (end - start) + " milliseconds and the output is: " + allWays);
        start = System.currentTimeMillis();
        allWays = allConstructMemoization(s, wordDict);
        end = System.currentTimeMillis();
        System.out.println("Time taken using memoization: " + (end - start) + " milliseconds and the output is: " + allWays);
    }
}
