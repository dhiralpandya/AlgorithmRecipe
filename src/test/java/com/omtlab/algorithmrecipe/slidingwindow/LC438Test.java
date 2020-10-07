package com.omtlab.algorithmrecipe.slidingwindow;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class LC438Test {

    private LC438 lc438;

    @BeforeEach
    void setUp() {
        lc438 = new LC438();
    }

    @Test
    void findAnagrams() {
        List<Integer> output1 =  lc438.findAnagrams("cbaebabacd", "abc");
        Assert.assertEquals(Lists.newArrayList(0,6), output1);

        List<Integer> output2 =  lc438.findAnagrams("abab", "ab");
        Assert.assertEquals(Lists.newArrayList(0,1,2), output2);
    }
}