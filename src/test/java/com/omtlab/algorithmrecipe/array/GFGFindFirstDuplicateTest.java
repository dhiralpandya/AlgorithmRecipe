package com.omtlab.algorithmrecipe.array;

import com.google.common.collect.Lists;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GFGFindFirstDuplicateTest {

    private int[] input;
    private int output;
    private GFGFindFirstDuplicate gfgFindFirstDuplicate = new GFGFindFirstDuplicate();

    public GFGFindFirstDuplicateTest(int[] input, int output) {
        this.input = input;
        this.output = output;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Object[]> data = Lists.newArrayList();
        int[] a1 = {1, 2, 1, 2, 3, 3};
        data.add(Lists.newArrayList(a1, 1).toArray());

        int[] a2 = {1, 2, 3, 4, 5, 6};
        data.add(Lists.newArrayList(a2, -1).toArray());

        int[] a3 = {2, 1, 3, 5, 3, 2};
        data.add(Lists.newArrayList(a3, 3).toArray());

        return data;
    }

    @Test
    public void solutionWithSet() {
        Assert.assertThat(output, Is.is(gfgFindFirstDuplicate.solutionWithSet(input)));
    }
    
    @Test
    public void bestSolutionWithArrayOOfN() {
        Assert.assertThat(output, Is.is(gfgFindFirstDuplicate.bestSolutionWithArrayOOfN(input)));
    }
}