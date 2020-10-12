package com.omtlab.algorithmrecipe.string.map;

import org.junit.Assert;
import org.junit.Test;

public class LC1153Test {

    @Test
    public void canConvertUsingPattern() {
        Assert.assertTrue(new LC1153().canConvertUsingPattern("aabcc", "ccdee"));
        Assert.assertFalse(new LC1153().canConvertUsingPattern("leetcode", "codeleet"));
        Assert.assertTrue(new LC1153().canConvertUsingPattern("ace", "eca"));
    }
}