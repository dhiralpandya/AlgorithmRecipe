package com.omtlab.algorithmrecipe.dp.matrix.startwithzero;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC322Test {

    @Test
    public void coinChange() {
        int[] a = {1, 2, 5};
        int target = 11;
        Assert.assertEquals(3, new LC322().coinChange(a,target));


        int[] a1 = {5,1,2};
        int target1 = 11;
        Assert.assertEquals(3, new LC322().coinChange(a1,target1));
    }
}