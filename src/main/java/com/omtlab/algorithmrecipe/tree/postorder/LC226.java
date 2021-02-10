package com.omtlab.algorithmrecipe.tree.postorder;

import com.omtlab.algorithmrecipe.common.node.TreeNode;

/**
 * 226. Invert Binary Tree
 * <p>
 * Invert a binary tree.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * Output:
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 * <p>
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
 */
public class LC226 {
    public TreeNode invertTree(TreeNode root) {
        postOrder(root);
        return root;
    }

    private void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        postOrder(left);
        postOrder(right);
        root.left = right;
        root.right = left;
    }
}
