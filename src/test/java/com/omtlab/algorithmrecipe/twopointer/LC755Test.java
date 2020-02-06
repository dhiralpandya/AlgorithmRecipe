package com.omtlab.algorithmrecipe.twopointer;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class LC755Test {
    

    @Test
    public void pourWater() {
        
        int input1[] = {2,1,1,2,1,2,2};
        int output1[] = {2,2,2,3,2,2,2};
        Assert.assertThat(output1, is(new LC755().pourWater(input1,4,3)));

        int input2[] = {1,2,3,4};
        int output2[] = {2,3,3,4};
        Assert.assertThat(output2, is(new LC755().pourWater(input2,2,2)));

        int input3[] = {3,1,3};
        int output3[] = {4,4,4};
        Assert.assertThat(output3, is(new LC755().pourWater(input3,5,1)));
        
    }
}
