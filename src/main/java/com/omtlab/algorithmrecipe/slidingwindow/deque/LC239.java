package com.omtlab.algorithmrecipe.slidingwindow.deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. Sliding Window Maximum
 * <p>
 * You are given an array of integers nums,
 * there is a sliding window of size k
 * which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 * <p>
 * Return the max sliding window.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * Example 3:
 * <p>
 * Input: nums = [1,-1], k = 1
 * Output: [1,-1]
 * Example 4:
 * <p>
 * Input: nums = [9,11], k = 2
 * Output: [11]
 * Example 5:
 * <p>
 * Input: nums = [4,-2], k = 2
 * Output: [4]
 */
public class LC239 {
    /*
    Let's use a deque (double-ended queue), the structure which pops from /
    pushes to either side with the same \mathcal{O}(1)O(1) performance.
    It's more handy to store in the deque indexes instead of elements
    since both are used during an array parsing.

    Algorithm

        The algorithm is quite straigthforward :
        Process the first k elements separately to initiate the deque.

        Iterate over the array. At each step :
            Clean the deque :
            Keep only the indexes of elements from the current sliding window.
            Remove indexes of all elements smaller than the current one, since they will not be the maximum ones.
            Append the current element to the deque.
            Append deque[0] to the output.
        Return the output array.
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dequeOfIndexWithMax = new LinkedList<>();
        int[] output = new int[nums.length - k + 1];

        int left = 0;
        for (int right = 0; right < nums.length; right++) {

            addToDeque(dequeOfIndexWithMax, right, nums);

            if (right - left == k - 1) {
                output[left] = nums[dequeOfIndexWithMax.getFirst()];
                // Only remove if left is same, Since we are sliding to right now.
                if (dequeOfIndexWithMax.getFirst() == left) {
                    dequeOfIndexWithMax.removeFirst();
                }
                left++;
            }
        }

        return output;
    }

    private void addToDeque(Deque<Integer> dequeOfIndexWithMax, int index, int[] nums) {
        while (!dequeOfIndexWithMax.isEmpty() && nums[dequeOfIndexWithMax.getLast()] < nums[index]) {
            dequeOfIndexWithMax.removeLast();
        }

        dequeOfIndexWithMax.add(index);
    }

}
