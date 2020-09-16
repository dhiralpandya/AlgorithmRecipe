package com.omtlab.algorithmrecipe.array.sumarray;

/*
Companies : [FACEBOOK]
 */

import java.util.Map;
import java.util.TreeMap;

/*
Companies : [FACEBOOK]
 */
/**
 * 325. Maximum Size Subarray Sum Equals k
 *
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 *
 * Note:
 * The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
 *
 * Example 1:
 * Given nums = [1, -1, 5, -2, 3], k = 3,
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 *
 * Example 2:
 * Given nums = [-2, -1, 2, 1], k = 1,
 * return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 *
 * Follow Up:
 * Can you do it in O(n) time?*/

public class LC325 {


    /**
     * We will use below equation. 
     * Sum1 + Sum2 = K
     * Sum2 = Sum1-K
     *
     * This is similar to LC560, Lets say a1+a2+a3 = K,
     * Now in our input, b1+a1+a2+a3 = Sum
     *
     * So Sum-K = b1 because a1+a2+a3 = K
     *
     * SO length is currentIndex - indexOfb1
     *
     * @param n
     * @param k
     * @return
     */
    public int maxLength(Integer[] n, Integer k){
        Map<Integer,Integer> cache = new TreeMap<>();
        
        int sum = 0;
        int max = 0;
        
        for(int i = 0; i < n.length; i++){
            sum+=n[i];

            if(sum == k){
                max = i+1;
            }else if(cache.containsKey(sum - k)){//Most important step
                max = Math.max(max,i-cache.get(sum-k));
            }
            
            cache.putIfAbsent(sum,i);
        }
        
        
        return max;
    } 
    
}
