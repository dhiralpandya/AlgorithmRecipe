package com.omtlab.algorithmrecipe.stack;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LC946Test {

    private LC946 lc946 = new LC946();

    public static Stream<Arguments> data() {
        return Stream.of(
          Arguments.of(IntStream.of(1,2,3,4,5).toArray(), IntStream.of(4,5,3,2,1).toArray(), true),
                Arguments.of(IntStream.of(1,2,3,4,5).toArray(), IntStream.of(4,3,5,1,2).toArray(), false)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void validateStackSequences(int[] pushed, int[] popped, boolean expected) {
        Assert.assertEquals(expected, lc946.validateStackSequences(pushed, popped));
    }
}