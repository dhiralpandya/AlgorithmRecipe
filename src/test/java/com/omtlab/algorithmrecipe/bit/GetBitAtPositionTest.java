package com.omtlab.algorithmrecipe.bit;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetBitAtPositionTest {
    
    public GetBitAtPosition getBitAtPosition = new GetBitAtPosition();

    @Test
    public void bitAtPositionFromRight() {
        Assert.assertEquals(1,getBitAtPosition.bitAtPositionFromRight(2,1));
        Assert.assertEquals(0,getBitAtPosition.bitAtPositionFromRight(2,3));
    }

    @Test
    public void bitAtPositionFromLeft() {
        Assert.assertEquals(2,getBitAtPosition.bitAtPositionFromLeft(2,1));
        Assert.assertEquals(0,getBitAtPosition.bitAtPositionFromLeft(2,3));
    }
}