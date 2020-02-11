package com.omtlab.algorithmrecipe.array;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LC324Test {

    LC324 lc324 = new LC324();
    
    @Test
    public void wiggleSort() {
        int i[] = {1, 5, 1, 1, 6, 4, 8};
        lc324.wiggleSort(i);
        System.out.println(Arrays.toString(i));
    }
}