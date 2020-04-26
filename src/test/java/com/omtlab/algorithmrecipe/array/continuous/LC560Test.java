package com.omtlab.algorithmrecipe.array.continuous;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class LC560Test extends TestCase {

    LC560 lc560 = new LC560();

    @Test
    public void testSubarraySum() {
        int[] input = {1, 1, 1};
        int k = 2;
        Assert.assertThat(lc560.subarraySum(input, k), is(2));

        int[] input2 = {1,2,1,2,1};
        int k2 = 3;
        Assert.assertThat(lc560.subarraySum(input2, k2),  is(4));
    }

    @Test
    public void testSubarraySumWorking() {
        int[] input = {1, 1, 1};
        int k = 2;
        Assert.assertThat(lc560.subarraySumWorking(input, k), is(2));

        int[] input2 = {1,2,1,2,1};
        int k2 = 3;
        Assert.assertThat(lc560.subarraySumWorking(input2, k2),  is(4));
    }
}