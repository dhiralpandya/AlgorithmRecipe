package com.omtlab.algorithmrecipe.tree.preorder;

import com.omtlab.algorithmrecipe.common.node.TreeNode;

/**
 * 572. Subtree of Another Tree
 *
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 * Example 2:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return false.
 */
public class LC572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringBuilder mainTree = new StringBuilder();
        StringBuilder subTree = new StringBuilder();
        preOrder(s, mainTree);
        preOrder(t, subTree);

        return mainTree.toString().indexOf(subTree.toString()) >=0;
    }


    private static void preOrder(TreeNode node, StringBuilder currentString) {
        if(node == null) {
            return;
        }

        currentString.append(node.integerValue);

        if(node.left == null) {
            currentString.append("lnull");
        }

        if(node.right == null) {
            currentString.append("rnull");
        }

        preOrder(node.left, currentString);
        preOrder(node.right, currentString);
    }

}
