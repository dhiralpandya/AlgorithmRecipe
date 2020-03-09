package com.omtlab.algorithmrecipe.tree.topological;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC953Test {

    LC953 lc953 = new LC953();

    @Test
    public void isAlienSorted() {
        String[] s1 = {"hello","leetcode"};
        String o1 = "hlabcdefgijkmnopqrstuvwxyz";

        Assert.assertTrue(lc953.isAlienSorted(s1,o1));

        String[]  s2 = {"word","world","row"};
        String o2 = "worldabcefghijkmnpqstuvxyz";

        Assert.assertFalse(lc953.isAlienSorted(s2,o2));

        String[] s3 = {"apple","app"};
        String o3 = "abcdefghijklmnopqrstuvwxyz";

        Assert.assertFalse(lc953.isAlienSorted(s3,o3));
    }
}