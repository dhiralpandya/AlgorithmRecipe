package com.omtlab.algorithmrecipe.matrix.bfs;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class GFGShortDistMrxTest {
    
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Object[]> params = new ArrayList<>();
        
        
        //Param 1
        List param1 = Lists.newArrayList();
        char input1[][] = { { '0', '*', '0', 's' },
            { '*', '0', '*', '*' },
            { '0', '*', '*', '*' },
            { 'd', '*', '*', '*' } };

        param1.add(input1);
        param1.add(6);
        
        
        //Param 2
        List param2 = Lists.newArrayList();
        char input2[][] = { {'0', '*', '0', 's'},
                {'*', '0', '*', '*'},
                {'0', '*', '*', '*'},
                {'d', '0', '0', '0'}};

        param2.add(input2);
        param2.add(-1);


        //Param 3
        List param3 = Lists.newArrayList();
        char input3[][] = {   {'s', '*', '0', '0'},
                {'*', '0', '0', '*'},
                {'*', '0', 'd', '*'},
                {'*', '0', '0', '*'},
                {'*', '*', '*', '*'}};

        param3.add(input3);
        param3.add(10);


        //Param 4
        List param4 = Lists.newArrayList();
        char input4[][] = { {'s', '*', '0', '0'},
                {'*', '0', '0', '*'},
                {'*', '0', 'd', '0'},
                {'*', '*', '*', '*'},
                {'*', '*', '*', '*'}};

        param4.add(input4);
        param4.add(6);
        
        
        //Add all params
        params.add(param1.toArray());
        params.add(param2.toArray());
        params.add(param3.toArray());
        params.add(param4.toArray());
        
        return params;
    }

    private char[][] input;
    private int output;
    GFGShortDistMrx gfgShortDistMrx = new GFGShortDistMrx();
    public GFGShortDistMrxTest(char[][] input, int output){
        this.input = input;
        this.output = output;
    }
    
    
    
    @Test
    public void findMinDistance() {
        Assert.assertEquals(output,gfgShortDistMrx.findMinDistance(input));
    }
}