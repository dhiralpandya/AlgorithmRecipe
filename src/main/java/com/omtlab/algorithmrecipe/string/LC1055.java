package com.omtlab.algorithmrecipe.string;

/**
 * 1055. Shortest Way to Form String
 * <p>
 * From any string, we can form a subsequence of that string by deleting some number of characters
 * (possibly no deletions).
 * <p>
 * Given two strings source and target,
 * return the minimum number of subsequences of source such that their concatenation equals target.
 * If the task is impossible, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: source = "abc", target = "abcbc"
 * Output: 2
 * Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".
 * Example 2:
 * <p>
 * Input: source = "abc", target = "acdbc"
 * Output: -1
 * Explanation: The target string cannot be constructed from the subsequences of source string due to the character "d" in target string.
 * Example 3:
 * <p>
 * Input: source = "xyz", target = "xzyxz"
 * Output: 3
 * Explanation: The target string can be constructed as follows "xz" + "y" + "xz".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * Both the source and target strings consist of only lowercase English letters from "a"-"z".
 * The lengths of source and target string are between 1 and 1000.
 */
public class LC1055 {

    /*
    First of all What is subsequence ??????
        In mathematics, a subsequence is a sequence that can be derived
        from another sequence by deleting some or no elements
        without changing the order of the remaining elements.


        Check video : https://www.youtube.com/watch?v=evesA3gr9BE
     */

    public int shortestWay(String source, String target) {
        int minNumberOfSequence = 0;
        String remaining = target;

        while (remaining.length() > 0) {
            int j = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < source.length() && j < remaining.length(); i++) {
                if (source.charAt(i) == remaining.charAt(j)) {
                    sb.append(source.charAt(i));
                    j++;
                }
            }


            if (sb.length() == 0) {
                return -1;
            }

            remaining = remaining.substring(sb.length());
            minNumberOfSequence++;
        }


        return minNumberOfSequence;
    }

}
