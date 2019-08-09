package com.omtlab.algorithmrecipe.array.sumarray;

import org.junit.Assert;
import org.junit.Test;

public class LC121Test {
    
    @Test
    public void maxProfit(){
        int[] input = {7,1,5,3,6,4};
        Assert.assertEquals(5, new LC121().maxProfit(input));
    }

}