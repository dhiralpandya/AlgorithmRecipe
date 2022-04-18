package com.omtlab.algorithmrecipe.matrix.bfs;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LC302LevelOrder {

    Map<Integer, Integer> levelAndCount = new HashMap<>();
    int maxCount = 0;

    public int minArea(int[][] image, int row, int column) {
        bfs(image, row, column);
        return maxCount * levelAndCount.size();
    }

    private void bfs(int[][] image, int row, int column) {
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(row, column, 1));

        while (!queue.isEmpty()) {
            Cell c = queue.poll();
            if (!isValid(image, c.row, c.column)) {
                continue;
            }

            // Visited
            image[c.row][c.column] = 0;

            levelAndCount.put(c.level, levelAndCount.getOrDefault(c.level, 0) + 1);
            maxCount = Math.max(maxCount, levelAndCount.get(c.level));

            queue.add(new Cell(c.row, c.column + 1, c.level));
            queue.add(new Cell(c.row, c.column - 1, c.level));
            queue.add(new Cell(c.row + 1, c.column, c.level + 1));
        }
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

    @AllArgsConstructor
    private static class Cell {
        int row;
        int column;
        int level = 0;
    }


}
