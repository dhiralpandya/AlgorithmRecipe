package com.omtlab.algorithmrecipe.bit;

/**
 * Algorithm to move bit left side 
 */
public class MoveBitLeft {
    
    public int moveLeftBySteps(int steps, int value){
        return value << steps;
    }
}
