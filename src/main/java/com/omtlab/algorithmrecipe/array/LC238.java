package com.omtlab.algorithmrecipe.array;

/**
 * 238. Product of Array Except Self
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product
 * of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose
 * of space complexity analysis.)
 */
public class LC238 {
    /**
     * Approach 1: Left and Right product lists
     * It's much easier to build an intuition for solving this problem without division once you visualize how the 
     * different products except self look like for each of the elements. So, let's take a look at an example array 
     * and the different products.
     *
     *
     * Looking at the figure about we can figure another way of computing those different product values.
     *
     * Instead of dividing the product of all the numbers in the array by the number at a given index to get the 
     * corresponding product, we can make use of the product of all the numbers to the left and all the numbers to 
     * the right of the index. Multiplying these two individual products would give us the desired result as well.
     *
     * For every given index, ii, we will make use of the product of all the numbers to the left of it and multiply 
     * it by the product of all the numbers to the right. This will give us the product of all the numbers except the
     * one at the given index ii. Let's look at a formal algorithm describing this idea more concretely.
     *
     * Algorithm
     *
     * Initialize two empty arrays, L and R where for a given index i, L[i] would contain the product of all the 
     * numbers to the left of i and R[i] would contain the product of all the numbers to the right of i.
     * We would need two different loops to fill in values for the two arrays. For the array L, L[0]L[0] would be 1 
     * since there are no elements to the left of the first element. For the rest of the elements, we simply use L[i]
     * = L[i - 1] * nums[i - 1]L[i]=L[i−1]∗nums[i−1]. Remember that L[i] represents product of all the elements to 
     * the left of element at index i.
     * For the other array, we do the same thing but in reverse i.e. we start with the initial value of 1 in R[length
     * - 1]R[length−1] where lengthlength is the number of elements in the array, and keep updating R[i] in reverse. 
     * Essentially, R[i] = R[i + 1] * nums[i + 1]R[i]=R[i+1]∗nums[i+1]. Remember that R[i] represents product of all 
     * the elements to the right of element at index i.
     * Once we have the two arrays set up properly, we simply iterate over the input array one element at a time, and
     * for each element at index i, we find the product except self as L[i] * R[i]L[i]∗R[i].
     * Let's go over a simple run of the algorithm that clearly depicts the construction of the two intermediate 
     * arrays and finally the answer array.
     * @param input
     * @return
     */

    /**
     * LEFT contains all the product of left elements "excluding current index." 
     * RIGHT contains all the product of right elements "excluding current index."
     * LEFT*RIGHT = product of all left and right elements "excluding current index."
     * @param input
     * @return
     */
    public int[] productExceptSelf(int[] input) {
        int[] left = new int[input.length];
        int[] right = new int[input.length];


        left[0] = 1;
        right[input.length - 1] = 1;

        for (int i = 1; i < input.length; i++) {
            left[i] = left[i - 1] * input[i - 1];
            right[input.length - 1 - i] = right[input.length - 1 - i + 1] * input[input.length - 1 - i + 1];
        }

        int[] output = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = left[i] * right[i];
        }

        return output;
    }


    public int[] productExceptSelfOptimal(int[] input) {
        int[] left = new int[input.length];


        left[0] = 1;

        for (int i = 1; i < input.length; i++) {
            left[i] = left[i - 1] * input[i - 1];
        }

        int right = 1;
        for (int i = input.length-1; i>=0; i--) {
            left[i] = left[i] * right;
            right = right*input[i];
        }

        return left;
    }
}
