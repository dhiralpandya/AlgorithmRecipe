package com.omtlab.algorithmrecipe.string;

/**
 * 294. Flip Game II
 * You are playing a Flip Game with your friend.
 * <p>
 * You are given a string currentState that contains only '+' and '-'.
 * You and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move, and therefore the other person will be the winner.
 * <p>
 * Return true if the starting player can guarantee a win, and false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: currentState = "++++"
 * Output: true
 * Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 * Example 2:
 * <p>
 * Input: currentState = "+"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= currentState.length <= 60
 * currentState[i] is either '+' or '-'
 */
public class LC294 {
    public boolean isFirstPersonGoingToWin(String input) {
        if (input == null || input.length() < 2) {
            return false;
        }

        if (input.length() == 2) {
            if (input.charAt(0) == '+' && input.charAt(1) == '+') {
                return true;
            } else {
                return false;
            }
        }

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == '+' && input.charAt(i + 1) == '+') {
                String newInput = input.substring(0, i) + "--" + input.substring(i + 2);
                if (!isFirstPersonGoingToWin(newInput)) {
                    return true;
                }
            }
        }

        return false;
    }
}
