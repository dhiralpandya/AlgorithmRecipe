package com.omtlab.algorithmrecipe.slidingwindow.deque;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.stream.IntStream.of;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LC239Test {

    LC239 lc239 = new LC239();

    public static Stream<Arguments> data() {
        return Stream.of(
                arguments(of(1, 3, -1, -3, 5, 3, 6, 7).toArray(), 3, of(3, 3, 5, 5, 6, 7).toArray()),
                arguments(of(1).toArray(), 1, of(1).toArray()),
                arguments(of(1, -1).toArray(), 1, of(1, -1).toArray()),
                arguments(of(9, 11).toArray(), 2, of(11).toArray()),
                arguments(of(4, -2).toArray(), 2, of(4).toArray())
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void maxSlidingWindow(int[] input, int k, int[] expected) {
        assertThat(lc239.maxSlidingWindow(input, k), is(expected));
    }
}