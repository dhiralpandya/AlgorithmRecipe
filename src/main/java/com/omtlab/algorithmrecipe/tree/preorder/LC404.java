package com.omtlab.algorithmrecipe.tree.preorder;

import com.omtlab.algorithmrecipe.common.node.TreeNode;

/**
 * 404. Sum of Left Leaves
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class LC404 {
    
    //What is left leaves ????
    // Left leaves means the left node which doesn't have left and right node. 
    // Leaves means last node in tree. 
    
    public int total(TreeNode root){
        if(root == null){
            return 0;
        } else if(root.left != null 
                && root.left.left == null 
                && root.left.right == null){
            return root.left.integerValue;
        } else {
          return total(root.left) + total(root.right);  
        }
    }
}
