package com.omtlab.algorithmrecipe.dp.matrix;

import org.junit.Assert;
import org.junit.Test;

public class LC85Test {
    
    LC85 lc85 = new LC85();

    @Test
    public void maximalRectangle() {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        Assert.assertEquals(6,lc85.maximalRectangle(matrix));
    }
}