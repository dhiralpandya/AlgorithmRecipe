package com.omtlab.algorithmrecipe.divideandconquer;

import com.omtlab.algorithmrecipe.common.node.LinkNode;

import java.util.List;

/**
 * 23. Merge k Sorted Lists
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class LC23 {
    
    public LinkNode  getMergedNode(List<LinkNode> linkNodes){
        
        int totalLinkToMerged = linkNodes.size() -1;
        
        while(totalLinkToMerged > 0){
            linkNodes.set(0,mergedSimple(linkNodes.get(0),linkNodes.get(totalLinkToMerged)));
            totalLinkToMerged--;
        }
        
        return linkNodes.get(0);
    }
    

    public LinkNode mergedSimple(LinkNode n1, LinkNode n2) {
        LinkNode head = null;
        LinkNode tail = null;

        while(n1 != null && n2 != null) {
            if(n1.value < n2.value) {
                if(head == null) {
                    head = n1;
                } else {
                    tail.next = n1;
                }
                // Update tail with new one.
                tail = n1;
                n1 = n1.next;
            } else {
                if(head == null) {
                    head = n2;
                } else {
                    tail.next = n2;
                }
                tail = n2;
                n2 = n2.next;
            }
        }

        // Add Remaining.
        if(n1 != null) {
            tail.next = n1;
            tail = n1;
        }

        if(n2 != null) {
            tail.next = n2;
            tail = n2;
        }
        return head;
    }

    public LinkNode mergedDifficultToUnderstand(LinkNode node1, LinkNode node2){
       LinkNode left = node1;
       LinkNode previousLeft = null;
       LinkNode right = node2;
       
       while(left != null && right != null){
           if(left.value < right.value){
               previousLeft =  left;
               left = left.next;
           } else {//IF Left is greater than right, Move one node from right to left. 
               // Between previous left and current left
              LinkNode temp = right;
              right = right.next;
              temp.next = left;
              if(previousLeft != null){
                  previousLeft.next = temp;
              } else{
                  node1 = temp;
              }
              
               previousLeft = temp;
              
           }
       }
       if(left == null){
           previousLeft.next = right;
       }
       return node1;
    }
    
}
