package com.omtlab.algorithmrecipe.bit;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * https://www.geeksforgeeks.org/find-the-two-numbers-with-odd-occurences-in-an-unsorted-array/
 * <p>
 * Find the two numbers with odd occurrences in an unsorted array
 * <p>
 * Given an unsorted array that contains even number of occurrences for all numbers except two numbers. Find the two numbers which have odd occurrences in O(n) time complexity and O(1) extra space.
 * Examples:
 * <p>
 * Input: {12, 23, 34, 12, 12, 23, 12, 45}
 * Output: 34 and 45
 * <p>
 * Input: {4, 4, 100, 5000, 4, 4, 4, 4, 100, 100}
 * Output: 100 and 5000
 * <p>
 * Input: {10, 20}
 * Output: 10 and 20
 */
public class GFGTwoNumOddTimes {

    public List<Integer> getTwoOddOccurrencesNumbers(int[] input) {
        int xor = 0;
        for (int n : input) {
            xor = xor ^ n;
        }

        int position = findPositionForFirstOne(xor);

        int xor1 = 0;
        int xor2 = 0;

        for (int n : input) {
            // Use "temp" because we don't want to modify actual number("n") here.
            int temp = n >> position;
            if ((temp & 1) == 1) {
                xor1 ^= n;
            } else {
                xor2 ^= n;
            }
        }

        return Lists.newArrayList(xor1, xor2);
    }

    private int findPositionForFirstOne(int xor) {
        int position = 0;
        while ((xor & 1) != 1) {
            xor = xor >> 1;
            position++;
        }
        return position;
    }

}
