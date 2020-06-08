package com.omtlab.algorithmrecipe.quicksort;

/**
 * Please check LC215 for largest element
 */
public class KthSmalletsElement {
    
    public int getKthSmalletsElement(int[] nums, int k){
        int kthElementFromStartInSortedArray = k-1;
        int start = 0;
        int end = nums.length -1;
        while (start <= end){
            int lastStart = quickSort(nums,start,end);
            if(lastStart < kthElementFromStartInSortedArray){
                start = lastStart+1;
            } else if(lastStart > kthElementFromStartInSortedArray){
                end = lastStart-1;
            } else  {
                return nums[kthElementFromStartInSortedArray];
            }
        }
        
        return nums[nums.length-1];
    }
    
    public  int quickSort(int[] nums, int start, int end){
        
        while(start < end){

            int pivote = nums[(start+end)/2];

            
            while(nums[start] < pivote){
                start++;
            }
            
            while(nums[end] > pivote){
                end--;
            }
            
            if(start <  end){
                swap(start,end,nums);
            }
        }
        
        return start;
    }


    public void swap(int start, int end, int[] nums){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    
}
