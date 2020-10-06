package com.omtlab.algorithmrecipe.dp.singlearray;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LC198Test {

    com.omtlab.algorithmrecipe.dp.singlearray.LC198 lc198 = new LC198();

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(IntStream.of(2, 7, 9, 3, 1).toArray(), 12),
                Arguments.of(IntStream.of(1, 2, 3, 1).toArray(), 4)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void rob(int[] nums, int expected) {
        Assert.assertEquals(expected, lc198.rob(nums));
    }
}