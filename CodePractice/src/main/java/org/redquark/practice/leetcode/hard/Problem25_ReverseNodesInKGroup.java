package org.redquark.practice.leetcode.hard;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should
 * remain as it is.
 * <p>
 * Note:
 * <p>
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class Problem25_ReverseNodesInKGroup {

    private static Node reverseKGroup(Node head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        Node dummy = new Node(-1);
        dummy.next = head;
        Node previous = dummy;
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            if (count % k == 0) {
                previous = reverse(previous, temp.next);
                temp = previous.next;
            } else {
                temp = temp.next;
            }
        }
        return dummy.next;
    }

    private static Node reverse(Node prev, Node next) {
        Node p1 = prev.next;
        Node p2 = p1.next;

        while (p2 != next) {
            Node t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }

        Node rNode = prev.next;

        prev.next.next = next;
        prev.next = p1;

        return rNode;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 3;

        Node expected = reverseKGroup(head, k);
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
