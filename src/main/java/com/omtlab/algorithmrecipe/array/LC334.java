package com.omtlab.algorithmrecipe.array;

/**
 * 334. Increasing Triplet Subsequence
 * 
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 *
 * Formally the function should:
 *
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5]
 * Output: true
 * Example 2:
 *
 * Input: [5,4,3,2,1]
 * Output: false
 */
public class LC334 {


    /**
     * This is master piece solution.
     * 
     * I have copied it from : https://github.com/dhiralpandya/Leetcode/blob/master/src/main/java/com/fishercoder/solutions/_334.java
     */

    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        
        for(int n : nums){
            if(n <= small){
                small = n;
            } else  if(n <= big){
                big = n;
            } else {
                //n is not less than small and big it means it is more than big in this case we found i,j,k
                return true;
            }
        }
        return false;
    }


}
