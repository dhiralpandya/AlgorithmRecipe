package com.omtlab.algorithmrecipe.greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LC218Test {

    
    LC218 lc218 = new LC218();
    
    @Test
    public void getSkyline() {
        
        int[][] building = { {2, 9, 10}, {3 ,7, 15}, {5 ,12 ,12}, {15 ,20 ,10}, {19, 24 ,8} };
        
        for(List<Integer> list: lc218.getSkyline(building)){
            System.out.println(Arrays.toString(list.toArray()));    
        }
        

    }
}