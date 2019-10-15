package com.omtlab.algorithmrecipe.array;

/**
 * 674. Longest Continuous Increasing Subsequence
 * 
 * 
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 *
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3. 
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4. 
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 1
 * 
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1. 
 * Note: Length of the array will not exceed 10,000.
 */
public class LC674 {
    
    
    public int findLengthOfLCIS(int[] num) {

        if(num.length <=  1){
            return num.length;
        }

        int pre = 0;
        int max = 1;
        int current = 1;
        
        for(int i = 1; i < num.length; i++){
            if(num[pre] < num[i]){
                current+=1;
            } else {
                current=1;
            }
            max = Math.max(current, max);
            pre = i;
        }
        
        return max;
    }

}
