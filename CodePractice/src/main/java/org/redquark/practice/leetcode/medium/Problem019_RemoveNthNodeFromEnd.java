package org.redquark.practice.leetcode.medium;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Note:
 * Given n will always be valid.
 * <p>
 * Follow up:
 * Could you do this in one pass?
 */
public class Problem019_RemoveNthNodeFromEnd {

    private static Node removeNthNodeFromEnd(Node head, int n) {
        // Base condition
        if (head == null) {
            return null;
        }
        // Pointers
        Node fast = head;
        Node slow = head;
        // Loop through the list until n
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // Remove the first node
        if (fast.next == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        int n = 2;
        Node expectedHead = removeNthNodeFromEnd(head, n);
        while (expectedHead != null) {
            System.out.print(expectedHead.data + " ");
            expectedHead = expectedHead.next;
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
