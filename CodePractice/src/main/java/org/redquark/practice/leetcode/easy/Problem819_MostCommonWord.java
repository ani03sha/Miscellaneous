package org.redquark.practice.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 * <p>
 * Words in the list of banned words are given in lowercase, and free of punctuation.
 * Words in the paragraph are not case sensitive.  The answer is in lowercase.
 * <p>
 * Note:
 * <p>
 * 1 <= paragraph.length <= 1000.
 * 0 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase
 * symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 */
public class Problem819_MostCommonWord {

    private static String mostCommonWord(String paragraph, String[] banned) {
        // Save all the banned words in a Set
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
        // Regex to remove unnecessary characters
        paragraph = paragraph.replaceAll("[^a-zA-z]", " ");
        // Get all the individual words
        String[] paragraphWords = paragraph.split(" ");
        // Map that will store the frequency of each word
        Map<String, Integer> wordFrequency = new HashMap<>();
        // Count the frequency of each word
        for (String word : paragraphWords) {
            word = word.toLowerCase();
            if (!bannedWords.contains(word)) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }
        // String that will store the most frequent word
        String mostFrequent = "";
        // Loop for all the keys in the map
        for (String key : wordFrequency.keySet()) {
            if (mostFrequent.equals("") || wordFrequency.get(key) > wordFrequency.get(mostFrequent)) {
                mostFrequent = key;
            }
        }
        return mostFrequent;
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println("Most common word: " + mostCommonWord(paragraph, banned));
    }
}
