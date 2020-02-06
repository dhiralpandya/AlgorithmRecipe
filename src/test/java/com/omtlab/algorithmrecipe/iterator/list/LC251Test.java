package com.omtlab.algorithmrecipe.iterator.list;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LC251Test {

    @Test
    public void next() {
        List<List<Integer>> input = Lists.newArrayList();
        input.add(Lists.newArrayList(1,2));
        input.add(Lists.newArrayList(3));
        input.add(Lists.newArrayList(4));
        
        LC251 lc251 = new LC251(input);
        Assert.assertTrue(lc251.hasNext());
        Assert.assertEquals(1,lc251.next());
        Assert.assertEquals(2,lc251.next());
        Assert.assertEquals(3,lc251.next());
        Assert.assertEquals(4,lc251.next());
        Assert.assertFalse(lc251.hasNext());
        
    }
}