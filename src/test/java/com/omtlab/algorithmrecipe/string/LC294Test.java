package com.omtlab.algorithmrecipe.string;

import org.junit.Assert;
import org.junit.Test;

public class LC294Test {

    @Test
    public void isFirstPersonGoingToWin() {
        Assert.assertTrue(new LC294().isFirstPersonGoingToWin("++++"));
        Assert.assertFalse(new LC294().isFirstPersonGoingToWin("+"));
        Assert.assertTrue(new LC294().isFirstPersonGoingToWin("++"));
    }
}