package com.omtlab.algorithmrecipe.bit;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC477Test {

    LC477 lc477 =  new LC477();
    
    @Test
    public void totalHammingDistance() {
        int[] nums = {4,14,2};
        Assert.assertEquals(6,lc477.totalHammingDistance(nums));
    }
}