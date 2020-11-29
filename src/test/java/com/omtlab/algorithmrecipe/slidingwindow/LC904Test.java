package com.omtlab.algorithmrecipe.slidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LC904Test {

    public static Stream<Arguments> testData() {
        return Stream.of(
                arguments(IntStream.of(1, 2, 1).toArray(), 3),
                arguments(IntStream.of(0, 1, 2, 2).toArray(), 3),
                arguments(IntStream.of(1, 2, 3, 2, 2).toArray(), 4),
                arguments(IntStream.of(3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4).toArray(), 5)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void totalFruit(int input[], int expected) {
        Assertions.assertEquals(expected, new LC904().totalFruit(input));
    }
}