package com.omtlab.algorithmrecipe.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC75Test {

    @Test
    public void sortColor() {
        int[] a = {1,2,2,0,1,2,0,0};
        int[] output = {0,0,0,1,1,2,2,2};
        new LC75().sortColor(a);
        Assert.assertArrayEquals(output,a);
    }
}