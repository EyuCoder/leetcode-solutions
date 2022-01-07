package com.codexo.trees;

// https://leetcode.com/problems/count-complete-tree-nodes
public class CountCompleteTreeNodes {

    /**
     * Time Complexity: O(log n) Logarithmic
     * Space Complexity: O(log n) Logarithmic
     */
    public static int countNodes(TreeNode root) {
        if (root == null) return 0;

        int left = height(root.left, true);
        int right = height(root.right, false);

        if (left != right) {
            return countNodes(root.left) + countNodes(root.right) + 1;
        } else {
            if (left == 0) return 1;
            return (1 << (left + 1)) - 1;
        }
    }

    private static int height(TreeNode root, boolean left) {
        if (root == null) return 0;
        if (left) return 1 + height(root.left, true);
        else return 1 + height(root.right, false);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1,
                new TreeNode(2, new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6), null));

        System.out.println(countNodes(tree)); // 6
    }
}
