package com.omtlab.algorithmrecipe.matrix;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LC2128Test {

    @Test
    public void removeOnes() {
        int[][] input1 = {{0, 1, 0}, {1, 0, 1}, {0, 1, 0}};
        Assertions.assertThat(new LC2128().removeOnes(input1)).isTrue();

        int[][] input2 = {{0}};
        Assertions.assertThat(new LC2128().removeOnes(input2)).isTrue();

        int[][] input3 = {{1, 1, 0}, {0, 0, 0}, {0, 0, 0}};
        Assertions.assertThat(new LC2128().removeOnes(input3)).isFalse();


        int[][] input4 = {{1, 1, 0}, {0, 0, 0}, {0, 0, 1}};
        Assertions.assertThat(new LC2128().removeOnes(input4)).isFalse();
    }
}