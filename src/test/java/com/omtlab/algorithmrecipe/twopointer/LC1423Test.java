package com.omtlab.algorithmrecipe.twopointer;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;


public class LC1423Test {

    LC1423 lc1423 = new LC1423();

    public static Stream<Arguments> data() {
        return Stream.of(
                arguments(IntStream.of(1, 2, 3, 4, 5, 6, 1).toArray(), 3, 12),
                arguments(IntStream.of(2, 2, 2).toArray(), 2, 4),
                arguments(IntStream.of(9, 7, 7, 9, 7, 7, 9).toArray(), 7, 55),
                arguments(IntStream.of(1, 1000, 1).toArray(), 1, 1),
                arguments(IntStream.of(1, 79, 80, 1, 1, 1, 200, 1).toArray(), 3, 202)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void maxScore(int input[], int k, int expected) {
        Assert.assertEquals(expected, lc1423.maxScore(input, k));
    }
}