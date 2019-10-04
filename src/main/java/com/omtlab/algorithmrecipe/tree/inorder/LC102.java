package com.omtlab.algorithmrecipe.tree.inorder;

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
       
        inorder(0,root,map);
        
        int totalKeys = map.keySet().size();
        int currentKey = 0;
        while (currentKey < totalKeys){
            output.add(map.get(currentKey));
            currentKey++;
        }
        
        return output;
        
    }
    
    
    public void inorder(int index, TreeNode node, Map<Integer,List<Integer>> map){
        
        if(node == null){
            return;
        }
        
        List<Integer> l = map.getOrDefault(index,Lists.newArrayList());
        l.add(node.integerValue);
        map.put(index,l);
        
        inorder(index+1,node.left, map);
        inorder(index+1,node.right, map);
        
    } 
   
    
}
