package com.omtlab.algorithmrecipe.matrix.bfs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LC419Test {

    public static Stream<Arguments> data() {
        String[][] input1 = {
                {"X", ".", ".", "X"},
                {".", ".", ".", "X"},
                {".", ".", ".", "X"}
        };

        String[][] input2 = {
                {"X", "X", "X", "."},
                {"X", "X", ".", "."},
                {"X", "X", ".", "."}
        };


        return Stream.of(
                arguments(input1, 2),
                arguments(input2, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void findNumberOfBattleships(String[][] input, int expected) {
        int actual = new LC419().findNumberOfBattleships(input);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}