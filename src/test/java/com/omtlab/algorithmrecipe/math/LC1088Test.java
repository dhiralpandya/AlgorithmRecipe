package com.omtlab.algorithmrecipe.math;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class LC1088Test {

    @Test
    public void confusingNumberII() {
        Assertions.assertEquals(6, new LC1088().confusingNumberII(20));
        Assertions.assertEquals(19, new LC1088().confusingNumberII(100));
    }
}