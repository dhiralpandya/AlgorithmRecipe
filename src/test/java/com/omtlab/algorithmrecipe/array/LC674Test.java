package com.omtlab.algorithmrecipe.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC674Test {

    @Test
    public void findLengthOfLCIS() {
        int a[] ={1,3,5,4,7};
        Assert.assertEquals(3, new LC674().findLengthOfLCIS(a));

        int b[] ={2,2,2,2,2};
        Assert.assertEquals(1, new LC674().findLengthOfLCIS(b));
    }
}