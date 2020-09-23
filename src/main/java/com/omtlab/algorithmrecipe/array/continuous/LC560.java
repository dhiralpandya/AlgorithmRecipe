package com.omtlab.algorithmrecipe.array.continuous;

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
     *  HERE WE HAVE TWO SOLUTION, PLEASE CHECK BOTH
     *  1. subarraySum
     *  2. subarraySumWorking
     */

    /**
     * This solution will not work for all the inputs. But it is nice to have,
     * You can use it for whiteboard because in that they may not ask to run the program.
     */
    public int subarraySum(int[] nums, int k) {

        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            if (nums[0] == k)
                return 1;
            if (nums[0] != k)
                return 0;
        }

        int output = 0;

        int left = 0;
        int right;
        int currentSum = nums[left];

        for (right = 1; right < nums.length; right++) {
            if (currentSum == k) {
                output += 1;
            } else {
                while (currentSum > k) {
                    currentSum -= nums[left];
                    left++;
                }
                output += currentSum == k ? 1 : 0;
            }
            currentSum += nums[right];
        }

        while (left < right) {
            currentSum -= nums[left];
            left++;
            output += currentSum == k ? 1 : 0;
        }
        return output;
    }

    /**
     */
    public int subarraySumWorking(int[] nums, int k) {
        return  new com.omtlab.algorithmrecipe.array.sumarray.LC560().subarraySum(nums, k);
    }

}
