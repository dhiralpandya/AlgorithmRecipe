package com.omtlab.algorithmrecipe.recursion;

import java.util.HashMap;
import java.util.Map;

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
