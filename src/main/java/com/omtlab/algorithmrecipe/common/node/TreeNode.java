package com.omtlab.algorithmrecipe.common.node;

public class TreeNode {
    public String stringValue;
    public Integer integerValue;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;// For LC 117. Populating Next Right Pointers in Each Node II
    public Integer index;

    public TreeNode(){

    }

    public String getNodeName(){
        return (stringValue == null?"":stringValue)+""+(integerValue==null?"":integerValue);
    }
    
    public TreeNode(Integer integerValue){
        this.integerValue = integerValue;
    }
}
