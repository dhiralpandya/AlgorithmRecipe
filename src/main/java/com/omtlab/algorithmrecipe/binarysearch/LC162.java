package com.omtlab.algorithmrecipe.binarysearch;

/**
 * 162. Find Peak Element
 * <p>
 * A peak element is an element that is greater than its neighbors.
 * <p>
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 * <p>
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * <p>
 * You may imagine that nums[-1] = nums[n] = -∞.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 * <p>
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 * or index number 5 where the peak element is 6.
 * Follow up: Your solution should be in logarithmic complexity.
 */
public class LC162 {

    public int findPeakElement(int[] nums) {
        int peakElement = -1;

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            // Here we will compare mid with mid+1
            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
                peakElement = start;
            } else {
                end = mid;
            }
        }

        return peakElement;
    }

}