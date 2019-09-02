package com.omtlab.algorithmrecipe.dp.singlearray.startwithzero;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LC494Test {

    @Test
    public void findTargetSumWaysDp() {
        int[] input = {1, 1, 1, 1, 1};
        int sum = 3;
        Assert.assertEquals(5,new LC494().findTargetSumWaysDp(input,sum));
    }
}