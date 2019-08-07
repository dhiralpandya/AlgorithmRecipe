package com.omtlab.algorithmrecipe.dp.singlearray;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC161Test {

    private LC161 lc161 = new LC161();
    @Test
    public void oneEditDistance() {
        Assert.assertTrue(lc161.oneEditDistance("abc","ab"));
        Assert.assertTrue(lc161.oneEditDistance("abc","ac"));
        Assert.assertTrue(lc161.oneEditDistance("ab","abc"));
        Assert.assertTrue(lc161.oneEditDistance("abc","bc"));
        Assert.assertFalse(lc161.oneEditDistance("abc","abcde"));
        Assert.assertTrue(lc161.oneEditDistance("abc","abc"));
    }
}