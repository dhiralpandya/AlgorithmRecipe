package com.omtlab.algorithmrecipe.dp.matrix.startwithzero;

import org.junit.Assert;
import org.junit.Test;

public class LC377Test {

    LC377 lc377 = new LC377();
    @Test
    public void combinationSum4() {
        int input[] = {1,2,3};
        Assert.assertEquals(7,lc377.combinationSum4(input,4));
    }
}