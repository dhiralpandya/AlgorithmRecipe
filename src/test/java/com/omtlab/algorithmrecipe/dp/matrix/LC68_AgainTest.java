package com.omtlab.algorithmrecipe.dp.matrix;

import com.omtlab.algorithmrecipe.math.LC68_Again;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LC68_AgainTest {

    public static Stream<Arguments> data() {
        String[] input1 = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] input2 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        String[] input3 = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        return Stream.of(arguments(input1, 16),
                arguments(input2, 16),
                arguments(input3, 20)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void fullJustify(String[] words, int maxWidth) {
        LC68_Again lc68_again = new LC68_Again();
        lc68_again.fullJustify(words, maxWidth).forEach(System.out::println);
    }
}