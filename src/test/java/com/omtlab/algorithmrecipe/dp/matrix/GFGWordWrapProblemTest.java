package com.omtlab.algorithmrecipe.dp.matrix;

import org.junit.Test;

import java.util.List;

public class GFGWordWrapProblemTest {

    @Test
    public void fullJustify() {
        String[] input = {"abcdef", "xyz","likes","to", "code"};
        List<String> output = new GFGWordWrapProblem().fullJustify(input,10);
        for(String s:output){
            System.out.println(s);
        }
    }
}