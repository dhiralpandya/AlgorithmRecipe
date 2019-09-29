package com.omtlab.algorithmrecipe.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class LC38Test {

    @Test
    public void countAndSay() {
        LC38 lc38 = new LC38();
        String s = lc38.countAndSay(8);
        System.out.println(s);
    }
}