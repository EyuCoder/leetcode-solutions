package com.codexo.trees;

// https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {

    /**
     * Time Complexity: O(n) Linear
     * Space Complexity: O(1) constant
     */
    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode root, long left, long right) {
        if (root == null) return true;

        if (root.val <= left || root.val >= right) return false;
        return validate(root.left, left, root.val) && validate(root.right, root.val, right);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7))
        );
        TreeNode tree2 = new TreeNode(2,
                new TreeNode(1, null, null),
                new TreeNode(3, null, null));

        System.out.println(isValidBST(tree)); // false
        System.out.println(isValidBST(tree2)); // true
    }
}
