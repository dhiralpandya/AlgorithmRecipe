package com.omtlab.algorithmrecipe.twopointer;

import com.omtlab.algorithmrecipe.dp.matrix.LC727;
import org.junit.Assert;
import org.junit.Test;

public class LC727Test {

    @Test
    public void minWindow() {
        Assert.assertEquals("bcde", new LC727().minWindow("abcdebdde", "bde"));
    }
}