package com.omtlab.algorithmrecipe.array.continuous;

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
     *   Sum : 0 1 2 3
     *
     *   Sum[end] - Sum[start]
     *
     *   Start 0 and End 1 to 3
     *    1-0
     *    2-0 = Got it
     *    3-0
     *
     *   Start  1 and End 2 to 3
     *    2-1
     *    3-1 = 2 Got it
     *
     *    Start 2 and End 3
     *    3-2
     *
     *    Total Got it 2
     */
    public int subarraySumWorking(int[] nums, int k) {
        int[] sum = new int[nums.length+1];
        int output = 0;

        //This starts with 1
        for(int i=1; i < sum.length; i++) {
            sum[i] = sum[i-1]+nums[i-1];
        }

        for(int start =0; start < nums.length; start++) {
            for(int end = start+1; end < sum.length; end++) { // This ends by sum
                int subArraySum = sum[end] - sum[start];
                if(subArraySum == k) {
                    output++;
                }
            }
        }

        return output;
    }

}
