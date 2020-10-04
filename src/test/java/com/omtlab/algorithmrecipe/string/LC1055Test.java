package com.omtlab.algorithmrecipe.string;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class LC1055Test {

    private LC1055 lc1055 = new LC1055();

    @Test
    void shortestWay() {
        assertEquals(2, lc1055.shortestWay("abc", "abcbc"));
        assertEquals(-1, lc1055.shortestWay("abc", "abcdbc"));
        assertEquals(3, lc1055.shortestWay("xyz", "xzyxz"));
    }
}