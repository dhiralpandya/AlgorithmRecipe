package com.omtlab.algorithmrecipe.slidingwindow;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.stream.IntStream.of;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LC992Test {

    LC992 lc992 = new LC992();

    public static Stream<Arguments> data() {
        return Stream.of(
                arguments(of(1, 2, 1, 2, 3).toArray(), 2, 7),
                arguments(of(1, 2, 1, 3, 4).toArray(), 3, 3)

        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void subarraysWithKDistinct(int[] nums, int k, int output) {
        Assert.assertEquals(output, lc992.subarraysWithKDistinct(nums, k));
    }
}