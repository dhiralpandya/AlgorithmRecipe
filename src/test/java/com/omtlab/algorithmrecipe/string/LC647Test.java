package com.omtlab.algorithmrecipe.string;

import org.junit.Assert;
import org.junit.Test;

public class LC647Test {

    LC647 lc647 = new LC647();
    
    @Test
    public void countSubstrings() {
        Assert.assertEquals(3, lc647.countSubstrings("abc"));
        Assert.assertEquals(6, lc647.countSubstrings("aaa"));
    }
}