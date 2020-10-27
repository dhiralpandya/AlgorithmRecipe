package com.omtlab.algorithmrecipe.binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class LC162Test {

    @Test
    public void findPeakElement() {
        int[] input1 = {1, 2, 3, 1};
        Assert.assertEquals(2, new LC162().findPeakElement(input1));

        int[] input2 = {1, 2, 1, 3, 5, 6, 4};
        Assert.assertEquals(5, new LC162().findPeakElement(input2));
    }
}