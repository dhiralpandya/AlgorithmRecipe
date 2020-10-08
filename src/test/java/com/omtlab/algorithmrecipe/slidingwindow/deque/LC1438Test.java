package com.omtlab.algorithmrecipe.slidingwindow.deque;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.stream.IntStream.of;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LC1438Test {
    LC1438 lc1438 = new LC1438();

    public static Stream<Arguments> data() {
        return Stream.of(
                arguments(of(8, 2, 4, 7).toArray(), 4, 2),
                arguments(of(10, 1, 2, 4, 7, 2).toArray(), 5, 4),
                arguments(of(4, 2, 2, 2, 4, 4, 2, 2).toArray(), 0, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void longestSubarray(int[] input, int limit, int expected) {
        assertEquals(expected, lc1438.longestSubarray(input, limit));
    }
}