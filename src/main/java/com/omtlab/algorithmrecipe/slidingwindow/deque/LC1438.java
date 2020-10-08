package com.omtlab.algorithmrecipe.slidingwindow.deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 * <p>
 * Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [8,2,4,7], limit = 4
 * Output: 2
 * Explanation: All subarrays are:
 * [8] with maximum absolute diff |8-8| = 0 <= 4.
 * [8,2] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
 * [2] with maximum absolute diff |2-2| = 0 <= 4.
 * [2,4] with maximum absolute diff |2-4| = 2 <= 4.
 * [2,4,7] with maximum absolute diff |2-7| = 5 > 4.
 * [4] with maximum absolute diff |4-4| = 0 <= 4.
 * [4,7] with maximum absolute diff |4-7| = 3 <= 4.
 * [7] with maximum absolute diff |7-7| = 0 <= 4.
 * Therefore, the size of the longest subarray is 2.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [10,1,2,4,7,2], limit = 5
 * Output: 4
 * <p>
 * <p>
 * Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
 * Example 3:
 * <p>
 * Input: nums = [4,2,2,2,4,4,2,2], limit = 0
 * Output: 3
 * <p>
 * <p>
 * <p>
 * What is subarray ???
 * <p>
 * A subarray of an -element array is an array composed from a contiguous block of the original array's elements.
 */
public class LC1438 {

    /*
    What is subarray ????
       A subarray of an -element array is an array composed from a contiguous block of the original array's elements.
     */

    /*
    1. "Absolute difference between any two elements is less than or equal to limit" is basically
                => "Absolute difference between min and max elements of subarray"

    2. Now the question becomes
                => find the longest subarray in which the absolute difference between min and max is less than or equal to limit.
                What we can do is to have two pointers: left and right,
                and then find the longest subarray for every right pointer (iterate it) by shrinking left pointer.
                And return the longest one among them.
     */
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> indexOfMaxElement = new LinkedList<>();
        Deque<Integer> indexOfMinElement = new LinkedList<>();

        int maxOutput = 0;

        int left = 0;
        for (int right = 0; right < nums.length; right++) {

            while (!indexOfMaxElement.isEmpty() && nums[indexOfMaxElement.peekLast()] < nums[right]) {
                indexOfMaxElement.removeLast();
            }
            indexOfMaxElement.addLast(right);

            while (!indexOfMinElement.isEmpty() && nums[indexOfMinElement.peekLast()] > nums[right]) {
                indexOfMinElement.removeLast();
            }
            indexOfMinElement.addLast(right);

            int largestElementInWindow = nums[indexOfMaxElement.getFirst()];
            int smallestElementInWindow = nums[indexOfMinElement.getFirst()];

            if ((largestElementInWindow - smallestElementInWindow) <= limit) {
                // Why +1 in (right - left) ??
                // We need to consider left its self,
                // Lets say left = 1 and right is 3, total max is 1 to 3 (1,2,3) including 1,
                // Total count 3, [ (3-1)+1=3]
                maxOutput = Math.max(maxOutput, (right - left) + 1);
            } else {
                while ((largestElementInWindow - smallestElementInWindow) > limit) {
                    if (left == indexOfMaxElement.getFirst()) {
                        indexOfMaxElement.removeFirst();
                    }

                    if (left == indexOfMinElement.getFirst()) {
                        indexOfMinElement.removeFirst();
                    }

                    largestElementInWindow = nums[indexOfMaxElement.getFirst()];
                    smallestElementInWindow = nums[indexOfMinElement.getFirst()];

                    // Most imp step
                    left++; // Sliding the window
                }

            }
        }

        return maxOutput;
    }

}
