package com.omtlab.algorithmrecipe.dp.matrix;

import org.junit.Assert;
import org.junit.Test;

public class LC221Test {

    @Test
    public void maximalSquare() {
        char[][] input = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        Assert.assertEquals(4,new LC221().maximalSquare(input));
    }
}