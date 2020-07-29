package org.redquark.practice.leetcode.easy;

/**
 * @author Anirudh Sharma
 * <p>
 * Reverse a singly linked list.
 */
public class Problem206_ReverseLinkedList {

    private static Node reverseList(Node head) {
        // Base condition
        if (head == null) {
            return null;
        }
        // Previous, current, next nodes
        Node previousNode = null;
        Node currentNode = head;
        Node nextNode;
        // Loop through the entire list
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node reverse = reverseList(head);
        while (reverse != null) {
            System.out.print(reverse.data + " ");
            reverse = reverse.next;
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
