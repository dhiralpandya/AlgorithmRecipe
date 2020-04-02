package com.omtlab.algorithmrecipe.twopointer;

/**
 * 209. Minimum Size Subarray Sum
 * 
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray 
 * of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example: 
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
 */
public class LC209 {


    public int minSubArrayLen(int s, int[] nums) {
        
        if(nums==null || nums.length == 0){
            return 0;
        } else if(nums.length > 0 && nums[0] == s){
            return 1;
        }
        
        int minSize = Integer.MAX_VALUE;
        int currentSum = nums[0];
        
        int j=0;
        for(int i =1; i< nums.length; i++){
            currentSum+=nums[i];
            
            while(currentSum > s && j<=i){
                currentSum-=nums[j];
                j++;
            }
            
            if(currentSum == s){
                minSize=Math.min(minSize,i-j+1);
            }


        }
        
        return minSize == Integer.MAX_VALUE?0:minSize;
    }
    
    
}
