package com.omtlab.algorithmrecipe.iterator.list;

import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

/**
 * 341. Flatten Nested List Iterator
 * Given a nested list of integers, implement an iterator to flatten it.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Example 1:
 *
 * Input: [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false, 
 *              the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2:
 *
 * Input: [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false, 
 *              the order of elements returned by next should be: [1,4,6].
 */
public class LC341 implements Iterator<Integer> {
    private List<NestedInteger> nestedList;
    int currentPointer = 0;

    private Queue<Integer> cache = new LinkedList<>();
    
    public LC341(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        addInQueue();
    }

    private void addInQueue(){
        if(currentPointer < nestedList.size()){
            NestedInteger ni = nestedList.get(currentPointer);
            addInQueueRe(ni);
            currentPointer++;
        }
    }

    
    private void addInQueueRe(NestedInteger ni){
        if(ni.isInteger()){
            cache.add(ni.getInteger());
            return;
        } 
        
        if(ni.getList() != null && !ni.getList().isEmpty()){
            for(NestedInteger next:ni.getList()){
                addInQueueRe(next);
            }
        }
    }
    @Override
    public boolean hasNext() {
        while( cache.isEmpty() && currentPointer < nestedList.size()){
            addInQueue();
        }
        return !cache.isEmpty();
    }

    @Override
    public Integer next() {
        return cache.poll();
    }
    
    
    //Below is just a dummy interface, Test this code by running it in LeetCode. 
     public static class NestedInteger{
        public boolean isInteger(){
            return false;
        }
        
        public Integer getInteger(){
            return null;
        }

        public List<NestedInteger> getList(){
            return null;
         }
        
        
     }
}
