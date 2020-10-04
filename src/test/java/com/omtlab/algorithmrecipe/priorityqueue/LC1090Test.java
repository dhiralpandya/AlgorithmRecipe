package com.omtlab.algorithmrecipe.priorityqueue;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class LC1090Test {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(newArrayList(5,4,3,2,1).toArray(new Integer[0]),
                        newArrayList(1,1,2,2,3).toArray(new Integer[0]), 3, 1, 9),
                Arguments.of(newArrayList(5,4,3,2,1).toArray(new Integer[0]),
                        newArrayList(1,3,3,3,2).toArray(new Integer[0]), 3, 2, 12),
                Arguments.of(newArrayList(9,8,8,7,6).toArray(new Integer[0]),
                        newArrayList(0,0,0,1,1).toArray(new Integer[0]), 3, 1, 16),
                Arguments.of(newArrayList(9,8,8,7,6).toArray(new Integer[0]),
                        newArrayList(0,0,0,1,1).toArray(new Integer[0]), 3, 2, 24)
        );
    }

    LC1090 lc1090 = new LC1090();

    @ParameterizedTest
    @MethodSource("data")
    void largestValsFromLabels(Integer[] values, Integer[] labels, int numWanted, int useLimit, int expectedOutput) {
        Assert.assertEquals(expectedOutput, lc1090.largestValsFromLabels(values, labels, numWanted, useLimit));
    }
}