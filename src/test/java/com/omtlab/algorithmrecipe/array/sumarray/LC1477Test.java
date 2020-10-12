package com.omtlab.algorithmrecipe.array.sumarray;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LC1477Test {
    LC1477 lc1477 = new LC1477();

    public static Stream<Arguments> data() {
        return Stream.of(
                arguments(IntStream.of(3, 2, 2, 4, 3).toArray(), 3, 2),
                arguments(IntStream.of(7, 3, 4, 7).toArray(), 7, 2),
                arguments(IntStream.of(4, 3, 2, 6, 2, 3, 4).toArray(), 6, -1),
                arguments(IntStream.of(5, 5, 4, 4, 5).toArray(), 3, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void minSumOfLengths(int[] input, int target, int expected) {
        Assert.assertEquals(expected, lc1477.minSumOfLengths(input, target));
    }
}