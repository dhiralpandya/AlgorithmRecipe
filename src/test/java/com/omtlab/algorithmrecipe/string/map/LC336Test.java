package com.omtlab.algorithmrecipe.string.map;

import com.omtlab.algorithmrecipe.common.util.MatrixUtil;
import org.junit.Test;


public class LC336Test {
    
    @Test
    public void palindromePairs() {
        LC336 lc336 = new LC336();
        String[] input1 = {"abcd","dcba","lls","s","sssll"};
        MatrixUtil.printListOfList(lc336.palindromePairs(input1));
    }

    @Test
    public void palindromePairs2() {
        LC336 lc336 = new LC336();
        String[] input1 = {"bat","tab","cat"};
        MatrixUtil.printListOfList(lc336.palindromePairs(input1));
    }
    
}
