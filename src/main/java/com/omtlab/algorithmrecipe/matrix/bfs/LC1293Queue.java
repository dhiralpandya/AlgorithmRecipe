package com.omtlab.algorithmrecipe.matrix.bfs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * 1293. Shortest Path in a Grid with Obstacles Elimination
 * <p>
 * You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.
 * <p>
 * Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
 * Output: 6
 * Explanation:
 * The shortest path without eliminating any obstacle is 10.
 * The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 * Example 2:
 * <p>
 * <p>
 * Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
 * Output: -1
 * Explanation: We need to eliminate at least two obstacles to find such a walk.
 */
public class LC1293Queue {

    public int shortestPath(int[][] input, int k) {
        boolean visitedNode[][] = new boolean[input.length][input[0].length];
        Optional<GridNode> mayBeNode = executeBFS(input, k, visitedNode,
                GridNode.builder()
                        .currentK(0)
                        .row(0)
                        .column(0)
                        .dist(0)
                        .build());
        return mayBeNode.map(GridNode::getDist).orElse(-1);
    }

    private Optional<GridNode> executeBFS(int[][] input, int k, boolean[][] visitedNodes, GridNode node) {
        Queue<GridNode> bfs = new LinkedList<>();
        bfs.add(node);
        int destinationX = input.length - 1;
        int destinationY = input[0].length - 1;

        while (!bfs.isEmpty()) {
            GridNode nodeFromQueue = bfs.poll();
            if (isValidNode(nodeFromQueue, input, k, visitedNodes)) {
                if (nodeFromQueue.row == destinationX && nodeFromQueue.column == destinationY) {
                    return Optional.of(nodeFromQueue);
                }
                visitedNodes[nodeFromQueue.row][nodeFromQueue.column] = true;
                int nextK = input[nodeFromQueue.row][nodeFromQueue.column] == 1? nodeFromQueue.currentK + 1 : nodeFromQueue.currentK;
                int nextDist = nodeFromQueue.dist+1;
                GridNode up = GridNode.builder()
                        .dist(nextDist)
                        .currentK(nextK)
                        .row(nodeFromQueue.row-1)
                        .column(nodeFromQueue.column)
                        .build();
                GridNode down = GridNode.builder()
                        .dist(nextDist)
                        .currentK(nextK)
                        .row(nodeFromQueue.row+1)
                        .column(nodeFromQueue.column)
                        .build();
                GridNode right = GridNode.builder()
                        .dist(nextDist)
                        .currentK(nextK)
                        .row(nodeFromQueue.row)
                        .column(nodeFromQueue.column+1)
                        .build();
                GridNode left = GridNode.builder()
                        .dist(nextDist)
                        .currentK(nextK)
                        .row(nodeFromQueue.row)
                        .column(nodeFromQueue.column-1)
                        .build();
                bfs.offer(up);
                bfs.offer(down);
                bfs.offer(right);
                bfs.offer(left);
            }
        }

        return Optional.empty();
    }

    private boolean isValidNode(GridNode node, int[][] input, int k, boolean[][] visitedNodes) {
        if (node.row < 0
                || node.column < 0
                || node.currentK > k
                || node.row >= input.length
                || node.column >= input[0].length
                || visitedNodes[node.row][node.column]) {
            return false;
        }

        return true;
    }

    @Data
    @Builder
    private static class GridNode {
        int row;
        int column;
        int currentK;
        int dist;
    }
}
