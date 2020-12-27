package com.omtlab.algorithmrecipe.bit;

/**
 * 540. Single Element in a Sorted Array
 * <p>
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
 * <p>
 * Follow up: Your solution should run in O(log n) time and O(1) space.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 * <p>
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 */
public class LC540 {
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        for (int n : nums) {
            ans = ans ^ n;
        }
        return ans;
    }
}
