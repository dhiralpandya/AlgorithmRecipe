package com.omtlab.algorithmrecipe.priorityqueue;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LC295Test {

    @Test
    public void findMedian() {
        LC295 lc295 = new LC295();
        lc295.addNum(3);
        Assertions.assertThat(lc295.findMedian()).isEqualTo(3.0d);
        lc295.addNum(1);
        lc295.addNum(2);
        Assertions.assertThat(lc295.findMedian()).isEqualTo(2.0d);
        lc295.addNum(17);
        Assertions.assertThat(lc295.findMedian()).isEqualTo(2.5d);
    }
}