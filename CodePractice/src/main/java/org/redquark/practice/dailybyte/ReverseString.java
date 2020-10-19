package org.redquark.practice.dailybyte;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string, reverse all of its characters and return the resulting string.
 */
public class ReverseString {

    private static String reverse(String s) {
        char[] characters = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            char temp = characters[start];
            characters[start] = characters[end];
            characters[end] = temp;
            start++;
            end--;
        }
        return new String(characters);
    }

    public static void main(String[] args) {
        System.out.println(reverse("Cat"));
        System.out.println(reverse("The Daily Byte"));
        System.out.println(reverse("civic"));
    }
}
