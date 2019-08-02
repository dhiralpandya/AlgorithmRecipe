package com.omtlab.algorithmrecipe.iterator.tree;

import com.omtlab.algorithmrecipe.common.node.TreeNode;

import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 *
 *
 * Example:
 *
 *
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 *
 *
 * Note:
 *
 * next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * You may assume that next() call will always be valid, that is, there will be at least a next smallest number in 
 * the BST when next() is called.
 */
public class LC173_Copy {
    
    private TreeNode treeNode;
    private Stack<TreeNode> stack = new Stack<>();
    
    public LC173_Copy(TreeNode treeNode) {
        this.treeNode = treeNode;
        inOrderTraverse(treeNode);
    }
    
    
    public boolean hasNext(){
        return stack.size() > 0;
    }
    
    
    public int next(){
        TreeNode node = stack.pop();
        inOrderTraverse(node.right);
        return node.integerValue;
    }
    
    
    private void inOrderTraverse(TreeNode treeNode){
        if(treeNode != null){
            stack.push(treeNode);
            inOrderTraverse(treeNode.left);
        }
    }
    
}
