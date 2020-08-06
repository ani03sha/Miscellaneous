package org.redquark.practice.leetcode.easy;

import java.util.Stack;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input
 * string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 */
public class Problem020_ValidParentheses {

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println("Is " + s + " valid: " + isValid(s));
        s = "]";
        System.out.println("Is " + s + " valid: " + isValid(s));
    }
}
