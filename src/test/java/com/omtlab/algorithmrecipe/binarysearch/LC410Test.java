package com.omtlab.algorithmrecipe.binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class LC410Test {

    @Test
    public void splitArray() {
        int[] a = {7,2,5,10,8};
        int output = new LC410().splitArray(a,2);
        Assert.assertEquals(18,output);
    }
}