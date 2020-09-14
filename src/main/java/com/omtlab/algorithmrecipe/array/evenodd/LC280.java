package com.omtlab.algorithmrecipe.array.evenodd;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 280 Wiggle Sort
 *
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * <p>
 * Example:
 * <p>
 * Input: nums = [3,5,2,1,6,4]
 * Output: One possible answer is [3,5,1,6,2,4]
 */
public class LC280 {

    /**
     * Approach #2 (One-pass Swap) [Accepted]
     * Intuitively, we should be able to reorder it in one-pass.
     * As we iterate through the array, we compare the current element to its next element and if the order is incorrect, we swap them.
     */
    public void wiggleSort(int[] nums) {

        // At position 0 we need a[0] < a[1] and in position 1 we need a[1] > a[2]
        for(int i=0; i < nums.length-1; i++) {
            boolean isEven = i%2==0;
            if(isEven) {
                if(nums[i] > nums[i+1]) { // a[0] should less than a[1]
                    ArrayUtils.swap(nums,i,i+1);
                }
            } else {
                if(nums[i] < nums[i+1]) { // a[1] should greater than a[2]
                    ArrayUtils.swap(nums,i,i+1);
                }
            }
        }
    }

}
