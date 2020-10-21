package com.omtlab.algorithmrecipe.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream
 * <p>
 * <p>
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * <p>
 * For example,
 * [2,3,4], the median is 3
 * <p>
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * <p>
 * Design a data structure that supports the following two operations:
 * <p>
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * <p>
 * <p>
 * Example:
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * <p>
 * <p>
 * Follow up:
 * <p>
 * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */
public class LC295 {


    /*
    #####################################################################################
     First much goto documentation/LC295.jpg image to understand logic of this algorithm.
    #####################################################################################
     */

    private PriorityQueue<Integer> minHeapInDESCOrder = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> maxHeapInASCOrder = new PriorityQueue<>();
    private boolean even = true;

    public void addNum(int num) {

        //--------------------------------//
        minHeapInDESCOrder.add(num);
        // Move one Max element in maxHeapInASCOrder
        maxHeapInASCOrder.add(minHeapInDESCOrder.poll());
        //--------------------------------//
        //Lets say we keep doing above steps only, then there will be no elements in minHeapInDESCOrder.

        //We need to balance both min ahd max heap.
        if (maxHeapInASCOrder.size() > minHeapInDESCOrder.size()) {
            minHeapInDESCOrder.add(maxHeapInASCOrder.poll());
        }

        even = !even;
    }

    public double findMedian() {
        if (even) {
            return (double) ((minHeapInDESCOrder.peek() + maxHeapInASCOrder.peek()) / 2.0);
        }
        return minHeapInDESCOrder.peek();
    }
}
