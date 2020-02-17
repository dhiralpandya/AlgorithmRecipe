package com.omtlab.algorithmrecipe.bit;

import org.junit.Assert;
import org.junit.Test;

public class LC461Test {

    @Test
    public void fasterHammingDistance() {
        Assert.assertEquals(2,new LC461().fasterHammingDistance(1,4));
    }
    @Test
    public void fasterHammingDistanceUsingLC191() {
        Assert.assertEquals(2,new LC461().fasterHammingDistanceUsingLC191(1,4));
    }

}