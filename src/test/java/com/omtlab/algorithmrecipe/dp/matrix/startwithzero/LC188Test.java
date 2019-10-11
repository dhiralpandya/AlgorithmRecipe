package com.omtlab.algorithmrecipe.dp.matrix.startwithzero;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC188Test {

    @Test
    public void maxProfit() {
        LC188 lc188 = new LC188();
        int[] a = {2,4,1};
        int[] b ={3,2,6,5,0,3};
        int[] c ={2,5,7,1,4,3,1,3};
        Assert.assertEquals(2,lc188.maxProfit(2,a));
        Assert.assertEquals(10,lc188.maxProfit(3,c));
        Assert.assertEquals(7,lc188.maxProfit(2,b));
    }
}