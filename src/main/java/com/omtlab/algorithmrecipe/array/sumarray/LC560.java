package com.omtlab.algorithmrecipe.array.sumarray;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 * <p>
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class LC560 {

    /**
     * In below solution, we have two main questions
     *
     * 1. Why we are storing sum at each stage ??
     * Lets say we have pair in array like a1+a2+a3=target
     * Now we also have some integer before and after that valid pair
     * Example: b1+a1+a2+a3+b2, so sum at a3 has value of b1 also.
     *
     * it means sum at a3 if we so sum-t we should get b1. if we get b1 means
     * we have one valid pair [a1+a2+a3] if b1 is not there means no valid pair
     *
     * Example
     * Input: [1,5,2,3,4] Target= 10
     *
     * Sum list: [1,6,8,11,15]
     *
     * Now at sum = 11 if we do 11-10=1 and 1 is there in our sum list,
     * it means we got pair [5,2,3]
     *
     * But if we have target 9 then at sum 11 we will get 11-9=2 and
     * we dont have sum 2 in our sum list it means no valid pair. but 15-9=6 and we have 6 in sum list
     * it means we have pair [2,3,4]
     *
     *
     * 2. Why default (0,1) mapping has been added ?
     *
     * Let say in above example we have target 5, so 5-5=0 thats why we need 0 with cound 1
     **/
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum=0;
        Map<Integer, Integer> sumToCountMap = new HashMap<>();
        sumToCountMap.put(0,1);
        for(int i=0; i < nums.length; i++) {
            sum+=nums[i];
            int lookingForSum = sum-k;
            if(sumToCountMap.containsKey(lookingForSum)) {
                // Why not just count++ ?
                // Because we can reach to lookingForSum multiple time
                // I mean 5-1 = 4 and 5-1+2-2 = 4 both are producing lookingForSum = 4 so count=2
                count+=sumToCountMap.get(lookingForSum);
            }
            sumToCountMap.put(sum, sumToCountMap.getOrDefault(sum,0)+1);
        }

        return count;
    }

}
