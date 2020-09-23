package com.omtlab.algorithmrecipe.binarysearch.rotated;

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
    public int searchSimpleWay(int[] a, int target){
        int found = -1;

        int start =  0;
        int end = a.length-1;

        while(start <= end){
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

            // MID is greater than start so we have two main possibilities
            //1. If target is less than start then move to right side
            //2. If target is greater than mid then also move to right side, Because since start is less than mid all left side is less than mid, 
            if(midValue > startValue){ 
                if(target < startValue || target > midValue){
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            } else {//Here mid is less than start. so we have two main possibilities
                //1. Check if target is greater than end then move to left Side
                //2. All the right side value [mid+1] is greater than mid, So if target is less than mid then target should NOT be there at right side, So move to left side
                if(target > endValue || target < midValue){
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }
        }

        return found;
    }
    
    
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
            
            if(midValue > startValue){//All of left side is less than mid. 
                if(target > midValue){//Since all left is less than mid and target is greater than mid we will move right side
                    start=mid+1;
                } else if(target > startValue){// Here target is less than mid, if target is greater than start, It means target is between start and mid
                    end = mid-1;
                } else { // Here target is less than mid and less than start, It means we should look for right side
                    start=mid+1;
                }
            } else { 
                if(target < midValue){//Here mid is less than start and  target is less than mid  
                    if(midValue < endValue && target < endValue){ //To handle [5,1,2,3,4] to check mid is less than end and  target is also less than end then move to left
                        end = mid-1;
                    } else { // Sine target is less than mid and mid is less than start and above condition is also false so we have only one why to check 
                        start = mid+1;
                    }
                } else if(target > endValue){//We target is greater than end it means all we need is at right side
                    end = mid-1;
                } else {// Remaining place is right side only
                    start = mid+1;
                }
            }
        }
        
        return found;
    }
    
    
    
    
    
    
}
