package com.omtlab.algorithmrecipe.backtracking;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;


public class LC78Test {

   
    

    @Test
    public void getSubset() {
        int[] a = {1,2,3};
        List<List<Integer>> output = new LC78().getSubset(a);
        for(List<Integer> list:output){
            System.out.println(Arrays.toString(list.toArray(new Integer[1])));
        }
    }
    
    
    
}