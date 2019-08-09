package com.omtlab.algorithmrecipe.backtracking;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * 
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class LC78 {
    
    
    
    public List<List<Integer>> getSubset(int[] input){
        List<List<Integer>>  output = Lists.newArrayList();
        output.add(Lists.newArrayList());
        backTracking(output,0,input,Lists.newArrayList());
        return output;
    }
    
    public void backTracking(List<List<Integer>> output, int index, int[] input, List<Integer> currentList){
        
        for(int i = index; i < input.length; i++){
            currentList.add(input[i]);
            output.add(new ArrayList(currentList));
            //Make sure here we do i+1 not index+1
            backTracking(output,i+1,input,currentList);//Make sure here we do i+1 not index+1
            currentList.remove(currentList.size()-1);
        }
        
    }
}
