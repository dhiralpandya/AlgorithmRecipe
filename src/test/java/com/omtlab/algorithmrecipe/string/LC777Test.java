package com.omtlab.algorithmrecipe.string;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LC777Test {

    @Test
    public void mysolution() {
        assertTrue(new LC777().mysolution("RXXLRXRXL", "XRLXXRRLX"));
        assertFalse(new LC777().mysolution("X", "L"));
    }

    @Test
    public void canTransform() {
        assertTrue(new LC777().canTransform("RXXLRXRXL", "XRLXXRRLX"));
        assertFalse(new LC777().canTransform("X", "L"));
    }
}