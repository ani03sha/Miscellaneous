package org.redquark.practice.leetcode.hard;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Anirudh Sharma
 * <p>
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 */
public class Problem023_MergeKSortedLists {

    private static Node merge(Node[] lists) {
        // Create a min heap
        Queue<Integer> minHeap = new PriorityQueue<>();
        // Loop for all the lists
        for (Node head : lists) {
            while (head != null) {
                minHeap.add(head.data);
                head = head.next;
            }
        }
        // Resultant list will be created now
        Node dummy = new Node(-1);
        Node head = dummy;
        while (!minHeap.isEmpty()) {
            head.next = new Node(minHeap.remove());
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(4);
        head1.next.next = new Node(5);

        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(4);

        Node head3 = new Node(2);
        head3.next = new Node(6);

        Node[] lists = {head1, head2, head3};

        Node expected = merge(lists);

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
