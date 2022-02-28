package com.omtlab.algorithmrecipe.array.map.count;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * An integer array original is transformed into a doubled array changed by appending twice the value of every element in original, and then randomly shuffling the resulting array.
 * <p>
 * Given an array changed, return original if changed is a doubled array. If changed is not a doubled array, return an empty array. The elements in original may be returned in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: changed = [1,3,4,2,6,8]
 * Output: [1,3,4]
 * Explanation: One possible original array could be [1,3,4]:
 * - Twice the value of 1 is 1 * 2 = 2.
 * - Twice the value of 3 is 3 * 2 = 6.
 * - Twice the value of 4 is 4 * 2 = 8.
 * Other original arrays could be [4,3,1] or [3,1,4].
 * Example 2:
 * <p>
 * Input: changed = [6,3,0,1]
 * Output: []
 * Explanation: changed is not a doubled array.
 * Example 3:
 * <p>
 * Input: changed = [1]
 * Output: []
 * Explanation: changed is not a doubled array.
 */
public class LC2007 {
    public int[] findOriginalArray(int[] changed) {
        if (changed == null
                || changed.length == 0
                || changed.length % 2 == 1) {
            return new int[0];
        }

        Map<Integer, Integer> count = new TreeMap<>();  // TreeMap is very important because we need sorting on element, smaller first.
        int[] result = new int[changed.length / 2];
        int resultPointer = 0;
        for (int d : changed) {
            count.put(d, count.getOrDefault(d, 0) + 1);
        }

        for (int key : count.keySet()) {
            // We only care about greater than not less than because 2,2,4,4,4,8, here 2,2 has 4,4 and 4 has 8
            if (count.get(key) > count.getOrDefault(key + key, 0)) {
                return new int[0];
            }

            for (int i = 0; i < count.get(key); i++) {
                result[resultPointer++] = key;
                count.put(key + key, count.get(key + key) - 1);
            }
        }
        return result;
    }
}
