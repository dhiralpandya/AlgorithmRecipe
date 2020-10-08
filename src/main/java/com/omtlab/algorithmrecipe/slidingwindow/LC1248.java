package com.omtlab.algorithmrecipe.slidingwindow;

/**
 * 1248. Count Number of Nice Subarrays
 * <p>
 * Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
 * <p>
 * Return the number of nice sub-arrays.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 * Example 2:
 * <p>
 * Input: nums = [2,4,6], k = 1
 * Output: 0
 * Explanation: There is no odd numbers in the array.
 * Example 3:
 * <p>
 * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * Output: 16
 */
public class LC1248 {

    /*
    This is really hard problem to understand and make proper solution.
      Before jumping to solution, please see image in documentation/LC1248.png
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int output = 0;
        int count = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) { // Odd number
                count = 0;
                k--;
            }

            while (k == 0) {
                k += nums[left] & 1; // Odd number will return 1 and even number will return 0
                count++;
                left++;
            }

            output += count;
        }

        return output;
    }
}
