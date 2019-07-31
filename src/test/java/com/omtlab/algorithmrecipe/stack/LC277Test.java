package com.omtlab.algorithmrecipe.stack;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC277Test {

    @Test
    public void findCelebrity() {

        int knows[][] = { 
                { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 1, 0 } };
        LC277 lc277 = new LC277(knows);
        Assert.assertEquals(2,lc277.findCelebrity(4));

    }
}