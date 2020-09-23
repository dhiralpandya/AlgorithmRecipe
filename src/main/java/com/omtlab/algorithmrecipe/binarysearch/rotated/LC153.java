package com.omtlab.algorithmrecipe.binarysearch.rotated;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * Example 1:
 *
 * Input: [3,4,5,1,2] 
 * Output: 1
 * Example 2:
 *
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */
public class LC153 {

    public int findMin(int[] a) {
        
        
        int start = 0;
        int end = a.length-1;
        int min = start + ((end-start)/2);
        
        while(start <= end){
            int mid = start + ((end-start)/2);

            int startValue = a[start];
            int endValue = a[end];
            int midValue = a[mid];
            int minValue = a[min];
            
            if(minValue > startValue){
                min = start;
                minValue = a[min]; //Updated for next if condition  if(minValue > midValue)
            }
            
            if(minValue > midValue){
                min = mid;
                minValue = a[min];//Updated for next if condition  if(minValue > endValue)
            }
            
            if(minValue > endValue){
                min = end;
                minValue = a[min];//Updated for next if condition
            }
            
            if(midValue > startValue){
                if(startValue > endValue){
                    start=mid+1;
                }else {
                    end = mid-1;
                }
            } else {
                end = mid-1;
            }
        }
        
        return a[min];
    }
    
}
