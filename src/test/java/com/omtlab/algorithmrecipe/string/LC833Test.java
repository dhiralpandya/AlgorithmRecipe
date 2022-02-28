package com.omtlab.algorithmrecipe.string;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LC833Test {

    @Test
    public void findReplaceString() {
        LC833 lc833 = new LC833();

        String s = "abcd";
        Integer[] indices = {0, 2};
        String[] sources = {"a", "cd"};
        String[] targets = {"eee", "ffff"};
        Assertions.assertThat(lc833.findReplaceString(s, indices, sources, targets))
                .isEqualTo("eeebffff");
    }

    @Test
    public void findReplaceString2() {
        LC833 lc833 = new LC833();

        String s = "abcd";
        Integer[] indices = {0, 2};
        String[] sources = {"ab", "ec"};
        String[] targets = {"eee", "ffff"};
        Assertions.assertThat(lc833.findReplaceString(s, indices, sources, targets))
                .isEqualTo("eeecd");
    }
}