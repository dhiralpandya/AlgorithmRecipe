package com.omtlab.algorithmrecipe.recursion;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC494Test {

    @Test
    public void findTargetSumWaysRecursion() {
        int[] a = {1,1,1,1,1};
        int sum = 3;

        Assert.assertEquals(5,new LC494().findTargetSumWaysRecursion(a,sum));
    }

    @Test
    public void findTargetSumWaysRecursionCache() {
        int[] a = {1,1,1,1,1};
        int sum = 3;

        Assert.assertEquals(5,new LC494().findTargetSumWaysRecursionCache(a,sum));
    }
}