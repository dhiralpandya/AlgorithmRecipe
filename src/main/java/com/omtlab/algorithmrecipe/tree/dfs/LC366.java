package com.omtlab.algorithmrecipe.tree.dfs;

import com.omtlab.algorithmrecipe.common.node.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 366. Find Leaves of Binary Tree
 * <p>
 * Given the root of a binary tree, collect a tree's nodes as if you were doing this:
 * <p>
 * Collect all the leaf nodes.
 * Remove all the leaf nodes.
 * Repeat until the tree is empty.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,2,3,4,5]
 * Output: [[4,5,3],[2],[1]]
 * Explanation:
 * [[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per each level it does not matter the order on which elements are returned.
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1]
 * Output: [[1]]
 */
public class LC366 {

    public List<List<Integer>> collectLeafNodes(TreeNode node) {
        Map<Integer, List<Integer>> output = new HashMap<>();
        collectLeafNode(node, output);
        return new ArrayList<>(output.values());
    }

    private int collectLeafNode(TreeNode node, Map<Integer, List<Integer>> leafNodesCollection) {
        if (node == null) {
            return 0;
        }

        int positionOfCurrentNode = 1 + Math.max(collectLeafNode(node.left, leafNodesCollection),
                collectLeafNode(node.right, leafNodesCollection));
        List<Integer> collections = leafNodesCollection.getOrDefault(positionOfCurrentNode, new ArrayList<>());
        collections.add(node.integerValue);

        leafNodesCollection.put(positionOfCurrentNode, collections);

        return positionOfCurrentNode;
    }
}
