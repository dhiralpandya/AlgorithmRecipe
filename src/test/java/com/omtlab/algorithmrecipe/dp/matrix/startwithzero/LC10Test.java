package com.omtlab.algorithmrecipe.dp.matrix.startwithzero;

import org.junit.Test;

import static org.junit.Assert.*;

public class LC10Test {

    @Test
    public void isMatch() {
        LC10 lc10 = new LC10();
        System.out.println(lc10.isMatch("omt","omt"));
        
        System.out.println(lc10.isMatch("","a*b*"));
        System.out.println(lc10.isMatch("abbbbccc","a*ab*bbbbc*"));
        System.out.println(lc10.isMatch("abbbbccc","aa*bbb*bbbc*"));
        System.out.println(lc10.isMatch("abbbbccc",".*bcc"));
        System.out.println(lc10.isMatch("abbbbccc",".*bcc*"));
        System.out.println(lc10.isMatch("abbbbccc",".*bcc*"));
        System.out.println(lc10.isMatch("aaa","ab*a*c*a"));
        System.out.println(lc10.isMatch("aaa","a*"));
        System.out.println(lc10.isMatch("aaabb","a*b."));
    }
}