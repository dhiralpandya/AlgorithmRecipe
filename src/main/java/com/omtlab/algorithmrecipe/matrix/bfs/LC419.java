package com.omtlab.algorithmrecipe.matrix.bfs;

/**
 * 419. Battleships in a Board
 * <p>
 * Given an m x n matrix board where each cell is a battleship 'X' or empty '.', return the number of the battleships on board.
 * <p>
 * Battleships can only be placed horizontally or vertically on board.
 * In other words, they can only be made of the shape 1 x k (1 row, k columns) or k x 1 (k rows, 1 column),
 * where k can be of any size.
 * At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
 * Output: 2
 * Example 2:
 * <p>
 * Input: board = [["."]]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is either '.' or 'X'.
 * <p>
 * <p>
 * Follow up: Could you do it in one-pass,
 * using only O(1) extra memory and without modifying the values board?
 */
public class LC419 {
    public int findNumberOfBattleships(String[][] input) {
        int foundBattleShips = 0;
        for (int row = 0; row < input.length; row++) {
            for (int column = 0; column < input[row].length; column++) {
                if (input[row][column].equals("X")) {
                    foundBattleShips++;
                    changeAllConnectedXToDot(row, column, input);
                }
            }
        }
        return foundBattleShips;
    }

    private void changeAllConnectedXToDot(int row, int column, String[][] input) {
        if (row < 0
                || column < 0
                || row > input.length - 1
                || column > input[0].length - 1
                || input[row][column].equals(".")) {
            return;
        }

        input[row][column] = ".";
        changeAllConnectedXToDot(row - 1, column, input);
        changeAllConnectedXToDot(row + 1, column, input);
        changeAllConnectedXToDot(row, column - 1, input);
        changeAllConnectedXToDot(row, column + 1, input);
    }

}
