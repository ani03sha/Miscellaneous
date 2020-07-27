package org.redquark.practice.leetcode.medium;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * <p>
 * Return the linked list sorted as well.
 */
public class Problem082_RemoveDuplicatesFromSortedLinkedListII {

    private static Node deleteDuplicates(Node head) {
        // Dummy node
        Node dummy = new Node(-1);
        // Point dummy node to the head
        dummy.next = head;
        // Reference of the dummy node
        Node current = dummy;
        // Loop for all the nodes in the linked list
        while (current.next != null && current.next.next != null) {
            // Check if the adjacent nodes are equal
            if (current.next.data == current.next.next.data) {
                // Value in the node
                int value = current.next.data;
                // Loop until we encounter the duplicates
                while (current.next != null && current.next.data == value) {
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(1);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(3);

        Node expected = deleteDuplicates(head);
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
