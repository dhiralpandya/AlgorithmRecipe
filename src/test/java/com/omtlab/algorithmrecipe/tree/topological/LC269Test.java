package com.omtlab.algorithmrecipe.tree.topological;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LC269Test {

    @Test
    public void orderOfChar() {
        List<Character> output = new LC269().orderOfChar(Lists.newArrayList("baa", "abcd", "abca", "cab", "cad")) ;
        System.out.println(Arrays.toString(output.toArray(new Character[1])));


        List<Character> output2 = new LC269().orderOfChar(Lists.newArrayList("caa", "aaa", "aab")) ;
        System.out.println(Arrays.toString(output2.toArray(new Character[1])));
    }
}