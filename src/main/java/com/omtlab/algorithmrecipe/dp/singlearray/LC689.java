package com.omtlab.algorithmrecipe.dp.singlearray;

/*
Companies : [FACEBOOK]
 */

import java.util.List;

/**
 * 689. Maximum Sum of 3 Non-Overlapping Subarrays
 * In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.
 *
 * Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.
 *
 * Return the result as a list of indices representing the starting position of each interval (0-indexed). If there 
 * are multiple answers, return the lexicographically smallest one.
 *
 * Example:
 *
 * Input: [1,2,1,2,6,7,5,1], 2
 * Output: [0, 3, 5]
 * Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
 * We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
 *
 *
 * Note:
 *
 * nums.length will be between 1 and 20000.
 * nums[i] will be between 1 and 65535.
 * k will be between 1 and floor(nums.length / 3).
 */
public class LC689 {
    /**
     * Approach #1: Ad-Hoc [Accepted]
     * Intuition
     *
     * It is natural to consider an array W of each interval's sum, where each interval is the given length K. To 
     * create W, we can either use prefix sums, or manage the sum of the interval as a window slides along the array.
     *
     * From there, we approach the reduced problem: Given some array W and an integer K, what is the 
     * lexicographically smallest tuple of indices (i, j, k) with i + K <= j and j + K <= k that maximizes W[i] + 
     * W[j] + W[k]?
     *
     * Algorithm
     *
     * Suppose we fixed j. We would like to know on the intervals i \in [0, j-K]i∈[0,j−K] and k \in [j+K, \text{len}
     * (W)-1]k∈[j+K,len(W)−1], where the largest value of W[i]W[i] (and respectively W[k]W[k]) occurs first. (Here, 
     * first means the smaller index.)
     *
     * We can solve these problems with dynamic programming. For example, if we know that ii is where the largest 
     * value of W[i]W[i] occurs first on [0, 5][0,5], then on [0, 6][0,6] the first occurrence of the largest 
     * W[i]W[i] must be either ii or 66. If say, 66 is better, then we set best = 6.
     *
     * At the end, left[z] will be the first occurrence of the largest value of W[i] on the interval i \in [0, 
     * z]i∈[0,z], and right[z] will be the same but on the interval i \in [z, \text{len}(W) - 1]i∈[z,len(W)−1]. This 
     * means that for some choice j, the candidate answer must be (left[j-K], j, right[j+K]). We take the candidate 
     * that produces the maximum W[i] + W[j] + W[k].
     */
    
    public int[] getStartIndexs(int[] input, int k_FromInput){
        
        //lets say we have input={1,8,5,10,9,13,1} and  k_FromInput = 1;
        //Now we will create sum array which has some of array of size k_FromInput
        // Here k_FromInput has size 1, It means sum array will have sum of array of size 1 only
        // Sum_Array = {1,8,5,10,9,13,1}
        //Now Prepare Left Array of Index with higher values. 
        // Left_Array_With_Index = {0,1,1,3,3,5,5}
        //Now prepare Right Array of Index with higher values. 
        // Right_Array_With_Index = {6,5,5,5,5,5,5}
        //Now start loop from j=k_FromInput and 
        // take i=Left_Array_With_Index[j-k] and 
        // take k=Right_Array_With_Index[j+k]
        //Now compare i+j+k value and store in output cache. 
        int sum[] = new int[input.length-k_FromInput+1];
        int currentSum = 0;
        for(int index = 0; index < input.length;index++){
            currentSum+=input[index];
            if(index>=k_FromInput){
                //MOST IMP Line, Make sure WE TAKE INPUT to remove one integer from right side
                currentSum-=input[index-k_FromInput];//Moving window of size k_FromInput 
                // to right side by removing one integer from left side
            }
            
            if(index>=k_FromInput-1){
                sum[index-k_FromInput+1]=currentSum;//Sotring sum of current Window to sum array
            }
        }
        
        int left[] = new int[sum.length];
        int bestLeftIndex = 0;
        for(int index=0; index<left.length;index++){
            if(sum[bestLeftIndex] < sum[index]) {
                bestLeftIndex = index;
            }
            
            left[index]= bestLeftIndex;
        }
        
        int right[] = new int[sum.length];
        int bestRightIndex = 0;
        for(int index=right.length-1; index>=0;index--){
            if(sum[bestRightIndex] < sum[index] ){
                bestRightIndex = index;
            }
            
            right[index] = bestRightIndex;
        }
        
        int output[] = {-1,-1,-1};
        int runningSum = -1;
        for(int j = k_FromInput; j < sum.length-k_FromInput;j++){
            int i = left[j-k_FromInput];
            int k = right[j+k_FromInput];
            int tempSum = sum[i]+sum[j]+sum[k];
            if(runningSum < tempSum){
                output[0] = i;
                output[1]=j;
                output[2] = k;
                runningSum = tempSum;
            }
            
        }
        
        return output;
        
    }
    
    
}
