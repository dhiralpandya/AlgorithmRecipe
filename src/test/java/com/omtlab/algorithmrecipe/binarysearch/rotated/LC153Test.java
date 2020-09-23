package com.omtlab.algorithmrecipe.binarysearch.rotated;

import org.junit.Assert;
import org.junit.Test;

public class LC153Test {

    LC153 lc153 = new LC153();
    @Test
    public void findMin() {
        int a[] = {7,1,2,3,4,5,6};
        Assert.assertEquals(1,lc153.findMin(a));
    }
}