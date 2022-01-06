package com.codexo.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    /**
     * BFS
     * Time Complexity: O(n) Linear
     * Space Complexity: O(n) Linear
     */
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> visibleValues = new ArrayList<>();
        if (root == null) return visibleValues;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                if (i == size - 1)
                    visibleValues.add(current.val);
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return visibleValues;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1,
                new TreeNode(2, null,
                        new TreeNode(5)),
                new TreeNode(3, null,
                        new TreeNode(4)));

        System.out.println(rightSideView(tree)); // [1,3,4]
    }
}
