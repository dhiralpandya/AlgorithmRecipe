package com.omtlab.algorithmrecipe.twopointer;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC42Test {

    LC42 lc42 = new LC42();

    @Test
    public void trap() {

        int[] input1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int output = 6;

        Assert.assertEquals(output, lc42.trap(input1));

        int[] input2 = {7,1,4,0,2,8,6,3,5};
        int output2 = 23;
        Assert.assertEquals(output2, lc42.trap(input2));


    }
}