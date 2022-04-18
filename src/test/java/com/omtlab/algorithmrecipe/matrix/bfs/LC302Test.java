package com.omtlab.algorithmrecipe.matrix.bfs;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LC302Test {

    @Test
    public void minArea() {
        int input[][] = {{0, 0, 1, 0}, {0, 1, 1, 0}, {0, 1, 0, 0}};
        assertThat(6).isEqualTo(new LC302().minArea(input, 0, 2));
    }

    @Test
    public void minArea2() {
        int input[][] = {{1}};
        assertThat(1).isEqualTo(new LC302().minArea(input, 0, 0));
    }
}