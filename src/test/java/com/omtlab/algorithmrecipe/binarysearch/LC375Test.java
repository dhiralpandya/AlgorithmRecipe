package com.omtlab.algorithmrecipe.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LC375Test {

    public static Stream<Arguments> data() {
        return Stream.of(
                arguments(10, 16),
                arguments(1, 0),
                arguments(2, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void getMoneyAmount(int input, int expected) {
        assertEquals(expected, new LC375().getMoneyAmount(input));
    }
}