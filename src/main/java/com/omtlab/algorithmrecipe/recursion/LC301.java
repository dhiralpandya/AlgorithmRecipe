package com.omtlab.algorithmrecipe.recursion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 301. Remove Invalid Parentheses
 * <p>
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * <p>
 * Note: The input string may contain letters other than the parentheses ( and ).
 * <p>
 * Example 1:
 * <p>
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * Example 2:
 * <p>
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * Example 3:
 * <p>
 * Input: ")("
 * Output: [""]
 */
public class LC301 {

    /**
     * Key Points:
     * <p>
     * Generate unique answer once and only once, do not rely on Set.
     * Do not need preprocess.
     * <p>
     * Runtime 3 ms.
     * Explanation:
     * <p>
     * We all know how to check a string of parentheses is valid using a stack. Or even simpler use a counter.
     * The counter will increase when it is ‘(‘ and decrease when it is ‘)’. Whenever the counter is negative, we have more ‘)’ than ‘(‘ in the prefix.
     * <p>
     * To make the prefix valid, we need to remove a ‘)’. The problem is: which one? The answer is any one in the prefix. However, if we remove any one, we will generate duplicate results, for example: s = ()), we can remove s[1] or s[2] but the result is the same (). Thus, we restrict ourself to remove the first ) in a series of concecutive )s.
     * <p>
     * After the removal, the prefix is then valid. We then call the function recursively to solve the rest of the string. However, we need to keep another information: the last removal position. If we do not have this position, we will generate duplicate by removing two ‘)’ in two steps only with a different order.
     * For this, we keep tracking the last removal position and only remove ‘)’ after that.
     * <p>
     * Now one may ask. What about ‘(‘? What if s = ‘(()(()’ in which we need remove ‘(‘?
     * The answer is: do the same from right to left.
     * However a cleverer idea is: reverse the string and reuse the code!
     * Here is the final implement in Java.
     */
    public Set<String> removeInvalidParentheses(String s) {
        /**
         * Lets say we have below input
         *
         * Input : (()()
         * Reverse : )()((
         *
         * First we do leftToRight and then rightToLeft
         * - How we make sure that ans we get is by removing min numbers of Parentheses
         *   1. Here we are removing only when we get unstable stack count. It means we are removing from exact position.
         *   2. Once removed, we are starting next iteration from last count "i"
         *
         */
        Set<String> output = new HashSet<>();
        leftToRight(s, output, 0, 0);
        rightToLeft(s, output, s.length()-1, s.length()-1);
        return output;
    }

    public void leftToRight(String s, Set<String> ans, int left, int lastRemoved) {
        int stack = 0;
        for (int i = left; i < s.length(); ++i) {

            if (s.charAt(i) == '(') stack++;
            if (s.charAt(i) == ')') stack--;
            if (stack >= 0) continue; // In leftToRight We are only focusing on removing ')'

            // Is stack < 0 means we found invalid ')'
            for (int j = lastRemoved; j <= i; ++j) {
                int newLastRemoved = j;
                leftToRight(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, newLastRemoved);
            }
        }

        if (isValid(s)) {
            ans.add(s);
        }
    }

    public void rightToLeft(String s, Set<String> ans, int right, int lastRemoved) {
        int stack = 0;
        for (int i = right; i >= 0; i--) {
            if (s.charAt(i) == '(') stack--;
            if (s.charAt(i) == ')') stack++;
            if (stack >= 0) continue; // In rightToleft We are only focusing on removing '('

            // Is stack < 0 means we found invalid ')'
            for (int j = lastRemoved; j >= i; j--) {
                int newLastRemoved = j;
                leftToRight(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, newLastRemoved);
            }
        }

        if (isValid(s)) {
            ans.add(s);
        }
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()) {
            if(c == '(') {
                stack.push('(');
            } if(c == ')') {
                if(stack.isEmpty() || stack.peek() ==')') {
                    return false;
                }
                stack.pop();
            }
        }

        return  stack.isEmpty();
    }
}

