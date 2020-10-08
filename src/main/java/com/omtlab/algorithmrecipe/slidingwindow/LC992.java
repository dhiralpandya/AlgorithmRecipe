package com.omtlab.algorithmrecipe.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 992. Subarrays with K Different Integers
 * <p>
 * Given an array A of positive integers, call a (contiguous, not necessarily distinct) subarray of A good if the number of different integers in that subarray is exactly K.
 * <p>
 * (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
 * <p>
 * Return the number of good subarrays of A.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1,2,1,2,3], K = 2
 * Output: 7
 * Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * Example 2:
 * <p>
 * Input: A = [1,2,1,3,4], K = 3
 * Output: 3
 * Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 */
public class LC992 {

    /*
     First you may have feeling of using sliding window.
     Then this idea get stuck in the middle.

        This problem will be a very typical sliding window,
        if it asks the number of subarrays with at most K distinct elements.

        Just need one more step to reach the folloing equation:
        exactly(K) = atMost(K) - atMost(K-1)
     */
    public int subarraysWithKDistinct(int[] nums, int k) {
        return lessThanOrEqualToK(nums, k) - lessThanOrEqualToK(nums, k - 1);
    }

    public int lessThanOrEqualToK(int[] nums, int k) {
        Map<Integer, Integer> integerToCount = new HashMap<>();
        int output = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            int currentInt = nums[right];
            boolean isThisIntegerCameFirstTime = integerToCount.getOrDefault(currentInt, 0) == 0;
            if (isThisIntegerCameFirstTime) {
                k--;
            }
            integerToCount.put(currentInt, integerToCount.getOrDefault(currentInt, 0) + 1);

            while (k < 0) {
                int leftMostInt = nums[left];
                integerToCount.put(leftMostInt, integerToCount.get(leftMostInt) - 1);
                if (integerToCount.get(leftMostInt) == 0) {
                    k++;
                }
                left++;
            }

            //Why we dont need k==0 check here ????
            //Because we are looking for lessThanOrEqualToK not exactly k
            output += right - left + 1;
        }
        return output;
    }
}
