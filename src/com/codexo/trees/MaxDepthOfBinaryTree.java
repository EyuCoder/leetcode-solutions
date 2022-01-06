package com.codexo.trees;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaxDepthOfBinaryTree {

    /**
     * DFS
     * Time Complexity: O(n) Linear
     * Space Complexity: O(n) Linear
     */
    public static int maxDepth(TreeNode root) {
        return maxDepth(root, 0); // DFS
    }

    private static int maxDepth(TreeNode node, int currentDepth) {
        if (node == null) return currentDepth;
        currentDepth++;
        return Math.max(maxDepth(node.right, currentDepth), maxDepth(node.left, currentDepth));
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7))
        );

        System.out.println(maxDepth(tree)); // 3
    }
}
