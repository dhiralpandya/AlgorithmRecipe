package com.omtlab.algorithmrecipe.twopointer;

import com.omtlab.algorithmrecipe.common.node.TreeNode;

public class GenerateTree {
    
    public TreeNode getRootNode(Integer a[]){
        TreeNode nodes[] = new TreeNode[a.length];
       
        for(int i=0; i < a.length; i++){
            nodes[i] = null;
            if(a[i] != null) {
                nodes[i] = new TreeNode(a[i]);
            }
        }
        
        int p2=1;
        for(int p1=0; p1<a.length && p2 < a.length;p1++){
            TreeNode mid = nodes[p1];
            if (mid == null) {
                continue;
            }
            mid.left = nodes[p2];
            p2++;
            if(p2 >= a.length){
                break;
            }
            mid.right = nodes[p2];
            p2++;
        }
        
        
        return nodes[0];
    }
    
    
    
}
