package com.omtlab.algorithmrecipe.bit;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoveBitRightTest {

    @Test
    public void moveRightBySteps() {
        int value = 2;
        System.out.println("input["+value+"]:"+Integer.toBinaryString(value));
        int output = new MoveBitRight().moveRightBySteps(1,value);
        System.out.println("output["+output+"]:"+Integer.toBinaryString(output));
    }
}