package com.omtlab.algorithmrecipe.array.map.count;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LC954Test {

    @Test
    void canReorderDoubled() {
        int[] input1 = {3,1,3,6};
        Assertions.assertThat(new LC954().canReorderDoubled(input1)).isFalse();

        int[] input2 = {2,2,4,4,4,8};
        Assertions.assertThat(new LC954().canReorderDoubled(input2)).isTrue();

        int[] input3 = {2,1,2,6};
        Assertions.assertThat(new LC954().canReorderDoubled(input3)).isFalse();

        int[] input4 = {4,-2,2,-4};
        Assertions.assertThat(new LC954().canReorderDoubled(input4)).isTrue();

    }
}