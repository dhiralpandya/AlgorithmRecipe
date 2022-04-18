package com.omtlab.algorithmrecipe.greedy;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LC2158Test {

    @Test
    public void amountPainted() {
        int[][] paint = {{1, 4}, {4, 7}, {5, 8}};
        int[] output = {3, 3, 1};
        assertThat(new LC2158().amountPainted(paint)).isEqualTo(output);
    }

    @Test
    public void amountPainted2() {
        int[][] paint = {{1, 4}, {5, 8}, {4, 7}};
        int[] output = {3, 3, 1};
        assertThat(new LC2158().amountPainted(paint)).isEqualTo(output);
    }

    @Test
    public void amountPainted3() {
        int[][] paint = {{1, 5}, {2, 4}};
        int[] output = {4, 0};
        assertThat(new LC2158().amountPainted(paint)).isEqualTo(output);
    }
}