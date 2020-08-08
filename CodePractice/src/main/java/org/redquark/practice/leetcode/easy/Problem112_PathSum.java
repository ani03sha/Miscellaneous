package org.redquark.practice.leetcode.easy;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 */
public class Problem112_PathSum {

    private static boolean hasPathSum(Node root, int sum) {
        if (root == null) {
            return false;
        } else if (sum - root.data == 0 && root.left == null && root.right == null) {
            return true;
        } else {
            return hasPathSum(root.left, sum - root.data) ||
                    hasPathSum(root.right, sum - root.data);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.right = new Node(1);

        int sum = 22;

        System.out.println("Does path exist?: " + hasPathSum(root, sum));
    }

    /**
     * This class represents each node in the tree
     */
    static class Node {
        final int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
}
