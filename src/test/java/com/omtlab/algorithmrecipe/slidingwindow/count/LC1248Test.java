package com.omtlab.algorithmrecipe.slidingwindow.count;

import com.omtlab.algorithmrecipe.slidingwindow.LC1248;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.stream.IntStream.of;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LC1248Test {

    LC1248 lc1248 = new LC1248();

    public static Stream<Arguments> data() {
        return Stream.of(
                arguments(of(1, 1, 2, 1, 1).toArray(), 3, 2),
                arguments(of(2, 4, 6).toArray(), 1, 0),
                arguments(of(2, 2, 2, 1, 2, 2, 1, 2, 2, 2).toArray(), 2, 16)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void numberOfSubarrays(int[] input, int k, int expected) {
        Assert.assertEquals(expected, lc1248.numberOfSubarrays(input, k));
    }
}