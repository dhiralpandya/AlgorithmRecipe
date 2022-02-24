package com.omtlab.algorithmrecipe.matrix.bfs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC1293QueueTest {

    @Test
    void shortestPathOne() {
        int[][] input1 = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
        int actual = new LC1293Queue().shortestPath(input1, 1);
        Assertions.assertThat(actual).isEqualTo(6);
    }

    @Test
    void shortestPathTwo() {
        int[][] input1 = {{0,1,1},{1,1,1},{1,0,0}};
        int actual = new LC1293Queue().shortestPath(input1, 1);
        Assertions.assertThat(actual).isEqualTo(-1);
    }
}