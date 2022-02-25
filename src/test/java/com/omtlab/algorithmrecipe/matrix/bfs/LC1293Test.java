package com.omtlab.algorithmrecipe.matrix.bfs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LC1293Test {

    @org.junit.jupiter.api.Test
    void shortestPathOne() {
        int[][] input1 = {{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}};
        int actual = new LC1293WrongSolution().shortestPath(input1, 1);
        Assertions.assertThat(actual).isEqualTo(6);
    }

    @Test
    void shortestPathTwo() {
        int[][] input1 = {{0, 1, 1}, {1, 1, 1}, {1, 0, 0}};
        int actual = new LC1293WrongSolution().shortestPath(input1, 1);
        Assertions.assertThat(actual).isEqualTo(-1);
    }
}