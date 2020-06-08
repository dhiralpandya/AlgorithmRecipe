package com.omtlab.algorithmrecipe.quicksort;

import java.util.Arrays;

/**
 * 215. Kth Largest Element in an Array
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, 
 * not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class LC215 {

    /**
     * This is not an optimal solution, We have to do quick sort with partition
     * @param nums
     * @param k
     * @return
     */
    public int getKthLargest(int[] nums, int k) {
      Arrays.sort(nums);//Note that it is the kth largest element in the sorted order,
        //  not the kth distinct element.
      return nums[nums.length-k];
    }
    
    
    public int getKthLargetWithQuickSort(int[] nums, int k){
        
        int kthElementFromLastInSortedArray = nums.length-k; //IMP Step
        
        int start = 0;
        int end = nums.length-1;
        
        while (start <= end){
            int lastEnd = quickSort(nums,start,end);
            if(kthElementFromLastInSortedArray < lastEnd){
                end = lastEnd-1;
            } else if(kthElementFromLastInSortedArray > lastEnd){
                start = lastEnd +1;
            } else {
                return nums[kthElementFromLastInSortedArray];
            }
        }
        //Lets say [1,2,3] and we need 3rd largest element means length[3] - k[3] = 0 means end would be at 0
        return nums[0];
    }
    
    public int quickSort(int[] nums, int start, int end){
        
        
        while (start < end){

            int pivot = nums[(start+end)/2];
            
            while(nums[start] < pivot){
                start++;
            }
            
            while(nums[end] > pivot){
                end--;
            }
            
            if(start < end){
                swap(start,end,nums);
                //We have commented out below code to avoid issue with input {3,2,1,5,6,4}
                //start++;
                //end--;
            }
        }
        return end;
    }
    
    public void swap(int start, int end, int[] nums){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
