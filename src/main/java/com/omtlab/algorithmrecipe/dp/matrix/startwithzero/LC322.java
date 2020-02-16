package com.omtlab.algorithmrecipe.dp.matrix.startwithzero;

import com.omtlab.algorithmrecipe.common.util.MatrixUtil;

/**
 * 322. Coin Change
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class LC322 {

    public int coinChange(int[] coins, int amount) {
        int[][] matrix = new int[coins.length][amount+1];

        for(int row=0; row < matrix.length; row++) {
            for(int column=1; column < matrix[row].length; column++) {
                boolean isFirstRow = row == 0;
                int number = coins[row];
                if(number > column) {
                    matrix[row][column] = isFirstRow? Integer.MAX_VALUE:matrix[row-1][column];
                    continue;
                }

                int newCount = matrix[row][column-number] == Integer.MAX_VALUE?Integer.MAX_VALUE:matrix[row][column-number]+1;
                int preCount = isFirstRow? Integer.MAX_VALUE:matrix[row-1][column];

                matrix[row][column] = Math.min(newCount, preCount);
            }
        }

        MatrixUtil.printMatrix(matrix);
        return matrix[coins.length-1][amount];
    }

}
