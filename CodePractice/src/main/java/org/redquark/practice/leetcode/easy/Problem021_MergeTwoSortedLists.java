package org.redquark.practice.leetcode.easy;

/**
 * @author Anirudh Sharma
 * <p>
 * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by
 * splicing together the nodes of the first two lists.
 */
public class Problem021_MergeTwoSortedLists {

    private static Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Node head;
        Node temp;

        if (l1.data < l2.data) {
            temp = head = new Node(l1.data);
            l1 = l1.next;
        } else {
            temp = head = new Node(l2.data);
            l2 = l2.next;
        }
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                temp.next = new Node(l1.data);
                l1 = l1.next;
            } else {
                temp.next = new Node(l2.data);
                l2 = l2.next;
            }
            temp = temp.next;
        }
        while (l1 != null) {
            temp.next = new Node(l1.data);
            l1 = l1.next;
            temp = temp.next;
        }
        while (l2 != null) {
            temp.next = new Node(l2.data);
            l2 = l2.next;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next = new Node(5);

        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next = new Node(6);

        Node expected = mergeTwoLists(head1, head2);
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
