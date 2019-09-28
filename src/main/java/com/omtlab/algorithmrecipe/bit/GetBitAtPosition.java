package com.omtlab.algorithmrecipe.bit;

public class GetBitAtPosition {
    
    public int bitAtPositionFromRight(int value, int position){
        return (value >> position) & 1;
    }

    /**
     * Most IMP 
     * @param value
     * @param position
     * @return
     */
    public int bitAtPositionFromLeft(int value, int position){
        return (value) & (1 << position);//Here instead of 1 and 0 we will get greater than 1 and 0
    }
}
