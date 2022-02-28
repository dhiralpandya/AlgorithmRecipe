package com.omtlab.algorithmrecipe.matrix;

/**
 * 2128. Remove All Ones With Row and Column Flips
 * <p>
 * You are given an m x n binary matrix grid.
 * <p>
 * In one operation, you can choose any row or column and flip each value in that row or column (i.e., changing all 0's to 1's, and all 1's to 0's).
 * <p>
 * Return true if it is possible to remove all 1's from grid using any number of operations or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[0,1,0],[1,0,1],[0,1,0]]
 * Output: true
 * Explanation: One possible way to remove all 1's from grid is to:
 * - Flip the middle row
 * - Flip the middle column
 * Example 2:
 * <p>
 * <p>
 * Input: grid = [[1,1,0],[0,0,0],[0,0,0]]
 * Output: false
 * Explanation: It is impossible to remove all 1's from grid.
 * Example 3:
 * <p>
 * <p>
 * Input: grid = [[0]]
 * Output: true
 * Explanation: There are no 1's in grid.
 */
public class LC2128 {

    /**
     * Explanation - I found hints to be somewhat poorly worded.
     * Here's an explanation of the logic.
     * Let's say there are some number of 1s in the first row.
     * To get to all 0s matrix it is obvious that we must flip those 1s.
     * If we flip the first row itself then any 0 will turn into 1.
     * So instead we flip all the columns that have 1 in the first row. Now if we think a little deeply,
     * we can realize that we can never flip columns again, because if we do, then 0s in first row will turn to 1s again.
     * So our only option is to flip rows now (starting from second row since first row is already all 0s).
     * Now to get all 0s in the final matrix each row ought to have either only 0s or only 1s. If it has only 0s we don't flip it,
     * if it has only 1s then we flip it. If in any row all the elements are not same,
     * it means it is not possible to get all 0s matrix.
     */
    public boolean removeOnes(int[][] input) {
        for (int column = 0; column < input[0].length; column++) {
            if (input[0][column] == 1) {
                flipToZero(column, input);
            }
        }

        for (int row = 1; row < input.length; row++) {
            int firstColumnDigit = input[row][0];
            for (int column = 1; column < input[0].length; column++) {
                if (firstColumnDigit != input[row][column]) {
                    return false;
                }
            }
        }

        return true;
    }


    private void flipToZero(int fixColumn, int[][] input) {
        for (int row = 0; row < input.length; row++) {
            input[row][fixColumn] = 1 - input[row][fixColumn];
        }
    }

}
