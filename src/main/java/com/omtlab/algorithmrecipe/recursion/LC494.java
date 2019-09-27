package com.omtlab.algorithmrecipe.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. 
 * For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3. 
 * Output: 5
 * Explanation: 
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * Note:
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class LC494 {

    int total  =0;
    Map<String,Integer> indexCountCache = new HashMap<>();

    /**
     * Checkout Dynamic Programming Solution Below
     * @param nums
     * @param sum
     * @return
     */
    public int findTargetSumWaysDp(int[] nums, int sum) {
        return new com.omtlab.algorithmrecipe.dp.singlearray.startwithzero.LC494().findTargetSumWaysDp(nums,sum);
    }

    public int findTargetSumWaysRecursion(int[] nums, int sum) {
        findTargetSumWay(nums,0,0,sum);
        return total;
    }


    private void findTargetSumWay(int[] nums, int i, int currentSum, int sum) {

        if(i == nums.length){
            if(sum == currentSum){
                total++;
            }
            return;
        }
        
        findTargetSumWay(nums,i+1,currentSum-nums[i],sum);
        findTargetSumWay(nums,i+1,currentSum+nums[i],sum);
    }


    public int findTargetSumWaysRecursionCache(int[] nums, int sum) {
        return findTargetSumWayCache(nums,0,0,sum);
    }

    private int findTargetSumWayCache(int[] nums, int i, int currentSum, int sum) {

        if(i == nums.length){
            if(sum == currentSum){
                return 1;
            }
            return 0;
        }
        
        String key = i+"+"+currentSum;
        if(indexCountCache.containsKey(key)){
            return indexCountCache.get(key);
        }

        
        int sub = findTargetSumWayCache(nums,i+1,currentSum-nums[i],sum);
        int add = findTargetSumWayCache(nums,i+1,currentSum+nums[i],sum);
        
        int count = sub+add;
        
        indexCountCache.put(key,count);
        
        return count;
    }
}
