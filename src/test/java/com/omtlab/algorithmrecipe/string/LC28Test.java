package com.omtlab.algorithmrecipe.string;

import org.junit.Assert;
import org.junit.Test;

public class LC28Test {
    
    LC28 lc28 = new LC28();

    @Test
    public void strStr() {
        Assert.assertEquals(2, lc28.strStr("hello","ll"));
        Assert.assertEquals(-1, lc28.strStr("aaaaa","bba"));
    }
}