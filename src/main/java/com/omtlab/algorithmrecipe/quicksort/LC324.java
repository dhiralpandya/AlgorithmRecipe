package com.omtlab.algorithmrecipe.quicksort;

/**
 * 324. Wiggle Sort II
 * 
 * 
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 *
 * Example 1:
 *
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 * Example 2:
 *
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 * Note:
 * You may assume all input has valid answer.
 *
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class LC324 {

    /**
     * The virtual index idea in the post https://leetcode.com/discuss/77133/o-n-o-1-after-median-virtual-indexing
     * is very brilliant! However, it takes me a while to understand why and how it works. There is no 'nth_element' 
     * in Java, but you can use 'findKthLargest' function from "https://leetcode
     * .com/problems/kth-largest-element-in-an-array/" to get the median element in average O(n) time and O(1) space.
     *
     * Assume your original array is {6,13,5,4,5,2}. After you get median element, the 'nums' is partially sorted 
     * such that the first half is larger or equal to the median, the second half is smaller or equal to the median, i.e
     *
     * 13   6   5   5   4   2
     *
     *          M
     * In the post https://leetcode.com/discuss/76965/3-lines-python-with-explanation-proof, we have learned that , 
     * to get wiggle sort, you want to put the number in the following way such that
     *
     * (1) elements smaller than the 'median' are put into the last even slots
     *
     * (2) elements larger than the 'median' are put into the first odd slots
     *
     * (3) the medians are put into the remaining slots.
     *
     * Index :       0   1   2   3   4   5
     * Small half:   M       S       S    
     * Large half:       L       L       M
     * M - Median, S-Small, L-Large. 
     * In this example, we want to put {13, 6, 5} in index 1,3,5 and {5,4,2} in index {0,2,4}
     */
    public void wiggleSort(int[] nums) {
      int median = getKthLargestElement(nums, (nums.length)/2);

        /**
         * (1) elements smaller than the 'median' are put into the last even slots
         *
         * (2) elements larger than the 'median' are put into the first odd slots
         *
         * (3) the medians are put into the remaining slots.
         */

        /**
         * Why are we starting Odd From first and Even from last ????
         *  - Because it could possible that there are duplicate medians
         *  - If we start both from First then at the end all medians will be in secuence position
         *  - Something like this: [1,3,1,5,2,2]
         */
        int firstOddForLarger = 1;
        // Why nums.length-2:nums.length-1
        // Lets say correct output as per below
        // Even : [s,l,s,l,s,l] : Here last "s" is at length-2
        // Odd : [s,l,s,l,s] :  Here last "s" is at length-1
        int lastEvenForSmaller = nums.length%2==0?nums.length-2:nums.length-1;
        
        int[] result = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < median) {
                result[lastEvenForSmaller] = nums[i];
                lastEvenForSmaller-=2;
            } else if(nums[i] > median) {
                result[firstOddForLarger] = nums[i];                
                firstOddForLarger+=2;
            }
        }
        
        // Now all remaining numbers are same as median
        while(lastEvenForSmaller >= 0) {
            result[lastEvenForSmaller] =  median;
            lastEvenForSmaller-=2;
        }
        
        while(firstOddForLarger < nums.length) {
            result[firstOddForLarger] = median;
            firstOddForLarger+=2;
        }
        
        for(int i=0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }
    
    private int getKthLargestElement(int[] nums, int k) {
        int kthLargestElement = nums.length-k;
        
        int start = 0;
        int end = nums.length-1;
        while(start <= end) {
            int lastIndex = quickSort(nums, start, end);
            if(kthLargestElement < lastIndex) {
                end =  lastIndex-1;
            } else if(kthLargestElement > lastIndex) {
                start= lastIndex+1;
            } else {
                return nums[lastIndex];
            }
        }
        
        return nums[0];
    }
    
    public int quickSort(int[] nums, int start, int end) {

        
        while(start < end) {

            int pivot = nums[(start+end)/2];    
            while(nums[start] < pivot) {
                start++;
            }
            
            while(nums[end] > pivot) {
                end--;
            }
            
            if(start < end) {
                swap(nums, start, end);
                start++;
                end--;
            }
            
        }
        
        return end;
    }
    
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    

}
