package com.omtlab.algorithmrecipe.tree.bfs;

import com.omtlab.algorithmrecipe.common.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. Symmetric Tree
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class LC101 {

    public boolean isSymmetric(TreeNode root) {
        return kindOfBFS(root.left, root.right);
    }

    private boolean kindOfBFS(TreeNode left, TreeNode right) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(left);
        queue.add(right);

        while(!queue.isEmpty()) {

            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();

            // Both null continue
            if(leftNode == null && rightNode == null) {
                continue;
            }

            //One of them but not both.
            if(leftNode == null ^ rightNode == null) {
                return false;
            }

            if(leftNode.integerValue != rightNode.integerValue) {
                return false;
            }

            queue.add(leftNode.right);
            queue.add(rightNode.left);
            queue.add(leftNode.left);
            queue.add(rightNode.right);

        }


        return true;

    }
}
