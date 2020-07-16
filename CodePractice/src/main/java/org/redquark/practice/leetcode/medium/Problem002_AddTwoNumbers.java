package org.redquark.practice.leetcode.medium;

/**
 * @author Anirudh Sharma
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class Problem002_AddTwoNumbers {

    private static Node addTwoNumbers(Node l1, Node l2) {
        // Head of the new linked list
        Node head = null;
        // Reference of head of new list
        Node temp = head;
        // Carry
        int carry = 0;
        // Loop for each node in the lists
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            Node node = new Node(sum % 10);
            if (temp != null) {
                temp.next = node;
                temp = temp.next;
            } else {
                temp = head = node;
            }
        }
        if (carry > 0) {
            temp.next = new Node(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        Node head1 = new Node(2);
        head1.next = new Node(4);
        head1.next.next = new Node(3);

        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(4);

        Node result = addTwoNumbers(head1, head2);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
