package com.omtlab.algorithmrecipe.tree.inorder;

import com.google.common.collect.Lists;
import com.omtlab.algorithmrecipe.common.node.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 117. Populating Next Right Pointers in Each Node II
 * 
 * Given a binary tree
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer 
 * should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 *
 * 
 * Note:
 *  You may only use constant extra space.
 *  For example,
 *  Given the following binary tree,
 *       1
 *     /  \
 *    2    3
 *   / \    \
 *  4   5    7
 *  After calling your function, the tree should look like:
 *       1 -> NULL
 *     /  \
 *    2 -> 3 -> NULL
 *   / \    \
 *  4-> 5 -> 7 -> NULL 
 *  
 *  Find image in documentation 
 */
public class LC117 {

    /**
     * Below implementation has been excepted in leetcode.
     */
    public TreeNode connect(TreeNode root) {

        Map<Integer, List<TreeNode>> levelNodeList = new HashMap<>();
        initLevel(0,root,levelNodeList);
        
        for(List<TreeNode> nodes:levelNodeList.values()){
            TreeNode pre = nodes.get(0);
            for(int i=1; i < nodes.size();i++){
                pre.next = nodes.get(i);
                pre = nodes.get(i);
            }
        }
        
        return root;
    }
    
    public void initLevel(int level, TreeNode node, Map<Integer,List<TreeNode>> map){
        
        if(node == null){
            return;
        }
        
        if(map.containsKey(level)){
            map.get(level).add(node);
        } else {
            map.put(level, Lists.newArrayList(node));
        }
        
        initLevel(level+1,node.left, map);
        initLevel(level+1,node.right, map);
    }
}

