package com.omtlab.algorithmrecipe.string;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.hamcrest.Matchers.in;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class LC387Test {

    private String input;
    private int output;
    private LC387 lc387 = new LC387();

    public LC387Test(String input, int output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Object[]>  data = Lists.newArrayList();

        data.add(Lists.newArrayList("omt", 0).toArray());
        data.add(Lists.newArrayList("gitgithub", 6).toArray());
        data.add(Lists.newArrayList("cdddcdhgheffge",-1).toArray());

        return data;
    }

    @Test
    public void testFirstUniqChaNiceSolution() {
        assertThat(lc387.firstUniqCharNiceSolution(input), is(output));
    }

    @Test
    public void testFirstUniqCharBestSolution() {
        assertThat(lc387.firstUniqCharBestSolution(input), is(output));
    }
}