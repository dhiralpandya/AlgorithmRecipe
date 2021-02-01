package com.omtlab.algorithmrecipe.binarysearch;

/**
 * 528. Random Pick with Weight
 * <p>
 * You are given an array of positive integers w where w[i] describes the weight of ith index (0-indexed).
 * <p>
 * We need to call the function pickIndex() which randomly returns an integer in the range [0, w.length - 1]. pickIndex() should return the integer proportional to its weight in the w array. For example, for w = [1, 3], the probability of picking the index 0 is 1 / (1 + 3) = 0.25 (i.e 25%) while the probability of picking the index 1 is 3 / (1 + 3) = 0.75 (i.e 75%).
 * <p>
 * More formally, the probability of picking index i is w[i] / sum(w).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output
 * [null,0]
 * <p>
 * Explanation
 * Solution solution = new Solution([1]);
 * solution.pickIndex(); // return 0. Since there is only one single element on the array the only option is to return the first element.
 * Example 2:
 * <p>
 * Input
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output
 * [null,1,1,1,1,0]
 * <p>
 * Explanation
 * Solution solution = new Solution([1, 3]);
 * solution.pickIndex(); // return 1. It's returning the second element (index = 1) that has probability of 3/4.
 * solution.pickIndex(); // return 1
 * solution.pickIndex(); // return 1
 * solution.pickIndex(); // return 1
 * solution.pickIndex(); // return 0. It's returning the first element (index = 0) that has probability of 1/4.
 * <p>
 * Since this is a randomization problem, multiple answers are allowed so the following outputs can be considered correct :
 * [null,1,1,1,1,0]
 * [null,1,1,1,1,1]
 * [null,1,1,1,0,0]
 * [null,1,1,1,0,1]
 * [null,1,0,1,0,0]
 * ......
 * and so on.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 */
public class LC528 {
    // Find documentation with name LC528.pdf
    private final int[] input;
    private int[] sumAtEachIndex;
    private int totalSum;

    public LC528(int[] input) {
        this.input = input;
        init();
    }

    private void init() {
        sumAtEachIndex = new int[input.length];
        for (int index = 0; index < input.length; index++) {
            totalSum += input[index];
            sumAtEachIndex[index] = totalSum;
        }
    }

    public int pickIndex() {
        // Why Math.Random()
        // Returns a double value with a positive sign,
        // greater than or equal to 0.0 and less than 1.0.
        double target = (int) (totalSum * Math.random());
        int start = 0;
        int end = sumAtEachIndex.length;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target > sumAtEachIndex[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}
