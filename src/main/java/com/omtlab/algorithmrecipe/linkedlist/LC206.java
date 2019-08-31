package com.omtlab.algorithmrecipe.linkedlist;

import com.omtlab.algorithmrecipe.common.node.LinkNode;

/**
 * 206. Reverse Linked List
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * 
 * Follow up:
 * -------------------
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * 
 */
public class LC206  {
    
    
    public LinkNode reverse(LinkNode root){
        LinkNode newRoot = root;
        LinkNode next = root.next;
        while(next != null ){//&& next != root This to avoid loop, but code working without this also.
            LinkNode temp = next.next;
            next.next = newRoot;
            newRoot = next;
            next = temp;
        }
        root.next = null;
        return newRoot;
    }
}
