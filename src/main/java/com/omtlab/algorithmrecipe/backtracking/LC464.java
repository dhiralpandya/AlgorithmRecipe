package com.omtlab.algorithmrecipe.backtracking;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In the "100 game" two players take turns adding, to a running total, any integer from 1 to 10. The player who first causes the running total to reach or exceed 100 wins.
 * <p>
 * What if we change the game so that players cannot re-use integers?
 * <p>
 * For example, two players might take turns drawing from a common pool of numbers from 1 to 15 without replacement until they reach a total >= 100.
 * <p>
 * Given two integers maxChoosableInteger and desiredTotal, return true if the first player to move can force a win, otherwise return false. Assume both players play optimally.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: maxChoosableInteger = 10, desiredTotal = 11
 * Output: false
 * Explanation:
 * No matter which integer the first player choose, the first player will lose.
 * The first player can choose an integer from 1 up to 10.
 * If the first player choose 1, the second player can only choose integers from 2 up to 10.
 * The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
 * Same with other integers chosen by the first player, the second player will always win.
 * Example 2:
 * <p>
 * Input: maxChoosableInteger = 10, desiredTotal = 0
 * Output: true
 * Example 3:
 * <p>
 * Input: maxChoosableInteger = 10, desiredTotal = 1
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= maxChoosableInteger <= 20
 * 0 <= desiredTotal <= 300
 */
public class LC464 {
    /*
    Here we are using Cache, but you can remove it to understand solution properly.
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        HashMap<String, Boolean> cache = new HashMap<>();
        return canIWin(maxChoosableInteger, desiredTotal, Lists.newArrayList(), cache);
    }

    private boolean canIWin(int maxChoosableInteger, int desiredTotal, List<Integer> isVisited, Map<String, Boolean> cache) {
        if (desiredTotal <= 0) { // It means this person (2nd person) won, It means other person (First person) lost it.
            return false; // Why false (First person lost here), Because we are checking as first person whether or not 2nd person won.
        }
        String key = isVisited.toString(); // We are defining key here, not in below for loop
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // Here Assume both players play optimally. It means player will try to reach or exceed desiredTotal as soon as possible.
        // Due to this we will start with maxChoosableInteger
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (!isVisited.contains((Integer) i)) {
                isVisited.add((Integer) i);
                // Check other person lost the game or not
                if (!canIWin(maxChoosableInteger, desiredTotal - i, isVisited, cache)) {
                    isVisited.remove((Integer) i); // IMP Step
                    cache.put(key, true); // Key depends on initial isVisited array not updated one
                    return true;
                }
                isVisited.remove((Integer) i);
            }
        }
        cache.put(key, false);
        return false;
    }


}
