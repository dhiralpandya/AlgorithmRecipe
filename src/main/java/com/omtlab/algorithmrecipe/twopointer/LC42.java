package com.omtlab.algorithmrecipe.twopointer;

/**
 * 42. Trapping Rain Water
 *
 * Given n non-negative integers representing
 * an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 * Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 * Solution video : https://www.youtube.com/watch?v=pq7Xon_VXeU&t=525s
 */
public class LC42 {
    public int trap(int[] height) {
        int sum = 0;

        int leftMax = 0;
        int rightMax = 0;

        int leftPointer = 0;
        int rightPointer = height.length-1;

        while(leftPointer < rightPointer) {
            int leftValue = height[leftPointer];
            int rightValue = height[rightPointer];

            if(leftValue > rightValue) {
                rightPointer--;
                if(rightMax > rightValue) {
                    sum+=rightMax-rightValue;
                } else {
                    rightMax = rightValue;
                }
            } else {
                leftPointer++;
                if(leftMax > leftValue) {
                    sum+=leftMax - leftValue;
                } else {
                    leftMax = leftValue;
                }
            }
        }

        return sum;
    }
}
