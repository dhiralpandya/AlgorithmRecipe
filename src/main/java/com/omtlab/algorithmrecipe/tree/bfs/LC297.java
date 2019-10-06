package com.omtlab.algorithmrecipe.tree.bfs;
/*
Companies: [FACEBOOK, UBER]
 */

import com.omtlab.algorithmrecipe.common.node.TreeNode;
import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 297. Serialize and Deserialize Binary Tree
 * 
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be 
 * stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in 
 * the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your 
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized 
 * to a string and this string can be deserialized to the original tree structure.
 *
 * Example: 
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need 
 * to follow this format, so please be creative and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms 
 * should be stateless.
 */
public class LC297 {
    
    public Integer[] serializeBinaryTree(TreeNode root){
        Queue<TreeNode>  queue = new LinkedList<>();
        List<Integer> output = Lists.newArrayList();
        
        queue.add(root);
        output.add(root.integerValue);
        
        
        
        while(!queue.isEmpty()){
            TreeNode mid = queue.poll();
            
            
            if(mid.left != null){
                queue.add(mid.left);
                output.add(mid.left.integerValue);
            } else {
                output.add(null);
            }


            if(mid.right != null){
                queue.add(mid.right);
                output.add(mid.right.integerValue);
            } else {
                output.add(null);
            }
            
        }
        
        
        //REMOVING Extra nulls from the end. 
        //[1,2,3,null,null,4,5,null,null]
        int count =0;
        for(count = output.size()-1;count>=0;count--){
            if(output.get(count) != null){
                break;
            }
        }
        Integer[] arrayOutput = new Integer[count+1];
        for(int i = 0; i < count+1;i++){
            arrayOutput[i] = output.get(i);
        }
        return arrayOutput;
    }
}
