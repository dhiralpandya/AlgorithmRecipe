package com.omtlab.algorithmrecipe.matrix.bfs;

/**
 * 1293. Shortest Path in a Grid with Obstacles Elimination
 * <p>
 * You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.
 * <p>
 * Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.
 * <p>
 * Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
 * Output: 6
 * Explanation:
 * The shortest path without eliminating any obstacle is 10.
 * The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 * <p>
 * Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
 * Output: -1
 * Explanation: We need to eliminate at least two obstacles to find such a walk.
 */
public class LC1293WrongSolution {
    /**
     * NOTE: This is not correct solution because it is not using BFS,
     * It is using DFS and it may not produce correct shortest path solution.
     * <p>
     * PLease check LC1293Queue.java
     */
    public int shortestPath(int[][] input, int k) {
        boolean[][] visitedNodes = new boolean[input.length][input[0].length];
        GridNode gridNode = new GridNode();
        gridNode.column = 0;
        gridNode.row = 0;
        gridNode.dist = 0;
        gridNode.currentK = 0;

        GridNode result = executeBFS(input, k, visitedNodes, gridNode);
        return result == null ? -1 : result.dist;
    }

    private GridNode executeBFS(int[][] input, int k, boolean[][] visitedNodes, GridNode node) {
        int destinationRow = input.length - 1;
        int destinationColumn = input[0].length - 1;
        if (!isValidGridNode(input, k, visitedNodes, node)) {
            return null;
        }
        if (node.row == destinationRow
                && node.column == destinationColumn
                && node.currentK <= k) {
            return node;
        }

        visitedNodes[node.row][node.column] = true;
        int nextK = input[node.row][node.column] == 1 ? node.currentK + 1 : node.currentK;

        GridNode up = new GridNode();
        up.row = node.row - 1;
        up.column = node.column;
        up.currentK = nextK;
        up.dist = node.dist + 1;

        GridNode down = new GridNode();
        down.row = node.row + 1;
        down.column = node.column;
        down.currentK = nextK;
        down.dist = node.dist + 1;

        GridNode left = new GridNode();
        left.row = node.row;
        left.column = node.column - 1;
        left.currentK = nextK;
        left.dist = node.dist + 1;

        GridNode right = new GridNode();
        right.row = node.row;
        right.column = node.column + 1;
        right.currentK = nextK;
        right.dist = node.dist + 1;


        GridNode upResult = executeBFS(input, k, visitedNodes, up);
        if (upResult != null) {
            return upResult;
        }

        GridNode downResult = executeBFS(input, k, visitedNodes, down);
        if (downResult != null) {
            return downResult;
        }

        GridNode leftResult = executeBFS(input, k, visitedNodes, left);
        if (leftResult != null) {
            return leftResult;
        }

        return executeBFS(input, k, visitedNodes, right);
    }

    private boolean isValidGridNode(int[][] input, int k, boolean[][] visitedNodes, GridNode node) {
        if (node.row >= input.length
                || node.column >= input[0].length
                || node.row < 0
                || node.column < 0
                || node.currentK >= k
                || visitedNodes[node.row][node.column]) {
            return false;
        }

        return true;
    }


    private static class GridNode {
        int row;
        int column;
        int dist = 0;
        int currentK;
    }
}
