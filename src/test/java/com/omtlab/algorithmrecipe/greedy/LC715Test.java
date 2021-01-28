package com.omtlab.algorithmrecipe.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LC715Test {

    @Test
    void testModule() {
        LC715 lc715 = new LC715();
        lc715.addRange(10, 20);
        lc715.removeRange(14, 16);
        Assertions.assertTrue(lc715.queryRange(10, 14));
        Assertions.assertFalse(lc715.queryRange(13, 15));
        Assertions.assertTrue(lc715.queryRange(16, 17));
    }
}