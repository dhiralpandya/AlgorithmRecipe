package com.omtlab.algorithmrecipe.binarysearch;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC50Test {

    LC50 lc50 = new LC50();
    
    @Test
    public void myPow() {
        Assert.assertEquals(16.0d,lc50.myPow(2,4),0);
        Assert.assertEquals(32.0d,lc50.myPow(2,5),0);
        Assert.assertEquals(1024.0d,lc50.myPow(2,10),0);
    }
}