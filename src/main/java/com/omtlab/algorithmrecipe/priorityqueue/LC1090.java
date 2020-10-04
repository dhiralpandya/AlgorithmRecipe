package com.omtlab.algorithmrecipe.priorityqueue;

import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1090. Largest Values From Labels
 *
 * We have a set of items: the i-th item has value values[i] and label labels[i].
 *
 * Then, we choose a subset S of these items, such that:
 *
 * |S| <= num_wanted
 * For every label L, the number of items in S with label L is <= use_limit.
 * Return the largest possible sum of the subset S.
 *
 *
 *
 * Example 1:
 *
 * Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
 * Output: 9
 * Explanation: The subset chosen is the first, third, and fifth item.
 * Example 2:
 *
 * Input: values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
 * Output: 12
 * Explanation: The subset chosen is the first, second, and third item.
 * Example 3:
 *
 * Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 1
 * Output: 16
 * Explanation: The subset chosen is the first and fourth item.
 * Example 4:
 *
 * Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 2
 * Output: 24
 * Explanation: The subset chosen is the first, second, and fourth item.
 */
public class LC1090 {
    public int largestValsFromLabels(Integer[] values, Integer[] labels, int totalMaxItemsToPick, int limitOnLabel) {
        PriorityQueue<Item> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < values.length; i++) {
          maxHeap.add(new Item(values[i], labels[i]));
        }

        Map<Integer, Integer> labelToPickCount = new HashMap<>();

        int sum = 0;

        while (!maxHeap.isEmpty() && totalMaxItemsToPick > 0) {
           Item item = maxHeap.poll();
           int timesLabelPicked = labelToPickCount.getOrDefault(item.label, 0);
           if(limitOnLabel == timesLabelPicked) {
               continue;
           }

           sum+=item.value;
           totalMaxItemsToPick--;
           labelToPickCount.put(item.label, timesLabelPicked + 1);
        }

        return sum;
    }

    @AllArgsConstructor
    private static class Item implements Comparable<Item> {
        Integer value;
        Integer label;

        @Override
        public int compareTo(Item item) {
            return this.value - item.value;
        }
    }
}
