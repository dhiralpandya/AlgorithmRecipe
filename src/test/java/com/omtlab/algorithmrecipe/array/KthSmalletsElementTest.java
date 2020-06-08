package com.omtlab.algorithmrecipe.array;

import com.omtlab.algorithmrecipe.quicksort.KthSmalletsElement;
import org.junit.Assert;
import org.junit.Test;

public class KthSmalletsElementTest {

    @Test
    public void getKthSmalletsElement() {
        int[] b = {3,2,1,5,6,4};
        Assert.assertEquals(2, new KthSmalletsElement().getKthSmalletsElement(b,2));
    }
}