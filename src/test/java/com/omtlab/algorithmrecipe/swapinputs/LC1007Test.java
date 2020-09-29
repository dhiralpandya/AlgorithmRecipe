package com.omtlab.algorithmrecipe.swapinputs;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class LC1007Test {

    private LC1007 lc1007 = new LC1007();

    @Test
    public void minDominoRotations() {
        int A1[] = {2,1,2,4,2,2};
        int B1[] = {5,2,6,2,3,2};

        assertEquals(2, lc1007.minDominoRotations(A1, B1));

        int A2[] = {3,5,1,2,3};
        int B2[] = {3,6,3,3,4};

        assertEquals(-1, lc1007.minDominoRotations(A2, B2));
    }

}