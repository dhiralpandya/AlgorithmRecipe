package com.omtlab.algorithmrecipe.math;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC166Test {

    LC166 lc166 = new LC166();
    
    @Test
    public void fractionToDecimal() {
        Assert.assertEquals("0.5",lc166.fractionToDecimal(1,2));
        Assert.assertEquals("2",lc166.fractionToDecimal(2,1));
        Assert.assertEquals("0.(6)",lc166.fractionToDecimal(2,3));
        Assert.assertEquals("0.(012)",lc166.fractionToDecimal(4,333));
        Assert.assertEquals("0.(210526315789473684)",lc166.fractionToDecimal(4,19));
    }
}