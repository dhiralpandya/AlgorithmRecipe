package com.omtlab.algorithmrecipe.array.map;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * 398. Random Pick Index
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can 
 * assume that the given target number must exist in the array.
 *
 * Note:
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 *
 * Example:
 *
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 *
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(3);
 *
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 */
public class LC398 {

    int[] nums=null;
    private Map<Integer, List<Integer>> intPositionMap = new HashMap<>();
    int countToStart = 0;
    Random random = new Random();
    
    
    public LC398(int[] nums) {
        Arrays.sort(nums);//IMP Step
        this.nums = nums;
    }

    public int pick(int target) {
        int i = countToStart;
        
        while(i<nums.length && !intPositionMap.containsKey(target)){
                    
            intPositionMap.put(nums[i],Lists.newArrayList());
            while ( i < nums.length && intPositionMap.containsKey(nums[i])){
                intPositionMap.get(nums[i]).add(i);
                i++;
            }
        
        }

        countToStart = i;    
        
        
        List<Integer> allPosition = intPositionMap.get(target);
        return allPosition.get(random.nextInt(allPosition.size()));
    }
    
}
