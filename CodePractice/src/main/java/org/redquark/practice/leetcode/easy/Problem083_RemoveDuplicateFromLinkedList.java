package org.redquark.practice.leetcode.easy;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 */
public class Problem083_RemoveDuplicateFromLinkedList {

    private static Node deleteDuplicates(Node head) {
        // Reference of the current node
        Node current = head;
        while (current != null) {
            // Reference of current node
            Node temp = current;
            while (temp != null && temp.data == current.data) {
                temp = temp.next;
            }
            current.next = temp;
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);

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
