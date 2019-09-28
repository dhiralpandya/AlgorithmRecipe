package com.omtlab.algorithmrecipe.bit;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoveBitLeftTest {
    
    MoveBitLeft moveBitLeft = new MoveBitLeft();

    @Test
    public void moveLeftBySteps() {
        int value = 8;
        System.out.println("input["+value+"]:"+Integer.toBinaryString(value));
        int output = moveBitLeft.moveLeftBySteps(1,value);
        System.out.println("output["+output+"]:"+Integer.toBinaryString(output));
    }
}