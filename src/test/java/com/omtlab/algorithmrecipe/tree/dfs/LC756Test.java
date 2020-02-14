package com.omtlab.algorithmrecipe.tree.dfs;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC756Test {

    @Test
    public void pyramidTransition() {
        String bottom = "BCD"; 
        String allowed[] = {"BCG", "CDE", "GEA", "FFF"};
        Assert.assertTrue(new LC756().pyramidTransition(bottom, Lists.newArrayList(allowed)));

        String bottom2 = "AABA";
        String allowed2[] = {"AAA", "AAB", "ABA", "ABB", "BAC"};
        Assert.assertFalse(new LC756().pyramidTransition(bottom2, Lists.newArrayList(allowed2)));
    }
}