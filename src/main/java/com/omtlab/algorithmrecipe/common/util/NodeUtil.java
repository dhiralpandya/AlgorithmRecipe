package com.omtlab.algorithmrecipe.common.util;

import com.omtlab.algorithmrecipe.common.node.LinkNode;

public class NodeUtil {
    
    public static LinkNode generateLinkNodeIntegerValue(String s){
        LinkNode root = null;
        LinkNode nextNode = null;
        for(String value : s.split("->")){
            if(root == null){
                root = new LinkNode(Integer.parseInt(value));
                nextNode = root;
            }else {
                nextNode.next = new LinkNode(Integer.parseInt(value));
                nextNode = nextNode.next;
            }
        }
        
        return root;
    }
    
}
