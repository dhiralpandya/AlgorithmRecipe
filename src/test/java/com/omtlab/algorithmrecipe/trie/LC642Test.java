package com.omtlab.algorithmrecipe.trie;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LC642Test {

    @Test
    public void keyPressed() {
        String[] words = {"i love you", "island","ironman", "i love leetcode"};
        int[] times = {5,3,2,2};
        
        LC642 lc642 = new LC642(words,times);
        List<String> s1 = lc642.keyPressed('i');
        System.out.println(Arrays.toString(s1.toArray()));
        
        List<String> s2 = lc642.keyPressed(' ');
        System.out.println(Arrays.toString(s2.toArray()));

        List<String> s3 = lc642.keyPressed('a');
        System.out.println(Arrays.toString(s3.toArray()));
    }
}