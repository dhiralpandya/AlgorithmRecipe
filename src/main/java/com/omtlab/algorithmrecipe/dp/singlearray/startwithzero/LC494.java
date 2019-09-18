package com.omtlab.algorithmrecipe.dp.singlearray.startwithzero;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    /**
     * https://www.youtube.com/watch?v=r6Wz4W1TbuI
     * 
     * Please refer documentation in : documentation/LC494.png 
     * array [1,1,1,1,1] and sum = 3 
     * 
     *  
     * 0[0] = {0}
     * 1[1] = {-1,1}
     * 2[1] = {-2,0,0,2}
     * 3[1] = {-3,-1,-1,1,-1,1,1,3}
     * 4[1] = {-4,-2,-2,0,-2,0,2,0,-2,0,0,2,0,2,2,4}
     * 5[1] = {-5,-3,-3,-1,-3,-1,-1,1,-3,-1,-1,1,-1,1,1,3,-3,-1,-1,1,-1,1,1,3,-1,1,1,3,1,3,3,5}
     * In 5[1] = Calculate count of 3 that's our ans.
     * @param nums
     * @param sum
     * @return
     */
    public int findTargetSumWaysDp(int[] nums, int sum) {


        Map<Integer,Integer> sumWithCountMap = new HashMap<>();

        Map<Integer, List<Integer>> indexWithAllSumMap = new HashMap<>();
        indexWithAllSumMap.put(0, Lists.newArrayList(0));

        for(int i = 0; i < nums.length; i++){

            int nextIndex = i+1;
            indexWithAllSumMap.put(nextIndex,Lists.newArrayList());

            Map<Integer,Integer> tempSumWithCount = new HashMap<>();

            for(Integer sumAtCurrentIndex : indexWithAllSumMap.get(i)){
                Integer add = sumAtCurrentIndex+nums[i];
                Integer sub = sumAtCurrentIndex-nums[i];

                if(tempSumWithCount.containsKey(add)){
                    tempSumWithCount.put(add,tempSumWithCount.get(add)+1);
                } else {
                    tempSumWithCount.put(add,1);
                }

                if(tempSumWithCount.containsKey(sub)){
                    tempSumWithCount.put(sub,tempSumWithCount.get(sub)+1);
                } else {
                    tempSumWithCount.put(sub,1);
                }

                indexWithAllSumMap.get(nextIndex).add(add);
                indexWithAllSumMap.get(nextIndex).add(sub);
            }
            
            for(Integer key : tempSumWithCount.keySet()){
                if(!sumWithCountMap.containsKey(key) 
                        || sumWithCountMap.get(key) < tempSumWithCount.get(key)){
                    sumWithCountMap.put(key,tempSumWithCount.get(key));
                }
            }
        }

        return sumWithCountMap.getOrDefault(sum,0);
    }
    

    /**
     * Below will not work because we are adding count in existing count, We should override it
     * @param nums
     * @param sum
     * @return
     */
    public int findTargetSumWaysDpNotWorkingDueToAddInExisting(int[] nums, int sum) {
        

        Map<Integer,Integer> sumWithCountMap = new HashMap<>();
        
        Map<Integer, List<Integer>> indexWithAllSumMap = new HashMap<>();
        indexWithAllSumMap.put(0, Lists.newArrayList(0));
        
        for(int i = 0; i < nums.length; i++){
            
            int nextIndex = i+1;
            indexWithAllSumMap.put(nextIndex,Lists.newArrayList());
            
            for(Integer sumAtCurrentIndex : indexWithAllSumMap.get(i)){
                Integer add = sumAtCurrentIndex+nums[i];
                Integer sub = sumAtCurrentIndex-nums[i];
                
                if(sumWithCountMap.containsKey(add)){
                    sumWithCountMap.put(add,sumWithCountMap.get(add)+1);//Dont do this add directly
                } else {
                    sumWithCountMap.put(add,1);
                }
                
                if(sumWithCountMap.containsKey(sub)){
                    sumWithCountMap.put(sub,sumWithCountMap.get(sub)+1);// Add directly dont use existing count.
                } else {
                    sumWithCountMap.put(sub,1);
                }
               
                indexWithAllSumMap.get(nextIndex).add(add);
                indexWithAllSumMap.get(nextIndex).add(sub);
            }
        }
        
        return sumWithCountMap.getOrDefault(sum,0);
    }


    /**
     * Don't take set here, Set will not keep duplicate values, Since we are taking set in below problem, This would not work.
     * @param nums
     * @param sum
     * @return
     */
    public int findTargetSumWaysDpNotWorking(int[] nums, int sum) {


        Map<Integer,Integer> sumWithCountMap = new HashMap<>();

        Map<Integer, Set<Integer>> indexWithAllSumMap = new HashMap<>();
        indexWithAllSumMap.put(0, Sets.newHashSet(0));

        for(int i = 0; i < nums.length; i++){

            int nextIndex = i+1;
            indexWithAllSumMap.put(nextIndex,Sets.newHashSet());

            for(Integer sumAtCurrentIndex : indexWithAllSumMap.get(i)){
                Integer add = sumAtCurrentIndex+nums[i];
                Integer sub = sumAtCurrentIndex-nums[i];

                if(sumWithCountMap.containsKey(add)){
                    sumWithCountMap.put(add,sumWithCountMap.get(add)+1);
                } else {
                    sumWithCountMap.put(add,1);
                }

                if(sumWithCountMap.containsKey(sub)){
                    sumWithCountMap.put(sub,sumWithCountMap.get(sub)+1);
                } else {
                    sumWithCountMap.put(sub,1);
                }

                indexWithAllSumMap.get(nextIndex).add(add);
                indexWithAllSumMap.get(nextIndex).add(sub);
            }
        }

        return sumWithCountMap.getOrDefault(sum,0);
    }
    
}
