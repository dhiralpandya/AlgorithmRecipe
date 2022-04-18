package com.omtlab.algorithmrecipe.greedy;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LC1834Test {

    @Test
    public void getOrder() {
        int[][] task1 = {{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        int[] output1 = {0, 2, 3, 1};
        assertThat(new LC1834().getOrder(task1)).isEqualTo(output1);

        int[][] task2 = {{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}};
        int[] output2 = {4, 3, 2, 0, 1};
        assertThat(new LC1834().getOrder(task2)).isEqualTo(output2);
    }
}