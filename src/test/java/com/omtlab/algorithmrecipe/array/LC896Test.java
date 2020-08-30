package com.omtlab.algorithmrecipe.array;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LC896Test {

    private LC896 lc896 = new LC896();

    @Test
    public void isMonotonic() {
        int[] input1 = {1, 2, 2, 3};
        assertTrue(lc896.isMonotonic(input1));
        int[] input2 = {6, 5, 4, 4};
        assertTrue(lc896.isMonotonic(input2));
        int[] input3 = {1, 3, 2};
        assertFalse(lc896.isMonotonic(input3));
        int[] input4 = {1, 2, 4, 5};
        assertTrue(lc896.isMonotonic(input4));
        int[] input5 = {1, 1, 1};
        assertTrue(lc896.isMonotonic(input5));
    }
}