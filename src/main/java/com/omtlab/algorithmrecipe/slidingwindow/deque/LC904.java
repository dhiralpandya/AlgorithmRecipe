package com.omtlab.algorithmrecipe.slidingwindow.deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 904. Fruit Into Baskets
 * <p>
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 * <p>
 * You start at any tree of your choice, then repeatedly perform the following steps:
 * <p>
 * Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 * Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
 * <p>
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
 * <p>
 * What is the total amount of fruit you can collect with this procedure?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,1]
 * Output: 3
 * Explanation: We can collect [1,2,1].
 * Example 2:
 * <p>
 * Input: [0,1,2,2]
 * Output: 3
 * Explanation: We can collect [1,2,2].
 * If we started at the first tree, we would only collect [0, 1].
 * Example 3:
 * <p>
 * Input: [1,2,3,2,2]
 * Output: 4
 * Explanation: We can collect [2,3,2,2].
 * If we started at the first tree, we would only collect [1, 2].
 * Example 4:
 * <p>
 * Input: [3,3,3,1,2,1,1,2,3,3,4]
 * Output: 5
 * Explanation: We can collect [1,2,1,1,2].
 * If we started at the first tree or the eighth tree, we would only collect 4 fruits.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= tree.length <= 40000
 * 0 <= tree[i] < tree.length
 */
public class LC904 {

    /**
     * Read problem carefully this is easy problem to do if you understand the problem.
     */
    public int totalFruit(int[] tree) {
        // Here we need largest sub-array of two type of integers.

        // We will put First Type in first place and 2nd type in last place.
        Deque<Integer> deque = new LinkedList<>();

        int max = 0;
        int start = 0;

        for (int end = 0; end < tree.length; end++) {
            int type = tree[end];

            while (isThatThirdType(deque, type)) {
                removePreviousType(deque, tree[start]);
                start++;
            }

            addType(deque, type);
            max = Math.max(max, deque.size());
        }

        return max;
    }

    private void addType(Deque<Integer> deque, int type) {
        if (deque.isEmpty()) {
            deque.addFirst(type);
            return;
        }

        if (deque.peekFirst() == type) {
            deque.addFirst(type);
            return;
        }

        deque.addLast(type);
    }

    private void removePreviousType(Deque<Integer> deque, int type) {
        if (deque.isEmpty()) {
            return;
        }

        if (deque.peekFirst() == type) {
            deque.removeFirst();
            return;
        }

        if (deque.peekLast() == type) {
            deque.removeLast();
            return;
        }
    }

    private boolean isThatThirdType(Deque<Integer> deque, int type) {
        if (deque.isEmpty()
                || deque.peekFirst() == type
                || deque.peekLast() == type
                // Check if deque has only single type.
                || deque.peekFirst() == deque.peekLast()) {
            return false;
        }

        return true;
    }

}
