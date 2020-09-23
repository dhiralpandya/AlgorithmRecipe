package com.omtlab.algorithmrecipe.binarysearch.rotated;

import org.junit.Assert;
import org.junit.Test;

public class LC154Test {

    LC154 lc154 = new LC154();
    @Test
    public void findMin() {
        int[] a = {1,2,2,2,0,1,1};
        Assert.assertEquals(0,lc154.findMin(a));
    }
}