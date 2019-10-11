package com.omtlab.algorithmrecipe.twopointer;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC209Test {

    @Test
    public void minSubArrayLen() {
        int[] a = {2,3,1,2,4,3};
        Assert.assertEquals(2, new LC209().minSubArrayLen(7,a));
    }
}