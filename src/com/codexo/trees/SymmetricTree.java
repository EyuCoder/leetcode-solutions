package com.codexo.trees;

public class SymmetricTree {

    /**
     * Time Complexity: O(n) Linear
     * Space Complexity: O(1) Constant
     */
    public static boolean isSymmetric(TreeNode root) {
        return symmetric(root.left, root.right);
    }
    private static boolean symmetric(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val == q.val)
            return symmetric(p.left,  q.right) && symmetric(p.right,  q.left);
        return false;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1,
                new TreeNode(2, null,
                        new TreeNode(5)),
                new TreeNode(3, null,
                        new TreeNode(4)));

        System.out.println(isSymmetric(tree)); //false
    }
}
