package com.omtlab.algorithmrecipe.dp.singlearray;

import org.junit.Assert;
import org.junit.Test;

public class LC91Test {

    
    private LC91 lc91 = new LC91();
    @Test
    public void numDecodings() {
        Assert.assertEquals(1,lc91.numDecodings("8888"));
        Assert.assertEquals(0,lc91.numDecodings("100"));
        Assert.assertEquals(1,lc91.numDecodings("10"));
        Assert.assertEquals(0,lc91.numDecodings("1001"));
        Assert.assertEquals(5,lc91.numDecodings("2223"));
    }

    @Test
    public void getTotalDecodNumbers() {
        Assert.assertEquals(1,lc91.getTotalDecodNumbers("8888"));
        Assert.assertEquals(0,lc91.getTotalDecodNumbers("100"));
        Assert.assertEquals(1,lc91.getTotalDecodNumbers("10"));
        Assert.assertEquals(0,lc91.getTotalDecodNumbers("1001"));
        Assert.assertEquals(5,lc91.getTotalDecodNumbers("2223"));
    }
}