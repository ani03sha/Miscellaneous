package org.redquark.practice.leetcode.easy;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 */
public class Problem876_MiddleOfLinkedList {

    private static Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        Node middle = middleNode(head);
        System.out.println("Middle node: " + middle.data);
    }

    static class Node {
        final int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
