package com.omtlab.algorithmrecipe.twopointer;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC5Test {

    LC5 lc5 = new LC5();

    @Test
    public void longestPalindrome() {
        Assert.assertEquals("bab",lc5.longestPalindrome("babad"));
        Assert.assertEquals("bb",lc5.longestPalindrome("cbbd"));
    }
}