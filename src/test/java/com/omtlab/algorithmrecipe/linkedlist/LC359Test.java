package com.omtlab.algorithmrecipe.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class LC359Test {

    LC359 lc359 = new LC359();

    @Test
    public void shouldPrintMessage() {
        Assert.assertTrue(lc359.shouldPrintMessage(1, "foo"));
        Assert.assertTrue(lc359.shouldPrintMessage(1, "boo"));
        Assert.assertTrue(lc359.shouldPrintMessage(1, "coo"));
        Assert.assertTrue(lc359.shouldPrintMessage(2, "bar"));
        Assert.assertFalse(lc359.shouldPrintMessage(3, "foo"));
        Assert.assertFalse(lc359.shouldPrintMessage(8, "foo"));
        Assert.assertFalse(lc359.shouldPrintMessage(10, "foo"));
        Assert.assertTrue(lc359.shouldPrintMessage(11, "foo"));
        Assert.assertFalse(lc359.shouldPrintMessage(12, "foo"));
        Assert.assertFalse(lc359.shouldPrintMessage(13, "foo"));
    }
}