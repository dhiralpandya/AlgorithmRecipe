package com.omtlab.algorithmrecipe.bit;

public class XOR {
    
    public String doXOR(int a, int b){
        int xor = a^b;
        return Integer.toBinaryString(xor);
    }
}
