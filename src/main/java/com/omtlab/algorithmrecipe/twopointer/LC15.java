package com.omtlab.algorithmrecipe.twopointer;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * 
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique 
 * triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class LC15 {
    
    //https://www.youtube.com/watch?v=-AMHUdZc9ss
    public List<List<Integer>> threeSum(Integer[] input){
        Arrays.sort(input);//Imp Steps
        
        List<List<Integer>> output = Lists.newArrayList();
        
        for(int i = 0; i < input.length -3 ; i++){
            if(i == 0 || input[i] > input[i-1]){ // This is to ignore duplicate
                int start = i+1;
                int end = input.length-1;
                while (start < end){

                    if(input[i]+input[start]+input[end] == 0){
                        output.add(Lists.newArrayList(input[i],input[start],input[end]));
                        start++;
                    } else if(input[i]+input[start]+input[end] < 0){
                        int currentStart = start;
                        while(input[start] == input[currentStart] && start < end){
                            start++;
                        }
                    } else {
                        int currentEnd = end;
                        while(input[end] == input[currentEnd] && start < end){
                            end--;
                        }
                    }
                }   
            }
        }
        
        return output;
    }
}
