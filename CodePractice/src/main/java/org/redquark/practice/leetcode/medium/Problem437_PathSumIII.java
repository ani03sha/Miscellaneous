package org.redquark.practice.leetcode.medium;

/**
 * @author Anirudh Sharma
 * <p>
 * You are given a binary tree in which each node contains an integer value.
 * <p>
 * Find the number of paths that sum to a given value.
 * <p>
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * <p>
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */
public class Problem437_PathSumIII {

    private static int pathSum(Node root, int sum) {
        // Base Condition
        if (root == null) {
            return 0;
        }
        return pathSum(root.left, sum) + pathSum(root.right, sum) + nodeIncluded(root, sum);
    }

    private static int nodeIncluded(Node node, int sum) {
        if (node == null) {
            return 0;
        }
        int result = 0;
        if (sum == node.data) {
            result++;
        }
        result += nodeIncluded(node.left, sum - node.data);
        result += nodeIncluded(node.right, sum - node.data);
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(-3);
        root.right.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(-2);
        root.left.right.right = new Node(1);

        int sum = 8;

        System.out.println("Number of paths: " + pathSum(root, sum));
    }

    /**
     * This node represents each node in the tree
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
