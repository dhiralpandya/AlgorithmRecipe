package com.omtlab.algorithmrecipe.common.node;

public class LinkNode {
    public LinkNode next;
    public int value;
    
    public LinkNode(LinkNode next, int value){
        this.next = next;
        this.value = value;
    }
    
    public LinkNode(int value){
        this.value = value;
    }
}
