package com.omtlab.algorithmrecipe.bit;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LC540Test {

    @Test
    public void singleNonDuplicate() {
        int[] input = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int actual = new LC540().singleNonDuplicate(input);
        Assertions.assertThat(actual).isEqualTo(2);

        int[] input2 = {3, 3, 7, 7, 10, 11, 11};
        int actual2 = new LC540().singleNonDuplicate(input2);
        Assertions.assertThat(actual2).isEqualTo(10);
    }
}