package com.omtlab.algorithmrecipe.tree.inorder;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LC1376Test {

    LC1376 lc1376 = new LC1376();

    public static Stream<Arguments> data() {
        return Stream.of(
                arguments(1, 0, IntStream.of(-1).toArray(), IntStream.of(0).toArray(), 0),
                arguments(6, 2, IntStream.of(2, 2, -1, 2, 2, 2).toArray(), IntStream.of(0, 0, 1, 0, 0, 0).toArray(), 1),
                arguments(7, 6, IntStream.of(1, 2, 3, 4, 5, 6, -1).toArray(), IntStream.of(0, 6, 5, 4, 3, 2, 1).toArray(), 21),
                arguments(15, 0, IntStream.of(-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6).toArray(), IntStream.of(1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0).toArray(), 3),
                arguments(4, 2, IntStream.of(3, 3, -1, 2).toArray(), IntStream.of(0, 0, 162, 914).toArray(), 1076)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void numOfMinutes(int n, int headId, int[] manager, int[] informTime, int expected) {
        Assert.assertEquals(expected, lc1376.numOfMinutes(n, headId, manager, informTime));
    }
}