package com.omtlab.algorithmrecipe.set;

import org.junit.Assert;
import org.junit.Test;

public class LC128Test {

    @Test
    public void longestConsecutive() {
        int a[] = {100, 4, 200, 1, 3, 2};
        Assert.assertEquals(4, new LC128().longestConsecutive(a));
    }
    
}