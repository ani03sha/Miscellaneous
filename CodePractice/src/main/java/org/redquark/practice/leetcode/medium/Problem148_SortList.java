package org.redquark.practice.leetcode.medium;

/**
 * @author Anirudh Sharma
 * <p>
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class Problem148_SortList {

    private static Node sortList(Node head) {
        // Base condition
        if (head == null || head.next == null) {
            return head;
        }
        // Find the middle point using slow and fast pointer technique
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Heads of left and right list
        Node left = head;
        Node right = slow.next;
        // Disconnect left list from right
        slow.next = null;
        // Recursively merge
        left = sortList(left);
        right = sortList(right);
        // Return merged list
        return merge(left, right);
    }

    private static Node merge(Node left, Node right) {
        // Dummy node
        Node dummy = new Node(-1);
        // Current node
        Node current = dummy;
        // Loop through the left and right lists
        while (left != null || right != null) {
            if (left == null) {
                current.next = right;
                break;
            }
            if (right == null) {
                current.next = left;
                break;
            }
            if (left.data < right.data) {
                current.next = left;
                left = left.next;
                current = current.next;
            } else {
                current.next = right;
                right = right.next;
                current = current.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(3);
        head.next.next = new Node(11);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next = new Node(4);

        Node expected = sortList(head);
        while (expected != null) {
            System.out.print(expected.data + " ");
            expected = expected.next;
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
