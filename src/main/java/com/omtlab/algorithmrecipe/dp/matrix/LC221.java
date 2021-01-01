package com.omtlab.algorithmrecipe.dp.matrix;

/**
 * 221. Maximal Square
 * <p>
 * <p>
 * Video : https://www.youtube.com/watch?v=_Lf1looyJMU
 * <p>
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * Output: 4
 */
public class LC221 {

    /**
     * Very simple problem
     * Just fine min of all three neighbours + 1
     */
    public int maximalSquare(char[][] matrix) {


        int max = 0;

        //Just skip first row and column;
        for (int row = 1; row < matrix.length; row++) {
            for (int column = 1; column < matrix[row].length; column++) {
                if (matrix[row][column] == '0') {
                    continue;
                }
                // if current cell is non zero it means we will get at least 1 square.
                // Example
                // 0 0
                // 0 1
                // here we get at least 1 square.
                int value = 1 + Character.getNumericValue(Math.min(matrix[row - 1][column - 1], Math.min(matrix[row - 1][column], matrix[row][column - 1])));
                max = Math.max(max, value);
                matrix[row][column] = (char) ('0' + value);
            }
        }

        return max * max;
    }

}
