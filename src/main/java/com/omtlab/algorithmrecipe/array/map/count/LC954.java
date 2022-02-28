package com.omtlab.algorithmrecipe.array.map.count;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 954. Array of Doubled Pairs
 *
 * Given an integer array of even length arr, return true if it is possible to reorder arr such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [3,1,3,6]
 * Output: false
 * Example 2:
 *
 * Input: arr = [2,1,2,6]
 * Output: false
 * Example 3:
 *
 * Input: arr = [4,-2,2,-4]
 * Output: true
 * Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
 */
public class LC954 {

    public boolean canReorderDoubled(int[] arr) {
        /**
         * arr[2 * i + 1] = 2 * arr[2 * i]
         * that means 1=0, 3=2, 5=4 .... so on. also we want double of the value we have in one place.
         * for example 1=0 if lets say 1=2 then 0 should be 2+2 = 4
         *
         * Solution is similar to what we did in LC2007.java
         */
        if (arr.length%2 == 1) { // We need even to get double of each entries. for example [3,6] is valid but [3] is invalid.
            return false;
        }

        // Here we have positive and negative both so we are going to take two map, One for positive and other one for negative.
        Map<Integer, Integer> positiveMapOfDigitAndCount = new TreeMap<>(); // TreeMap is very important because we need sorting on element, smaller first.
        Map<Integer, Integer> negativeMapOfDigitAndCount = new TreeMap<>(Comparator.reverseOrder()); // Negative bigger first, Ex: -2,-3,-4,-6
        for (int d : arr) {
            if (d < 0) {
                negativeMapOfDigitAndCount.put(d, negativeMapOfDigitAndCount.getOrDefault(d,0)+1);
            } else
            {
                positiveMapOfDigitAndCount.put(d, positiveMapOfDigitAndCount.getOrDefault(d,0)+1);
            }
        }

        return validate(positiveMapOfDigitAndCount) && validate(negativeMapOfDigitAndCount);
    }

    private boolean validate(Map<Integer, Integer> digitCountMap) {
        for (Integer key : digitCountMap.keySet()) {
            if (digitCountMap.get(key) > digitCountMap.getOrDefault(key+key, 0)) {
                return false;
            }

            //IMP step, recalculate value of key+key, Example: 2,2,4,4,4,8, Here 2,2,4,4 is one pair and 4,8 is other.
            digitCountMap.put(key+key, digitCountMap.getOrDefault(key+key,0) - digitCountMap.get(key));
        }
        return true;
    }


}
