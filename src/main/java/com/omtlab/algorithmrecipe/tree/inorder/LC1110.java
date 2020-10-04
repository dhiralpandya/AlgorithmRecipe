package com.omtlab.algorithmrecipe.tree.inorder;

import com.omtlab.algorithmrecipe.common.node.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1110. Delete Nodes And Return Forest
 *
 * Given the root of a binary tree, each node in the tree has a distinct value.
 *
 * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
 *
 * Return the roots of the trees in the remaining forest.  You may return the result in any order.
 *
 * Example 1:
 *
 *   FIND IMAGE IN DOCUMENTATION.
 *
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 */
public class LC1110 {
    public List<TreeNode> delNodes(TreeNode root, List<Integer> nodeToDelete) {

        List<TreeNode> output = new ArrayList<>();

        inOrder(root, nodeToDelete, output);

        if(!nodeToDelete.contains(root.integerValue)) {
            output.add(root);
        }

        return output;
    }

    private void inOrder(TreeNode root, List<Integer> nodeToDelete, List<TreeNode> output) {
        if(root == null) {
            return;
        }
        TreeNode right = root.right;
        TreeNode left = root.left;

        inOrder(right, nodeToDelete, output);
        inOrder(left, nodeToDelete, output);

        if(right != null && nodeToDelete.contains(right.integerValue)) {
            root.right = null;
        }

        if(left != null && nodeToDelete.contains(left.integerValue)) {
            root.left = null;
        }

        if(nodeToDelete.contains(root.integerValue)) {
            root.left = null;
            root.right = null;

            if(right != null && !nodeToDelete.contains(right.integerValue)) {
                output.add(right);
            }

            if(left != null && !nodeToDelete.contains(left.integerValue)) {
                output.add(left);
            }
        }
    }
}
