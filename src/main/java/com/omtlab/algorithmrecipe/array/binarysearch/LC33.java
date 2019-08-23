package com.omtlab.algorithmrecipe.array.binarysearch;

/**
 * 33. Search in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class LC33 {
    
    
    
    public int search(int[] a, int target){
        int found = -1;
        
        int start =  0;
        int end = a.length-1;
        
        while(start < end){
            int mid = start+((end-start)/2);
            
            int startValue = a[start];
            int endValue = a[end];
            int midValue = a[mid];
            
            if(midValue == target){
                return mid;
            }
            
            if(startValue == target){
                return start;
            }
            
            if(endValue == target){
                return end;
            }
            
            if(midValue > startValue){
                if(target > midValue){
                    start=mid+1;
                } else if(target > startValue){
                    end = mid-1;
                } else {
                    start=mid+1;
                }
            } else { 
                if(target < midValue){
                    if(midValue < endValue && target < endValue){
                        end = mid-1;
                    } else {
                        start = mid+1;
                    }
                } else if(target > endValue){
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }
        }
        
        return found;
    }
    
    
    
    
    
    
}
