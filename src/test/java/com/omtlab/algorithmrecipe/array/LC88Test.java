package com.omtlab.algorithmrecipe.array;

import com.omtlab.algorithmrecipe.twopointer.LC88;
import org.junit.Assert;
import org.junit.Test;

public class LC88Test {

    @Test
    public void mergeOptimal() {
        int input1[] = {1,4,7,0,0,0,0};
        int input2[] = {3,4,5,6};
        int m = 3;
        int n = 4;
        int[] expected = {1,3,4,4,5,6,7};
        new LC88().mergeOptimal(input1,m,input2,n);
        Assert.assertArrayEquals(expected,input1);
    }
}