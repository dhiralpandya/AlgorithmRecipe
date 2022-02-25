package com.omtlab.algorithmrecipe.design.using.map;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class LC1146StringKeyTest {

    @Test
    public void snapshotTest() {
        LC1146StringKey lc1146 = new LC1146StringKey(5);
        lc1146.set(0, 5);
        int snapId = lc1146.snap();
        Assertions.assertEquals(0, snapId);
        lc1146.set(0, 7);
        Assertions.assertEquals(5, lc1146.get(0, snapId));
        snapId = lc1146.snap();
        Assertions.assertEquals(1, snapId);
        Assertions.assertEquals(7, lc1146.get(0, snapId));


    }
}