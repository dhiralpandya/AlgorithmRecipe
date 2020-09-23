package com.omtlab.algorithmrecipe.binarysearch;

/**
 * 410. Split Array Largest Sum
 * 
 * 
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty 
 * continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 *
 * Note:
 * If n is the length of array, assume the following constraints are satisfied:
 *
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * Examples:
 *
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 *
 * Output:
 * 18
 *
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 * 
 * 
 * Trying these problems beforehand should make it easy to understand -
 * https://leetcode.com/problems/koko-eating-bananas/
 * https://leetcode.com/problems/minimize-max-distance-to-gas-station/
 */
public class LC410 {


    public int splitArray(int[] nums, int maxPartition) {
        int max = 0;
        int sum = 0;
        for(int n:nums){
            max = Math.max(max,n);
            sum+=n;
        }
        
        int start = max;
        int end = sum;
        int output = 0;
        
        while(start <= end){
            int mid = (start+end)/2;
            int partition = getNumberOfPartitions(mid,maxPartition,nums);
            // More partition means our "mid" is too small thats why its creating more partition. Make "mid" bigger.
            if(partition > maxPartition){
                String log = "[IN START] Start:"+start+" End:"+end+" Mid:"+mid+" Partition:"+partition;
                start=mid+1;
                output = start;
                log+=" Output:"+output+" Now start:"+start;
                System.out.println(log);
            } else { // Less partition means "mid" is too big, Make "mid" smaller
                String log = "[IN END] Start:"+start+" End:"+end+" Mid:"+mid+" Partition:"+partition+" Output:"+output;
                end = mid-1;
                log+=" Now end:"+end;
                System.out.println(log);
            }
        }
        return output;
    }
    
    
    public int getNumberOfPartitions(int mid, int maxPartition, int[] nums){
        int currentPartition=1;//This is most IMP Step, Always set this to 1 to avoid issues.
        int currentSum = 0;
        for(int n:nums){
            currentSum+=n;
            if(currentSum > mid){
                currentPartition++;
                currentSum = n;
            }
        }
        return currentPartition;
    }
}
