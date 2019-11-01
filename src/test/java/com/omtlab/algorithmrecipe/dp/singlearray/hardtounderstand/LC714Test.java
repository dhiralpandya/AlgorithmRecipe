package com.omtlab.algorithmrecipe.dp.singlearray.hardtounderstand;

import org.junit.Assert;
import org.junit.Test;

public class LC714Test {

    @Test
    public void maxProfit() {
        int a[] ={1, 3, 2, 8, 4, 9};
        int fee = 2;

        Assert.assertEquals(8,new LC714().maxProfit(a,fee));
    }
}