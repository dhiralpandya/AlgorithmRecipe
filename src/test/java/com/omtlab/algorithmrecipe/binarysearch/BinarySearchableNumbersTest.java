package com.omtlab.algorithmrecipe.binarysearch;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchableNumbersTest {

    @Test
    public void getBinarySearchableNumbers() {
        BinarySearchableNumbers algo = new BinarySearchableNumbers();

        assertThat(algo.getBinarySearchableNumbers(asList(1, 3, 2))).isEqualTo(asList(1));
        assertThat(algo.getBinarySearchableNumbers(asList(2, 1, 3, 5, 4, 6))).isEqualTo(asList(3, 6));
        assertThat(algo.getBinarySearchableNumbers(asList(1, 5, 7, 11, 12, 18))).isEqualTo(asList(1, 5, 7, 11, 12, 18));
        assertThat(algo.getBinarySearchableNumbers(asList(3, 2, 1))).isEqualTo(asList());
        assertThat(algo.getBinarySearchableNumbers(asList(1, 3, 2, 4, 5, 7, 6, 8))).isEqualTo(asList(1, 4, 5, 8));
    }
}