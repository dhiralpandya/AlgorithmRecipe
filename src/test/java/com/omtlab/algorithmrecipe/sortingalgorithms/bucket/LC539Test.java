package com.omtlab.algorithmrecipe.sortingalgorithms.bucket;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class LC539Test {

    @Test
    public void findMinDifference() {
        String[] input1 = {"23:59", "00:00"};
        String[] input2 = {"00:00", "23:59", "00:00"};
        LC539 lc539 = new LC539();
        assertThat(lc539.findMinDifference(asList(input1)))
                .isEqualTo(1);
        assertThat(lc539.findMinDifference(asList(input2))).
                isEqualTo(0);
    }
}