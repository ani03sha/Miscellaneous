package org.redquark.practice.leetcode.medium;

/**
 * @author Anirudh Sharma
 * <p>
 * Sort a linked list using insertion sort.
 * <p>
 * Algorithm of Insertion Sort:
 * <p>
 * - Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * - At each iteration, insertion sort removes one element from the input data, finds the location it
 * belongs within the sorted list, and inserts it there.
 * <p>
 * - It repeats until no input elements remain.
 */
public class Problem147_InsertionSortList {

    private static Node insertionSortList(Node head) {
        // Current node
        Node current = head;
        Node next;
        Node dummy = new Node(-1);
        // Loop through the entire list
        while (current != null) {
            next = current.next;
            // Temp node
            Node temp = dummy;
            while (temp.next != null && temp.next.data < current.data) {
                temp = temp.next;
            }
            current.next = temp.next;
            temp.next = current;
            current = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        Node expected = insertionSortList(head);
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
