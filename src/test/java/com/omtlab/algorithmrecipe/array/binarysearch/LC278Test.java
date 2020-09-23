package com.omtlab.algorithmrecipe.array.binarysearch;

import com.omtlab.algorithmrecipe.binarysearch.LC278;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class LC278Test {

    @Test
    void firstBadVersion() {
        LC278 lc278 = new LC278(5);
        int actual = lc278.firstBadVersion(10);
        Assert.assertEquals(5, actual);

        LC278 lc278_2 = new LC278(0);
        int actual_2 = lc278_2.firstBadVersion(10);
        Assert.assertEquals(0, actual_2);
    }
}