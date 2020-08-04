package org.redquark.practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh Sharma
 * <p>
 * Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until
 * there are no such sequences.
 * <p>
 * After doing so, return the head of the final linked list.  You may return any such answer.
 * (Note that in the examples below, all sequences are serializations of ListNode objects.)
 */
public class Problem1171_RemoveZeoConsecutiveSum {

    private static Node removeZeroSumSublists(Node head) {
        Map<Integer, Node> map = new HashMap<>();
        int sum = 0;

        Node temp = head;
        while (temp != null) {
            sum += temp.data;
            map.put(sum, temp);
            temp = temp.next;
        }
        temp = head;
        sum = 0;
        while (temp != null) {
            sum += temp.data;
            if (map.containsKey(sum)) {
                temp.next = map.get(sum).next;
            } else {
                map.put(sum, temp);
            }
            temp = temp.next;
        }
        return sum == 0 ? null : head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(-3);
        head.next.next.next.next = new Node(-2);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next.next = new Node(-5);
        head.next.next.next.next.next.next.next.next = new Node(1);

        Node expected = removeZeroSumSublists(head);
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
