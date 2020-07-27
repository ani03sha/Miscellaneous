package org.redquark.practice.leetcode.easy;

/**
 * @author Anirudh Sharma
 * <p>
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list
 * is either 0 or 1. The linked list holds the binary representation of a number.
 * <p>
 * Return the decimal value of the number in the linked list.
 */
public class Problem1290_ConvertBinaryNumberToInteger {

    private static int getDecimalValue(Node head) {
        int sum = 0;
        while (head != null) {
            sum = (sum << 1) | head.data;
            head = head.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(0);
        head.next.next = new Node(1);
        head.next.next.next = new Node(0);

        System.out.println("Integer value: " + getDecimalValue(head));
    }

    static class Node {
        final int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
