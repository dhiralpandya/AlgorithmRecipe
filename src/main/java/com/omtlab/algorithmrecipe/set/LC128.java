package com.omtlab.algorithmrecipe.set;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. 
 * Therefore its length is 4.
 * 
 */
public class LC128 {
    /**
     * Approach 3: HashSet and Intelligent Sequence Building
     * Intuition
     *
     * It turns out that our initial brute force solution was on the right track, but missing a few optimizations 
     * necessary to reach O(n)O(n) time complexity.
     *
     * Algorithm
     *
     * This optimized algorithm contains only two changes from the brute force approach: the numbers are stored in a 
     * HashSet (or Set, in Python) to allow O(1)O(1) lookups, and we only attempt to build sequences from numbers 
     * that are not already part of a longer sequence. 
     * This is accomplished by first ensuring that the number that 
     * would immediately precede the current number in a sequence is not present, as that number would necessarily be
     * part of a longer sequence.
     */


    public int longestConsecutive(int[] nums) {
                
            if(nums.length <=1){
              return nums.length; 
            }
            
            Set<Integer> set = new HashSet<>();
            
            for(int i : nums){ 
                set.add(i);
            }
            
            int max = 1;
            
            for(int i : nums){
                int currentMax = 1;
                int next=i;
                
                if(set.contains(next-1)){ // Already calculated as part of large sequence
                    continue;
                }
                
                while(set.contains(next+1)){
                    currentMax++;
                    next = next+1;
                }
                max = Math.max(max,currentMax);
            }
            
            return max;
    }
}
