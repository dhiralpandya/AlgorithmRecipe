package com.omtlab.algorithmrecipe.binarysearch.rotated;

/**
 * 81. Search in Rotated Sorted Array II
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * Follow up:
 *
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 */
public class LC81 {

    /**
     * JUST Remember and focus on FOUR things 
     * 1. TARGET - MAke sure you focus on where your target is in array 
     * 2. MID - Where is your mid 
     * 3. START 
     * 4. END 
     *
     *
     * @param a
     * @param target
     * @return
     */
    public boolean searchSimpleWay(int[] a, int target){
        boolean found = false;

        int start =  0;
        int end = a.length-1;

        while(start <= end){
            int mid = start+((end-start)/2);

            int startValue = a[start];
            int endValue = a[end];
            int midValue = a[mid];

            if(midValue == target){
                return true;
            }

            if(startValue == target){
                return true;
            }

            if(endValue == target){
                return true;
            }

            // MID is greater than start so we have two main possibilities
            //1. If target is less than start then move to right side
            //2. If target is greater than mid then also move to right side, Because since start is less than mid all left side is less than mid, 
            if(midValue > startValue){
                if(target < startValue || target > midValue){
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            } else if(midValue < startValue) {//Here mid is less than start. so we have two main possibilities
                //1. Check if target is greater than end then move to left Side
                //2. All the right side value [mid+1] is greater than mid, So if target is less than mid then target should NOT be there at right side, So move to left side
                if(target > endValue || target < midValue){
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }else {
                //Duplicate value, Just move start or end one step 
                start++;
            }
        }

        return found;
    }
}
