package com.omtlab.algorithmrecipe.tree.preorder;

import com.omtlab.algorithmrecipe.common.node.TreeNode;

/**
 * 124. Binary Tree Maximum Path Sum
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 */
public class LC124 {

    /**
     * First of all we need to understand what is Path and how it looks like.
     *
     * A path from start to end, goes up on the tree for 0 or more steps,
     * then goes down for 0 or more steps. Once it goes down,
     * it can't go up. Each path has a highest node,
     * which is also the lowest common ancestor of all other nodes on the path.
     */

    private int maxSum = 0;
    public int maxPathSum(TreeNode root) {
        preOrderMaxSumAtNode(root);
        return maxSum;
    }

    private int preOrderMaxSumAtNode(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int leftSum = Math.max(preOrderMaxSumAtNode(node.left), 0);
        int rightSum = Math.max(preOrderMaxSumAtNode(node.right), 0);

        int midVal = node.integerValue;

        maxSum = Math.max(leftSum+rightSum+midVal, maxSum);

        return midVal + Math.max(leftSum, rightSum);
    }

}
