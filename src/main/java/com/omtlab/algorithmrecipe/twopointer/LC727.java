package com.omtlab.algorithmrecipe.twopointer;

/**
 * 727. Minimum Window Subsequence
 * <p>
 * Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
 * <p>
 * If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * S = "abcdebdde", T = "bde"
 * Output: "bcde"
 * Explanation:
 * "bcde" is the answer because it occurs before "bdde" which has the same length.
 * "deb" is not a smaller window because the elements of T in the window must occur in order.
 * <p>
 * <p>
 * Note:
 * <p>
 * All the strings in the input will only contain lowercase letters.
 * The length of S will be in the range [1, 20000].
 * The length of T will be in the range [1, 100].
 */
public class LC727 {

    public String minWindow(String S, String T) {

        int tLength = T.length();
        int sLength = S.length();

        int tPointer = 0;
        int sPointer = 0;

        int minLength = S.length();
        int start = -1;
        while (sPointer < sLength) {
            if (S.charAt(sPointer) == T.charAt(tPointer)) {
                tPointer++;
            }

            if (tPointer == tLength) {
                int tempEnd = sPointer;
                tPointer--;
                while (sPointer >= 0 && tPointer >= 0) {
                    if (S.charAt(sPointer) == T.charAt(tPointer)) {
                        tPointer--;
                    }
                    sPointer--;
                }
                //IMP
                sPointer++;
                tPointer++;
                int newLength = tempEnd - sPointer + 1;
                if (newLength < minLength) {
                    minLength = newLength;
                    start = sPointer;
                }
            }
            // IMP, This will also help to avoid infinite loop
            sPointer++;
        }


        return start == -1 ? "" : S.substring(start, start + minLength);
    }

}
