package com.omtlab.algorithmrecipe.array.sumarray;

import org.junit.Test;

import static org.junit.Assert.*;

public class LC325Test {

    
    LC325 lc325 = new LC325();
    
    
    @Test
    public void maxLength1() {
        Integer[] nums = {-2, -1, 2, 1};
        assertEquals(2, lc325.maxLength(nums, 1));
    }

    @Test
    public void maxLength2() {
        Integer[] nums = {1, -1, 5, -2, 3};
        assertEquals(4, lc325.maxLength(nums, 3));
    }
    
    
    
}