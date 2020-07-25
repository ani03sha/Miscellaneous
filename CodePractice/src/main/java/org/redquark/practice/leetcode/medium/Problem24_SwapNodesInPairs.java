package org.redquark.practice.leetcode.medium;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class Problem24_SwapNodesInPairs {

    private static Node swapPairs(Node head) {
        // Create a new node
        Node temp = new Node(0);
        // Point next of this node to the current head
        temp.next = head;
        // This will be the pointers
        Node current = temp;
        // Loop through the linked list
        while (current.next != null && current.next.next != null) {
            // First node
            Node first = current.next;
            // Second node
            Node second = current.next.next;
            // Reference the pointers
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            // Move two pointers ahead
            current = current.next.next;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next = new Node(4);

        Node expected = swapPairs(head);
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
