package com.omtlab.algorithmrecipe.string;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC809Test {

    private LC809 lc809 = new LC809();

    @Test
    void expressiveWords() {
        String words1[] = {"hello", "hi", "helo"};
        Assert.assertEquals(1, lc809.expressiveWords("heeellooo",words1));

        String words2[] = {"ello", "hi", "elo"};
        Assert.assertEquals(0, lc809.expressiveWords("heeellooo",words2));
    }
}