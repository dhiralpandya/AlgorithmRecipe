package com.omtlab.algorithmrecipe.matrix.dfs;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LC1706Test {

    @Test
    public void findBall() {
        int[][] input = {{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}};
        int[] expected = {1, -1, -1, -1, -1};
        assertThat(new LC1706().findBall(input)).isEqualTo(expected);
    }

    @Test
    public void findBall2() {
        int[][] input = {{-1}};
        int[] expected = {-1};
        assertThat(new LC1706().findBall(input)).isEqualTo(expected);
    }

    @Test
    public void findBall3() {
        int[][] input = {{1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}};
        int[] expected = {0, 1, 2, 3, 4, -1};
        assertThat(new LC1706().findBall(input)).isEqualTo(expected);
    }
}