package com.omtlab.algorithmrecipe.tree.bfs;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC773Test {

    @Test
    public void slidingPuzzle() {
        int[][] board = {{1,2,3},{4,0,5}};
        Assert.assertEquals(1, new LC773().slidingPuzzle(board));

        int[][] board2 = {{1,2,3},{5,4,0}};
        Assert.assertEquals(-1, new LC773().slidingPuzzle(board2));

        int[][] board3 = {{4,1,2},{5,0,3}};
        Assert.assertEquals(5, new LC773().slidingPuzzle(board3));

        int[][] board4 = {{3,2,4},{1,5,0}};
        Assert.assertEquals(14, new LC773().slidingPuzzle(board4));
    }
}