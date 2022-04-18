package com.omtlab.algorithmrecipe.matrix.bfs;

/**
 * 302. Smallest Rectangle Enclosing Black Pixels
 * <p>
 * You are given an m x n binary matrix image where 0 represents a white pixel and 1 represents a black pixel.
 * <p>
 * The black pixels are connected (i.e., there is only one black region). Pixels are connected horizontally and vertically.
 * <p>
 * Given two integers x and y that represents the location of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
 * <p>
 * You must write an algorithm with less than O(mn) runtime complexity
 * <p>
 * Input: image = [["0","0","1","0"],["0","1","1","0"],["0","1","0","0"]], x = 0, y = 2
 * Output: 6
 * Example 2:
 * <p>
 * Input: image = [["1"]], x = 0, y = 0
 * Output: 1
 */
public class LC302 {
    int minTop = 0;
    int maxBottom = 0;
    int minLeft = 0;
    int maxRight = 0;

    public int minArea(int[][] image, int row, int column) {
        minTop = row;
        maxBottom = row;
        minLeft = column;
        maxRight = column;

        dfs(image, row, column);

        return (maxBottom - minTop) * (maxRight - minLeft);
    }


    private void dfs(int[][] image, int row, int column) {
        if (!isValid(image, row, column)) {
            return;
        }

        // Set Visited
        image[row][column] = 0;

        minTop = Math.min(minTop, row);
        maxBottom = Math.max(maxBottom, row + 1);
        minLeft = Math.min(minLeft, column);
        maxRight = Math.max(maxRight, column + 1);

        dfs(image, row + 1, column);
        dfs(image, row - 1, column);
        dfs(image, row, column + 1);
        dfs(image, row, column - 1);
    }


    private boolean isValid(int[][] image, int row, int column) {
        if (row < 0
                || column < 0
                || row >= image.length
                || column >= image[0].length
                || image[row][column] == 0) {
            return false;
        }

        return true;
    }

}
