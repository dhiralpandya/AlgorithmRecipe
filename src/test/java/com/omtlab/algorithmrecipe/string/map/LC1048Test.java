package com.omtlab.algorithmrecipe.string.map;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LC1048Test {

    @Test
    public void longestStrChain() {
        String[] input1 = {"a", "b", "ba", "bca", "bda", "bdca"};
        String[] input2 = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        String[] input3 = {"abcd", "dbqca"};

        Assertions.assertThat(new LC1048().longestStrChain(input1)).isEqualTo(4);
        Assertions.assertThat(new LC1048().longestStrChain(input2)).isEqualTo(5);
        Assertions.assertThat(new LC1048().longestStrChain(input3)).isEqualTo(1);
    }
}