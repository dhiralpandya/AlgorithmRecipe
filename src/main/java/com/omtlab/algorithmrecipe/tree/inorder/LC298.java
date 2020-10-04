package com.omtlab.algorithmrecipe.tree.inorder;

import com.omtlab.algorithmrecipe.common.node.TreeNode;

/**
 * 298. Binary Tree Longest Consecutive Sequence
 *
 * Given a binary tree, find the length of the longest consecutive sequence path.
 *
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 *
 * Example 1:
 *
 * Input:
 *
 *    1
 *     \
 *      3
 *     / \
 *    2   4
 *         \
 *          5
 *
 * Output: 3
 *
 * Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
 * Example 2:
 *
 * Input:
 *
 *    2
 *     \
 *      3
 *     /
 *    2
 *   /
 *  1
 *
 * Output: 2
 *
 * Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
 *  Video : https://www.youtube.com/watch?v=oSYGjIq6ZM4&t=534s
 */
public class LC298 {
    int longestConsecutiveSequence = 1;
    public int longestConsecutive(TreeNode root) {
        inorder(root.left, root, 1);
        inorder(root.right, root, 1);
        return longestConsecutiveSequence;
    }

    public void inorder(TreeNode current, TreeNode parent, int currentCount) {
        if(current == null) {
            return;
        }
        if(current.integerValue == parent.integerValue+1) {
            currentCount++;
            longestConsecutiveSequence = Math.max(longestConsecutiveSequence, currentCount);
        } else {
            currentCount = 1;
        }

        inorder(current.left, current, currentCount);
        inorder(current.right, current, currentCount);
    }
}
