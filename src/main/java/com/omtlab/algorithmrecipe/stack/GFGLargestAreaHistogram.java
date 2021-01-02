package com.omtlab.algorithmrecipe.stack;

import java.util.Stack;

/**
 * Largest Rectangular Area in a Histogram
 * https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 * <p>
 * Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a
 * number of contiguous bars. For simplicity, assume that all bars have same width and the width is 1 unit.
 * For example, consider the following histogram with 7 bars of heights {6, 2, 5, 4, 5, 1, 6}. The largest possible
 * rectangle possible is 12 (see the below figure, the max area rectangle is highlighted in red)
 * <p>
 * Find image in Documentation/GFGLargestAreaHistogram.png
 */
public class GFGLargestAreaHistogram {

    /**
     * Video : https://www.youtube.com/watch?v=ZmnqCZp9bBs&t=606s
     * Video : https://www.youtube.com/watch?v=VNbkzsnllsU
     * Check image before jump to solution
     * Documentation/GFGLargestAreaHistogram.png
     * <p>
     * We are going to solve this problem using stack
     * We will keep pushing index in stack if value is larger than peek from stack.
     * If we get less value we will pop from stack until we will get same or less value than current
     */
    public int getArea(int[] input) {
        int max = 0;

        Stack<Integer> stack = new Stack<>();


        for (int index = 0; index < input.length; index++) {
            if (stack.isEmpty()) {
                stack.push(index);
            } else {
                int preValue = input[stack.peek()];
                int currentValue = input[index];

                if (currentValue < preValue) {
                    while (!stack.isEmpty() && input[stack.peek()] > currentValue) {
                        int preIndex = stack.pop();
                        int prepreIndex = stack.isEmpty() ? 0 : stack.peek();
                        // We should include last index in calculation 
                        // since there is no other index to calculate 
                        // we need last index as part of our final calculation
                        boolean isLastIndex = stack.isEmpty();
                        int lastIndexAddOneMoreOne = isLastIndex ? 1 : 0;


                        int newMax = input[preIndex] * ((index - 1) - prepreIndex + lastIndexAddOneMoreOne);
                        max = Math.max(max, newMax);
                    }
                }
                stack.push(index);
            }

        }

        while (!stack.isEmpty()) {
            int lastIndex = input.length;

            int preIndex = stack.pop();
            int prepreIndex = stack.isEmpty() ? 0 : stack.peek();
            // We should include last index in calculation 
            // since there is no other index to calculate 
            // we need last index as part of our final calculation
            boolean isLastIndex = stack.isEmpty();
            int lastIndexAddOneMoreOne = isLastIndex ? 1 : 0;

            int newMax = input[preIndex] * ((lastIndex - 1) - prepreIndex + lastIndexAddOneMoreOne);
            max = Math.max(max, newMax);
        }

        return max;
    }
}
