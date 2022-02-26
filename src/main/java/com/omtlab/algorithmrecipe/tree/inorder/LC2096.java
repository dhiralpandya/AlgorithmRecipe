package com.omtlab.algorithmrecipe.tree.inorder;

import com.omtlab.algorithmrecipe.common.node.TreeNode;

/**
 * 2096. Step-By-Step Directions From a Binary Tree Node to Another
 * <p>
 * You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n. You are also given an integer startValue representing the value of the start node s, and a different integer destValue representing the value of the destination node t.
 * <p>
 * Find the shortest path starting from node s and ending at node t. Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'. Each letter indicates a specific direction:
 * <p>
 * 'L' means to go from a node to its left child node.
 * 'R' means to go from a node to its right child node.
 * 'U' means to go from a node to its parent node.
 * Return the step-by-step directions of the shortest path from node s to node t.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
 * Output: "UURL"
 * Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.
 * Example 2:
 * <p>
 * <p>
 * Input: root = [2,1], startValue = 2, destValue = 1
 * Output: "L"
 * Explanation: The shortest path is: 2 → 1.
 */
public class LC2096 {

    /**
     * We are going to solve this with LCA method. Please go through LC236 for more details.
     */
    public String getDirections(TreeNode root, int startValue, int destValue) {
        String result = "";
        TreeNode lca = lca(root, startValue, destValue);

        StringBuilder lcaToStartString = new StringBuilder();
        populateDirection(lca, startValue, lcaToStartString);

        // Change everything to U for LCA to START
        for (int i = 0; i < lcaToStartString.length(); i++) {
            result += "U";
        }

        StringBuilder lcaToDestinationString = new StringBuilder();
        populateDirection(lca, destValue, lcaToDestinationString);

        result += lcaToDestinationString.toString();

        return result;
    }

    private TreeNode lca(TreeNode root, int s, int d) {
        if (root == null || root.integerValue == s || root.integerValue == d) {
            return root;
        }

        TreeNode left = lca(root.left, s, d);
        TreeNode right = lca(root.right, s, d);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }


    /**
     * Here we are going to use back tracking.
     */
    private boolean populateDirection(TreeNode root, int v, StringBuilder sb) {
        if (root == null) {
            return false;
        }

        if (root.integerValue == v) {
            return true;
        }

        sb.append("L");
        if (populateDirection(root.left, v, sb)) {
            return true;
        }
        sb.deleteCharAt(sb.length() - 1);

        sb.append("R");
        if (populateDirection(root.right, v, sb)) {
            return true;
        }
        sb.deleteCharAt(sb.length() - 1);

        return false;
    }

}
