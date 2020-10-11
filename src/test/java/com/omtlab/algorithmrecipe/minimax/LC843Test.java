package com.omtlab.algorithmrecipe.minimax;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LC843Test {

    public static Stream<Arguments> data() {
        return Stream.of(
                arguments("One"),
                arguments("One"),
                arguments("One"),
                arguments("One"),
                arguments("One"),
                arguments("One"),
                arguments("One"),
                arguments("One")

        );
    }


    public static String[] wordlist() {

        Set<String> s = Stream.generate(LC843Test::newRandomString)
                .limit(500)
                .collect(Collectors.toSet());
        String[] sarry = new String[s.size()];
        String[] array = s.toArray(sarry);
        return array;
    }

    private static String newRandomString() {
        return RandomStringUtils.randomAlphabetic(6).toLowerCase();
    }

    @ParameterizedTest
    @MethodSource("data")
    public void findSecretWord(String one) {
        String[] wordList = wordlist();
        String secret = wordList[new Random().nextInt(wordList.length)];
        LC843.Master master = new LC843.Master();
        master.secret = secret;
        System.out.println("Secret:" + secret);
        Assertions.assertThrows(LC843.SuccessException.class, () -> {
            new LC843().findSecretWord(wordList, master);
        });
    }
}