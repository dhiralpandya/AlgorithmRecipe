package com.omtlab.algorithmrecipe.array.map;

import org.junit.Test;

import static org.junit.Assert.*;

public class LC398Test {

    @Test
    public void pick() {
        int[] a = {1,2,3,3,3};
        LC398 lc398 = new LC398(a);
        System.out.println(lc398.pick(3));
        System.out.println(lc398.pick(1));
    }
}