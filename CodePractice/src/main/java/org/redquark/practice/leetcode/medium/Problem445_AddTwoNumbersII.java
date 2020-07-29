package org.redquark.practice.leetcode.medium;

import java.util.Stack;

/**
 * @author Anirudh Sharma
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 */
public class Problem445_AddTwoNumbersII {

    private static Node addTwoNumbers(Node l1, Node l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.data);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.data);
            l2 = l2.next;
        }
        Node dummy = new Node(-1);
        Node head = dummy;
        Stack<Integer> s3 = new Stack<>();
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int sum = carry;
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }
            if (!s2.isEmpty()) {
                sum += s2.pop();
            }
            s3.push(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            s3.push(carry);
        }

        while (!s3.isEmpty()) {
            dummy.next = new Node(s3.pop());
            dummy = dummy.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(2);
        head1.next.next = new Node(4);
        head1.next.next.next = new Node(3);

        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(4);

        Node sum = addTwoNumbers(head1, head2);

        while (sum != null) {
            System.out.print(sum.data + " ");
            sum = sum.next;
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

