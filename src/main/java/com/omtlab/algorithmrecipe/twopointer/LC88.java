package com.omtlab.algorithmrecipe.twopointer;

/**
 * 88. Merge Sorted Array
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements 
 * from nums2.
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 */
public class LC88 {

    /**
     * Just remember we have to start from end for both input array and no swapping required here.
     */
    public void mergeOptimal(int[] num1,int m, int[] num2,int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        
        while(i >=0 && j >=0){
            if(num1[i] > num2[j]){
                num1[k--]=num1[i--];
            } else {
                num1[k--] = num2[j--];
            }
        }
        
        while(j >=0){
            num1[k--] = num2[j--];
        }
    }





        /**
         * Below solution would not work for input
         * 
         * [4,5,6,0,0,0]
         * 3
         * [1,2,3]
         * 3
         * 
         */
    public void merge(int[] num1,int m, int[] num2,int n){
        int currentN1  = 0;
        int currentN2 = 0;
        while(currentN1 < m){
            int n1 = num1[currentN1];
            int n2 = num2[currentN2];
            
            if(n1 > n2){
                num1[currentN1] = n2;
                num2[currentN2] = n1;
            }
            currentN1++;
        }

        while(currentN2 < n){
            int n1 = num1[currentN1];
            int n2 = num2[currentN2];
            if(n1 == 0){
                num1[currentN1] = n2;
                currentN2++;
            } else if(n1 > n2){
                num1[currentN1] = n2;
                num2[currentN2] = n1;
                currentN1++;
            } else {
                currentN1++;
            }
            
        }
    }
    
}
