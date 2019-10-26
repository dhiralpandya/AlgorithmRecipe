package com.omtlab.algorithmrecipe.dp.singlearray.startwithzero;

import org.junit.Assert;
import org.junit.Test;

public class LC639Test {

    LC639 lc639 = new LC639();
    @Test
    public void numDecodings() {
        Assert.assertEquals(18,lc639.numDecodings("1*"));
        Assert.assertEquals(3,lc639.numDecodings("123"));
        Assert.assertEquals(11,lc639.numDecodings("*1"));
        Assert.assertEquals(10,lc639.numDecodings("*7"));
    }
}