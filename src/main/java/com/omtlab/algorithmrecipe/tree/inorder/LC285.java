package com.omtlab.algorithmrecipe.tree.inorder;

import com.omtlab.algorithmrecipe.common.node.TreeNode;

/**
 * https://www.youtube.com/watch?v=5cPbNCrdotA
 * Description
 *
 * Given a binary search tree (See Definition) and a node in it, find the in-order successor of that node in the BST.
 *
 * If the given node has no in-order successor in the tree, return null.
 *
 * It's guaranteed p is one node in the given tree. (You can directly compare the memory address to find p)
 *
 * Have you met this question in a real interview?  
 * Example
 * Example 1:
 *
 * Input: {1,#,2}, node with value 1
 * Output: 2
 * Explanation:
 *   1
 *    \
 *     2
 * Example 2:
 *
 * Input: {2,1,3}, node with value 1
 * Output: 2
 * Explanation: 
 *     2
 *    / \
 *   1   3
 * Binary Tree Representation
 *
 * Challenge
 * O(h), where h is the height of the BST.
 */
public class LC285 {
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode node){
        TreeNode successor = null;
        
        while(root!= null){
            if(root.integerValue > node.integerValue){
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        return successor;
    } 
    
}
