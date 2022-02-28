package com.omtlab.algorithmrecipe.array.map.count;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LC2007Test {

    @Test
    void findOriginalArray() {
        int[] input1 = {1,3,4,2,6,8};
        System.out.println(Arrays.toString(new LC2007().findOriginalArray(input1)));

        int[] input2 = {2,2,4,4,4,8};
        System.out.println(Arrays.toString(new LC2007().findOriginalArray(input2)));

        int[] input3 = {2,2,4,4,4,8, 3};
        System.out.println(Arrays.toString(new LC2007().findOriginalArray(input3)));
    }
}