package com.omtlab.algorithmrecipe.stack;

import com.omtlab.algorithmrecipe.common.node.TreeNode;

import java.util.Stack;

/**
 * 98. Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */


public class LC98 {
    
    /**
     * Approach 3: Inorder traversal
     * Algorithm
     *
     * Let's use the order of nodes in the inorder traversal Left -> Node -> Right.
     *
     * postorder
     *
     * Here the nodes are enumerated in the order you visit them, and you could follow 1-2-3-4-5 to compare different
     * strategies.
     *
     * Left -> Node -> Right order of inorder traversal means for BST that each element should be smaller than the 
     * next one.
     *
     * Hence the algorithm with \mathcal{O}(N)O(N) time complexity and \mathcal{O}(N)O(N) space complexity could be 
     * simple:
     *
     * Compute inorder traversal list inorder.
     *
     * Check if each element in inorder is smaller than the next one.
     *
     * postorder
     *
     * Do we need to keep the whole inorder traversal list?
     *
     * Actually, no. The last added inorder element is enough to ensure at each step that the tree is BST (or not). 
     * Hence one could merge both steps into one and reduce the used space.
     */
    static class Solution {
        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack();
            double inorder = - Double.MAX_VALUE;

            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                // If next element in inorder traversal
                // is smaller than the previous one
                // that's not BST.
                if (root.integerValue <= inorder) return false;
                inorder = root.integerValue;
                root = root.right;
            }
            return true;
        }
    }
}
