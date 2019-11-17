package com.omtlab.algorithmrecipe.array.map;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LC554Test {

    @Test
    public void leastBricks() {
        
        List<List<Integer>> input = Lists.newArrayList();
        input.add(Lists.newArrayList(1,2,2,1));
        input.add(Lists.newArrayList(3,1,2));
        input.add(Lists.newArrayList(1,3,2));
        input.add(Lists.newArrayList(2,4));
        input.add(Lists.newArrayList(3,1,2));
        input.add(Lists.newArrayList(1,3,1,1));

        Assert.assertEquals(2,new LC554().leastBricks(input));
    }

    @Test
    public void leastBricksSimple() {

        List<List<Integer>> input = Lists.newArrayList();
        input.add(Lists.newArrayList(1,2,2,1));
        input.add(Lists.newArrayList(3,1,2));
        input.add(Lists.newArrayList(1,3,2));
        input.add(Lists.newArrayList(2,4));
        input.add(Lists.newArrayList(3,1,2));
        input.add(Lists.newArrayList(1,3,1,1));

        Assert.assertEquals(2,new LC554().leastBricksSimple(input));
    }
}