package com.omtlab.algorithmrecipe.trie;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC211Test {

    LC211 lc211 = new LC211();
    @Test
    public void addWordAndSearch() {
        lc211.addWord("omt");
        lc211.addWord("dhiral");
        Assert.assertEquals(true,lc211.search("omt"));
        Assert.assertEquals(true,lc211.search("..t"));
        Assert.assertEquals(false,lc211.search("..t."));
        Assert.assertEquals(false,lc211.search("..l."));
        Assert.assertEquals(true,lc211.search("dh.ra."));
        Assert.assertEquals(false,lc211.search("dhir.p"));
    }
}