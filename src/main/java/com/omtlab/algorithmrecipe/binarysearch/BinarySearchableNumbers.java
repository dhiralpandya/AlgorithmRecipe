package com.omtlab.algorithmrecipe.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary search is a search algorithm usually used on a sorted sequence to quickly find an element with a given value. In this problem we will evaluate how binary search performs on data that isn't necessarily sorted. An element is said to be binary searchable if, regardless of how the pivot is chosen the algorithm returns true. For example:
 * <p>
 * [2, 1, 3, 4, 6, 5] and target = 5, we cannot find 5. Because when the pivot is 4, we get element 6, then right pointer will move left, so we'll lose the opportunity to find target 5.
 * [2, 1, 3, 4, 5, 6] and target = 5, we can find 5. Because wherever we choose the pivots, we'll find target at last.
 * Given an unsorted array of n distinct integers, return the number of elements that are binary searchable.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 3, 2]
 * Output: 1
 * Explanation: However we choose the pivots, we will always find the number 1 when looking for it. This does not hold for 3 and 2.
 * Example 2:
 * <p>
 * Input: [2, 1, 3, 5, 4, 6]
 * Output: 2
 * Explanation: 3 and 6 are the numbers guaranteed to be found.
 * Example 3:
 * <p>
 * Input: [1, 5, 7, 11, 12, 18]
 * Output: 6
 * Explanation: All elements in a sorted sequence are binary searchable.
 * Example 4:
 * <p>
 * Input: [3, 2, 1]
 * Output: 0
 * Explanation: No numbers guaranteed to be found.
 * Example 5:
 * <p>
 * Input: [5, 4, 6, 2, 8]
 * Output: 1
 * Explanation: Only 8 is guaranteed to be found.
 * Example 6:
 * <p>
 * Input: [1, 3, 2, 4, 5, 7, 6, 8]
 * Output: 4
 */
public class BinarySearchableNumbers {

    public List<Integer> getBinarySearchableNumbers(List<Integer> input) {
        /**
         * Binary Searchable Number has no elements on left bigger than it,
         * an no elements on right smaller than it on.
         */
        int[] leftMax = new int[input.size()];
        int[] rightMin = new int[input.size()];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < input.size(); i++) {
            max = Math.max(max, input.get(i));
            leftMax[i] = max;
        }

        int min = Integer.MAX_VALUE;
        for (int i = input.size() - 1; i >= 0; i--) {
            min = Math.min(min, input.get(i));
            rightMin[i] = min;
        }


        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            Integer n = input.get(i);
            if (leftMax[i] <= n && n <= rightMin[i]) {
                output.add(n);
            }
        }
        return output;
    }
}
