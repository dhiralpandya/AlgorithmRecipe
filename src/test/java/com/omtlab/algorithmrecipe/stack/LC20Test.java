package com.omtlab.algorithmrecipe.stack;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC20Test {

    LC20 lc20 = new LC20();
    
    @Test
    public void isValid() {
        Assert.assertTrue(lc20.isValid("()"));
        Assert.assertTrue(lc20.isValid("()[]{}"));
        Assert.assertFalse(lc20.isValid("(}"));
        Assert.assertFalse(lc20.isValid("{(})"));
    }
}