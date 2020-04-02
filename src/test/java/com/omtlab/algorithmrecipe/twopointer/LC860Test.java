package com.omtlab.algorithmrecipe.twopointer;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC860Test {

    private LC860 lc860 = new LC860();

    @Test
    public void lemonadeChange() {
        int[] input1 = {5,5,5,10,20};
        assertTrue(lc860.lemonadeChange(input1));

        int[] input2 = {5,5,10};
        assertTrue(lc860.lemonadeChange(input2));

        int[] input3 = {10, 10};
        assertFalse(lc860.lemonadeChange(input3));

        int[] input4 = {5,5,10,10,20};
        assertFalse(lc860.lemonadeChange(input4));

    }
}