package org.redquark.practice.leetcode.medium;

/**
 * @author Anirudh Sharma
 * <p>
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 */
public class Problem092_ReverseLinkedListII {

    private static Node reverseBetween(Node head, int m, int n) {
        // Base condition
        if (head == null) {
            return null;
        }
        // Current node
        Node current = head;
        // Previous node
        Node previous = null;
        // Loop until m
        for (int i = 0; i < m - 1; i++) {
            previous = current;
            current = current.next;
        }
        // Reference of the node which is the last node in the original order
        Node originalLast = previous;
        // Next of the current node
        Node next;
        // Reference of the original list
        Node temp = current;
        while (m <= n) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            m++;
        }
        if (originalLast != null) {
            originalLast.next = previous;
        } else {
            head = previous;
        }
        temp.next = current;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        int m = 2;
        int n = 4;
        Node reverse = reverseBetween(head, m, n);
        while (reverse != null) {
            System.out.print(reverse.data + " ");
            reverse = reverse.next;
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
