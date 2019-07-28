package com.omtlab.algorithmrecipe.matrix.bfs;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LC200Test {
    
    private int[][] input;
    private int maxIsland;
    private LC200 lc200 = new LC200();
    
    public LC200Test(int[][] input, int maxIsland){
        this.input = input;
        this.maxIsland = maxIsland;
    }
    
    
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        List<Object[]> list = Lists.newArrayList();
        int[][] input1 = {
                {1,1,1,1,0},
                {1,1,0,1,0},
                {1,1,0,0,0},
                {0,0,0,0,0}
        };
        int output1 = 1;
        list.add(Lists.newArrayList(input1,output1).toArray());


        int[][] input2 = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}
        };
        int output2 = 3;
        list.add(Lists.newArrayList(input2,output2).toArray());
        
        return list;
    }

    @Test
    public void totalNumberOfIsland() {
        Assert.assertEquals(maxIsland,lc200.totalNumberOfIsland(input));
    }
}