package com.omtlab.algorithmrecipe.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class KthSmalletsElementTest {

    @Test
    public void getKthSmalletsElement() {
        int[] b = {3,2,1,5,6,4};
        Assert.assertEquals(2, new KthSmalletsElement().getKthSmalletsElement(b,2));
    }
}