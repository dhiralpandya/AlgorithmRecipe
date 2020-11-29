package com.omtlab.algorithmrecipe.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LC150Test {

    public static Stream<Arguments> testData() {
        String[] input1 = {"2", "1", "+", "3", "*"};
        String[] input2 = {"4", "13", "5", "/", "+"};
        String[] input3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        return Stream.of(
                arguments(input1, 9),
                arguments(input2, 6),
                arguments(input3, 22)
        );
    }


    @ParameterizedTest
    @MethodSource("testData")
    public void evalRPN(String[] input, int expected) {
        Assertions.assertEquals(expected, new LC150().evalRPN(input));
    }
}