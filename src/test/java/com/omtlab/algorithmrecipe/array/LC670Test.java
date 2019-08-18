package com.omtlab.algorithmrecipe.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC670Test {

    LC670 lc670 = new LC670();
    
    @Test
    public void maxValue() {
        Assert.assertEquals(9941,lc670.maxValue(9914)); 
    }
    
}