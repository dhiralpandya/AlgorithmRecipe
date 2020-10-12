package com.omtlab.algorithmrecipe.backtracking;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LC464Test {

    LC464 lc464 = new LC464();

    public static Stream<Arguments> data() {
        return Stream.of(
                arguments(10, 11, false),
                arguments(5, 11, false),
                arguments(10, 1, true)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void canIWin(int maxChoosableInteger, int desiredTotal, boolean expected) {
        assertEquals(expected, lc464.canIWin(maxChoosableInteger, desiredTotal));
    }
}