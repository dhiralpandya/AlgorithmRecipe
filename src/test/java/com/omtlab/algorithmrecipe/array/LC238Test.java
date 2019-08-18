package com.omtlab.algorithmrecipe.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC238Test {

    LC238 lc238 = new LC238();
    @Test
    public void productExceptSelf() {
        int[] expected = {80,64,320,40,160};
        int[] input = {4,5,1,8,2};
        Assert.assertArrayEquals(expected,lc238.productExceptSelf(input));
    }

    @Test
    public void productExceptSelfOptimal() {
        int[] expected = {80,64,320,40,160};
        int[] input = {4,5,1,8,2};
        Assert.assertArrayEquals(expected,lc238.productExceptSelfOptimal(input));
    }
}