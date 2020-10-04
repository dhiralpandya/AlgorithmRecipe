package com.omtlab.algorithmrecipe.math;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC204Test {

    @Test
    void countPrimes() {
        Assert.assertEquals(4, new LC204().countPrimes(10));
        Assert.assertEquals(0, new LC204().countPrimes(0));
        Assert.assertEquals(0, new LC204().countPrimes(1));
        Assert.assertEquals(5, new LC204().countPrimes(12));
    }
}