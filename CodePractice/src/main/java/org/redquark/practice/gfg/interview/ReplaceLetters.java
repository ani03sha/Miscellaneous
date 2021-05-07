package org.redquark.practice.gfg.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string of lowercase chars and a dictionary having key-value pairs as a character.
 * Replace all characters in string (which are present as a key in the dictionary) to their
 * corresponding value OR Replace all characters in the string (which are present as the value
 * in the dictionary) to their corresponding key.
 */
public class ReplaceLetters {

    private static String replace(String s, Map<Character, Character> dictionary) {
        if (s == null || s.isEmpty() || dictionary == null || dictionary.isEmpty()) {
            return s;
        }
        char[] characters = s.toCharArray();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < characters.length; i++) {
            char c = characters[i];
            Character value = dictionary.get(c);
            if (value != null && !visited[i]) {
                char temp = characters[i];
                characters[i] = value;
                visited[i] = true;
                int index = s.indexOf(value);
                characters[index] = temp;
                visited[index] = true;
            }
        }
        return new String(characters);
    }

    public static void main(String[] args) {
        String s = "abc";
        Map<Character, Character> dictionary = new HashMap<>() {{
            put('a', 'c');
        }};
        System.out.println(replace(s, dictionary));

        s = "abba";
        dictionary = new HashMap<>() {{
            put('a', 'b');
            put('b', 'a');
        }};
        System.out.println(replace(s, dictionary));
    }
}
