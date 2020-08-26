package com.omtlab.algorithmrecipe.tree.bfs;

import com.omtlab.algorithmrecipe.common.node.TreeNode;

import java.util.*;

/**
 * 199. Binary Tree Right Side View
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class LC199 {

    /**
     * This is really great problem, It looks very simple but its not.
     * Before writing the solution for this, You need to understand the problem.
     * you can't just add all right nodes.
     *
     *
     * What is the problem here ?
     *  The problem is to return a list of last elements from all levels,
     *  so it's the way more natural to implement BFS here.
     *
     *  Last element of each level is visible from right side.
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> visibleFromRightSide = new ArrayList<>();

        /**
         * What is solution ?
         * Since we need to find last element in each level,
         * We need to traverse level by level and need someway to mark end of level
         * so that we can get end node for that level.
         *
         * There is describe way in book by Narasimha Karumanchi,
         * Find details in documentation/LC199.jpg
         *
         * we will use null at the end of each level a
         * nd will get node before null which will visible from right side
         */

        Stack<TreeNode> orderInBottomToTop = new Stack<>();
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        bfsQueue.add(null);

        while(!bfsQueue.isEmpty()) {
            TreeNode n = bfsQueue.poll();
            if(n != null) orderInBottomToTop.push(n);
            if(n == null) {
                visibleFromRightSide.add(orderInBottomToTop.pop().integerValue);
                if(!bfsQueue.isEmpty()) {
                    n = bfsQueue.poll();
                    // Mark to separate the level.
                    bfsQueue.add(null);
                }
            }
            if(n!= null) {
                if(n.left != null) {
                    bfsQueue.add(n.left);
                }
                if(n.right != null) {
                    bfsQueue.add(n.right);
                }
            }
        }

        return visibleFromRightSide;
    }
}
