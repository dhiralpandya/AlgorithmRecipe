package com.omtlab.algorithmrecipe.twopointer;

import org.apache.commons.lang3.ArrayUtils;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * 977. Squares of a Sorted Array
 *
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 *
 * Example 2:
 *
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 */
public class LC977 {

    /**
     * There are many way to solve this issue.
     * nLog(n) way
     * 1. Use binary search to identify position of number after squares
     * - This require binary search for each number. which will be nLog(n)
     * 2. Use two stacks. We will keep pushing in one stack if peek is greater then current.
     * Otherwise we will do pop and push it to second stack until first stake peek greater then current.
     * This also requires kind of more than n
     * <p>
     * Great solution
     * 3. Use two pointers on input and output start with last position.
     */
    public int[] sortedSquares(int[] input) {
        int[] output = new int[input.length];
        int leftPointer = 0;
        int rightPointer = input.length - 1;

        int outputPointerStartsFromEnd = input.length - 1;

        while (outputPointerStartsFromEnd >= 0) {
            int leftSquares = (int) Math.pow(input[leftPointer], 2);
            int rightSquares = (int) Math.pow(input[rightPointer], 2);

            if (leftSquares > rightSquares) {
                output[outputPointerStartsFromEnd] = leftSquares;
                leftPointer++;
            } else {
                output[outputPointerStartsFromEnd] = rightSquares;
                rightPointer--;
            }

            outputPointerStartsFromEnd--;
        }

        return output;
    }

    public void sortedSquaresInplaceLessSpace(int[] input) {
        int right = input.length -1;
        int leftAlwaysZero = 0;
        while(right > 0) {
            int sqrLeft = (int)pow(input[leftAlwaysZero], 2);
            int sqrRight = (int)pow(input[right], 2);

            if(sqrLeft > sqrRight) {
                ArrayUtils.swap(input, leftAlwaysZero, right);
            }
            right--;
        }
        for (int index = 0; index < input.length; index++) {
            input[index] = (int) pow(input[index], 2);
        }
    }
}