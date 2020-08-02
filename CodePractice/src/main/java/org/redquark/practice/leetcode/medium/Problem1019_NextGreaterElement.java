package org.redquark.practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem1019_NextGreaterElement {

    private static int[] nextLargerNodes(Node head) {
        List<Integer> tempList = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            tempList.add(temp.data);
            temp = temp.next;
        }
        int[] result = new int[tempList.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tempList.size(); i++) {
            while (!stack.isEmpty() && tempList.get(i) > tempList.get(stack.peek())) {
                result[stack.pop()] = tempList.get(i);
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(1);
        head.next.next = new Node(5);

        int[] expected = nextLargerNodes(head);
        for (int n : expected) {
            System.out.print(n + " ");
        }
    }

    static class Node {
        final int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
