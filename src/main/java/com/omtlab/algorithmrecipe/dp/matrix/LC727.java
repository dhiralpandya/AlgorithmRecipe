package com.omtlab.algorithmrecipe.dp.matrix;

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
        int[][] matrix = new int[T.length()][S.length()];

        // First row
        for (int column = 0; column < S.length(); column++) {
            if (T.charAt(0) == S.charAt(column)) {
                matrix[0][column] = column;
            } else {
                if (column > 0) {
                    matrix[0][column] = matrix[0][column - 1];
                } else {
                    matrix[0][column] = -1;
                }
            }
        }

        // All the element starting from row 1 depends on row 0 output
        for (int row = 1; row < T.length(); row++) {
            for (int column = 0; column < S.length(); column++) {
                // IMP Step column cannot be less then row,
                if (column < row) {
                    matrix[row][column] = -1;
                    continue;
                }
                if (T.charAt(row) == S.charAt(column)) {
                    matrix[row][column] = matrix[row - 1][column - 1];
                } else {
                    matrix[row][column] = matrix[row][column - 1];
                }
            }
        }

        int start = -1;
        int length = S.length();

        // Last row and all columns
        for (int column = 0; column < S.length(); column++) {
            int newStart = matrix[T.length() - 1][column];
            if (newStart == -1) {
                continue;
            }
            int newLength = column - newStart + 1;
            if (newLength < length) {
                start = newStart;
                length = newLength;
            }
        }

        return start == -1 ? "" : S.substring(start, start + length);
    }
}
