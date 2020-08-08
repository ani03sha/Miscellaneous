package org.redquark.practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 */
public class Problem113_PathSumII {

    private static List<List<Integer>> pathSum(Node root, int sum) {
        // Resultant list
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, sum, new ArrayList<>(), result);
        return result;
    }

    private static void pathSum(Node node, int sum, List<Integer> path,
                                List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        path.add(node.data);
        if (node.data == sum && node.left == null && node.right == null) {
            result.add(path);
            return;
        }
        pathSum(node.left, sum - node.data, new ArrayList<>(path), result);
        pathSum(node.right, sum - node.data, new ArrayList<>(path), result);
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
        root.right.right.left = new Node(5);
        root.right.right.right = new Node(1);

        int sum = 22;

        System.out.println("Paths: " + pathSum(root, sum));
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
