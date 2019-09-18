package com.omtlab.algorithmrecipe.dp.singlearray.startwithzero;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC139Test {

    @Test
    public void wordBreak() {
        Assert.assertTrue(new LC139().wordBreak("omtlab", Lists.newArrayList("omt","lab")));
        Assert.assertTrue(new LC139().wordBreak("applepenapple", Lists.newArrayList("apple","pen")));
        Assert.assertFalse(new LC139().wordBreak("catsandog", Lists.newArrayList("cats", "dog", "sand", "and", "cat")));
    }

    @Test
    public void wordBreakMyStyle() {
        Assert.assertTrue(new LC139().wordBreakMyStyle("omtlab", Lists.newArrayList("omt","lab")));
        Assert.assertTrue(new LC139().wordBreakMyStyle("applepenapple", Lists.newArrayList("apple","pen")));
        Assert.assertFalse(new LC139().wordBreakMyStyle("catsandog", Lists.newArrayList("cats", "dog", "sand", "and", "cat")));
    }
}