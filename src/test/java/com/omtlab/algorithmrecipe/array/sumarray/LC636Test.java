package com.omtlab.algorithmrecipe.array.sumarray;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LC636Test {

    private LC636 lc636 = new LC636();

    @Test
    public void getExclusiveTime() {
        int[] output = {3, 4};
        int n = 2;
        List<String> logs = Lists.newArrayList("0:start:0", "1:start:2", "1:end:5", "0:end:6");

        Assert.assertArrayEquals(output, lc636.exclusiveTime(n, logs));

    }

    @Test
    public void getExclusiveTime2() {
        int[] output = {3, 4};
        int n = 4;
        //[5, 4, 7, 3]
        List<String> logs = Lists.newArrayList("0:start:0", "1:start:2", "2:start:4", "3:start:8", "3:end:10", "1:end:12", "2:end:15", "0:end:18");
        System.out.println(Arrays.toString(lc636.exclusiveTime(n, logs)));
        //Assert.assertArrayEquals(output,);

    }
}