package com.omtlab.algorithmrecipe.tree.bfs;

import com.google.common.collect.Lists;
import com.omtlab.algorithmrecipe.common.node.TreeNode;

import java.util.*;

/**
 * 102. Binary Tree Level Order Traversal
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class LC102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = Lists.newArrayList();

        Map<Integer,List<Integer>> map = new HashMap<>();
        
        root.index = 0;
        

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            
            List<Integer> l = map.getOrDefault(current.index,Lists.newArrayList());
            l.add(current.integerValue);
            map.put(current.index,l);
            
            TreeNode left = current.left;
            TreeNode right = current.right;
            
            if(left != null){
                left.index = current.index+1;
                queue.add(left);
            }
            
            if(right != null){
                right.index = current.index+1;
                queue.add(right);
            }
        }
        
        int totalKeys = map.keySet().size();
        int currentKey = 0;
        while (currentKey < totalKeys){
            output.add(map.get(currentKey));
            currentKey++;
        }
        
        return output;
        
    }
    
   
    
}
