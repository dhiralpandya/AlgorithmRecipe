package com.omtlab.algorithmrecipe.bit;

import org.junit.Assert;
import org.junit.Test;

public class BitSetTest {

    @Test
    public void manualBitSet() {
        BitSet algo = new BitSet();
        Assert.assertTrue(algo.manualBitSet("ABCDDDABC", 3));
    }

    @Test
    public void usingBitSet() {
        BitSet algo = new BitSet();
        Assert.assertTrue(algo.usingBitSet("ABCDDDABC", 3));
    }
}