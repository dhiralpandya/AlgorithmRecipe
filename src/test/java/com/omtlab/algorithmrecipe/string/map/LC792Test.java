package com.omtlab.algorithmrecipe.string.map;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LC792Test {

    @Test
    public void numMatchingSubseqBruteForce_1() {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        Assertions.assertThat(new LC792().numMatchingSubseq_BruteForce(s, words)).isEqualTo(3);
    }

    @Test
    public void numMatchingSubseqBruteForce_2() {
        String s = "dsahjpjauf";
        String[] words = {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
        Assertions.assertThat(new LC792().numMatchingSubseq_BruteForce(s, words)).isEqualTo(2);
    }

    @Test
    public void numMatchingSubseq_Ideal_1() {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        Assertions.assertThat(new LC792().numMatchingSubseq_Ideal(s, words)).isEqualTo(3);
    }

    @Test
    public void numMatchingSubseq_Ideal_2() {
        String s = "dsahjpjauf";
        String[] words = {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
        Assertions.assertThat(new LC792().numMatchingSubseq_Ideal(s, words)).isEqualTo(2);
    }
}