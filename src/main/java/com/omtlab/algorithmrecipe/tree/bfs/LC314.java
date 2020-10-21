package com.omtlab.algorithmrecipe.tree.bfs;

/*
Companies : [FACEBOOK]
 */

import com.google.common.collect.Lists;
import com.omtlab.algorithmrecipe.common.node.TreeNode;
import com.omtlab.algorithmrecipe.twopointer.GenerateTree;

import java.util.*;

/**
 * 314. Binary Tree Vertical Order Traversal
 * <p>
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 * Examples:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * /\
 * /  \
 * 9  20
 * .../\
 * ../  \
 * 15   7
 * return its vertical order traversal as:
 * [
 * [9],
 * [3,15],
 * [20],
 * [7]
 * ]
 * Given binary tree [3,9,8,4,0,1,7],
 * 3
 * /\
 * /  \
 * 9   8
 * /\   /\
 * /  \/  \
 * 4  01   7
 * return its vertical order traversal as:
 * [
 * [4],
 * [9],
 * [3,0,1],
 * [8],
 * [7]
 * ]
 * Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
 * 3
 * /\
 * /  \
 * 9   8
 * /\  /\
 * /  \/  \
 * 4  01   7
 * ../\
 * ./  \
 * .5   2
 * return its vertical order traversal as:
 * [
 * [4],
 * [9,5],
 * [3,0,1],
 * [8,2],
 * [7]
 * ]
 */
public class LC314 {
    public List<List<Integer>> getVerticalOrder(Integer a[]) {
        TreeNode root = new GenerateTree().getRootNode(a);
        Map<Integer, List<Integer>> indexNodeValueMap = new TreeMap<>();
        root.index = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode mid = queue.poll();
            if (mid.left != null) {
                mid.left.index = mid.index - 1;
                queue.add(mid.left);
            }

            if (mid.right != null) {
                mid.right.index = mid.index + 1;
                queue.add(mid.right);
            }

            if (indexNodeValueMap.containsKey(mid.index)) {
                indexNodeValueMap.get(mid.index).add(mid.integerValue);
            } else {
                indexNodeValueMap.put(mid.index, Lists.newArrayList(mid.integerValue));
            }
        }

        List<List<Integer>> output = Lists.newArrayList();
        for (List<Integer> values : indexNodeValueMap.values()) {
            output.add(values);
        }
        return output;
    }
}
