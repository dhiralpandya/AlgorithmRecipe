package com.omtlab.algorithmrecipe.math;

import junit.framework.TestCase;
import org.junit.Test;

public class LC273Test extends TestCase {

    private  LC273 lc273 = new LC273();

    @Test
    public void testNumberToWords() {
        String word = lc273.numberToWords(123);
        System.out.println(word);


        String word2 = lc273.numberToWords(12323);
        System.out.println(word2);

        String word3 = lc273.numberToWords(4312323);
        System.out.println(word3);

        String word4 = lc273.numberToWords(714312323);
        System.out.println(word4);
    }
}