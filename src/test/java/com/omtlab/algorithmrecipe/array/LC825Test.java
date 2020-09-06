package com.omtlab.algorithmrecipe.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

public class LC825Test {

    LC825 lc825 = new LC825();

    public static Stream<Arguments> testData() {
        return Stream.of(
                of(IntStream.of(16, 16).toArray(), 2),
                of(IntStream.of(16, 17, 18).toArray(), 2),
                of(IntStream.of(20, 30, 100, 110, 120).toArray(), 3)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void numFriendRequests(int[] ages, int expectedOutput) {
        Assertions.assertEquals(expectedOutput, lc825.numFriendRequests(ages));
    }
}