package com.omtlab.algorithmrecipe.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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
        final Map<Integer, Integer> typeToCount = new HashMap<>();

        int max = 0;
        int start = 0;
        for (int end = 0; end < tree.length; end++) {
            int type = tree[end];
            typeToCount.put(type, typeToCount.getOrDefault(type, 0) + 1);

            while (typeToCount.size() == 3) {
                typeToCount.put(tree[start],
                        typeToCount.getOrDefault(tree[start], 1) - 1);
                if (typeToCount.get(tree[start]) == 0) {
                    typeToCount.remove(tree[start]);
                }

                start++;
            }

            AtomicInteger atomicInteger = new AtomicInteger();
            typeToCount.values().stream().forEach(atomicInteger::addAndGet);
            max = Math.max(max, atomicInteger.get());
        }

        return max;
    }

}
