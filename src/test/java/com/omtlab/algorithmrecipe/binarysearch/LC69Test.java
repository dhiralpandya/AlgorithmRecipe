package com.omtlab.algorithmrecipe.binarysearch;

import org.junit.Test;

public class LC69Test {

    
    LC69 lc69 = new LC69();
    
    @Test
    public void mySqrt() {
        System.out.println("Square Root of 277 :");
        System.out.println(lc69.mySqrt(277));
        System.out.println("Square Root of 277 (Math.sqrt):");
        System.out.println(Math.sqrt(277));

        System.out.println("Square Root of 5 :");
        System.out.println(lc69.mySqrt(5));
        System.out.println("Square Root of 5 (Math.sqrt):");
        System.out.println(Math.sqrt(5));

        System.out.println("Square Root of 7 :");
        System.out.println(lc69.mySqrt(7));
        System.out.println("Square Root of 7 (Math.sqrt):");
        System.out.println(Math.sqrt(7));

        System.out.println("Square Root of 49 :");
        System.out.println(lc69.mySqrt(49));
        System.out.println("Square Root of 49 (Math.sqrt):");
        System.out.println(Math.sqrt(49));

        System.out.println("Square Root of 25 :");
        System.out.println(lc69.mySqrt(25));
        System.out.println("Square Root of 25 (Math.sqrt):");
        System.out.println(Math.sqrt(25));

        System.out.println("Square Root of 81 :");
        System.out.println(lc69.mySqrt(81));
        System.out.println("Square Root of 25 (Math.sqrt):");
        System.out.println(Math.sqrt(81));

        System.out.println("Square Root of 277.787 :");
        System.out.println(lc69.mySqrt(277.787));
        System.out.println("Square Root of 277.787 (Math.sqrt):");
        System.out.println(Math.sqrt(277.787));
    }
}