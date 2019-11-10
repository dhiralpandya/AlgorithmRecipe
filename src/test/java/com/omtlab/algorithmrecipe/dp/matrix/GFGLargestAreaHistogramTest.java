package com.omtlab.algorithmrecipe.dp.matrix;

import org.junit.Assert;
import org.junit.Test;

public class GFGLargestAreaHistogramTest {

    GFGLargestAreaHistogram  gfg = new GFGLargestAreaHistogram();
    
    @Test
    public void getArea() {
        //int[] a = {1,2,4};
        //Assert.assertEquals(4,gfg.getArea(a));

        int[] b = {2,1,2,3,1};
        Assert.assertEquals(5,gfg.getArea(b));
    }
}