package com.omtlab.algorithmrecipe.array.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * 846. Hand of Straights
 * <p>
 * Alice has a hand of cards, given as an array of integers.
 * <p>
 * Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
 * <p>
 * Return true if and only if she can.
 * <p>
 * Note: This question is the same as 1296: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
 * Example 2:
 * <p>
 * Input: hand = [1,2,3,4,5], W = 4
 * Output: false
 * Explanation: Alice's hand can't be rearranged into groups of 4.
 */
public class LC846 {

    public boolean isNStraightHand(int[] hand, int W) {
        Map<Integer, Integer> cardToCountMap = new TreeMap<>();

        for (int i : hand) {
            cardToCountMap.put(i, cardToCountMap.getOrDefault(i, 0) + 1);
        }

        for (Integer key : cardToCountMap.keySet()) {
            if (cardToCountMap.get(key) == 0) {
                continue;
            }

            int preKey = key;
            for (int i = 1; i < W; i++) {
                if (cardToCountMap.get(preKey) > cardToCountMap.getOrDefault(preKey + 1, 0)) {
                    return false;
                }
                cardToCountMap.put(preKey + 1, cardToCountMap.get(preKey + 1) - cardToCountMap.get(preKey));
                cardToCountMap.put(preKey, 0);
                preKey = preKey + 1;
            }
        }

        return true;
    }

}
