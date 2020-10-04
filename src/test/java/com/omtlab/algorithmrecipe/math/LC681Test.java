package com.omtlab.algorithmrecipe.math;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC681Test {

    private LC681 lc681 = new LC681();

    @Test
    void nextClosestTime() {
        Assert.assertEquals("19:39", lc681.nextClosestTime("19:34"));
        Assert.assertEquals("22:22", lc681.nextClosestTime("23:59"));
    }
}