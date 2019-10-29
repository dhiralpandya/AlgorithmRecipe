package com.omtlab.algorithmrecipe.recursion.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 377. Combination Sum IV
 *
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that 
 * add up to a positive integer target.
 *
 * Example:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * Note that different sequences are counted as different combinations.
 *
 * Therefore the output is 7.
 */
public class LC377 {
    
    Map<Integer,Integer> targetSum = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {
        if(target < 0 || nums == null || nums.length == 0){
            return 0;
        }
        
        if(target == 0){
            return 1;
        }
        
        if(targetSum.containsKey(target)){
            return targetSum.get(target);
        }
        
        int sum = 0;
        
        for(int n : nums){
            sum+=combinationSum4(nums,target-n);
        }
        
        targetSum.put(target,sum);
        return  sum;
    }
}
