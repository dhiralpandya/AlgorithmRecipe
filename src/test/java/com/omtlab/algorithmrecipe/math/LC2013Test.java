package com.omtlab.algorithmrecipe.math;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LC2013Test {

    @Test
    public void add() {
        LC2013 lc2013 = new LC2013();
        lc2013.add(ary(3, 10));
        lc2013.add(ary(11, 2));
        lc2013.add(ary(3, 2));

        Assertions.assertThat(lc2013.count(ary(11, 10))).isEqualTo(1);

        Assertions.assertThat(lc2013.count(ary(14, 8))).isEqualTo(0);

        lc2013.add(ary(11, 2));
        Assertions.assertThat(lc2013.count(ary(11, 10))).isEqualTo(2);
    }

    private Integer[] ary(Integer x, Integer y) {
        Integer[] output = {x, y};
        return output;
    }
}