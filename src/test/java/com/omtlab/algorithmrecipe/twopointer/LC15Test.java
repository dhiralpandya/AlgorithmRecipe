package com.omtlab.algorithmrecipe.twopointer;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class LC15Test {


    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        List<Object[]> data = Lists.newArrayList();

        Integer[] input1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> output1 = Lists.newArrayList();
        output1.add(Lists.newArrayList(-1, -1, 2));
        output1.add(Lists.newArrayList(-1, 0, 1));
        data.add(Lists.newArrayList(input1,output1).toArray());
      
        return data;

    }
    
    
    private LC15 lc15 = new LC15();

    Integer[] input; 
    List<List<Integer>> output;
    
    public LC15Test(Integer[] input, List<List<Integer>> output){
        this.input=input;
        this.output = output;
    }
    
    @Test
    public void threeSum() {
        Assert.assertEquals(output,lc15.threeSum(input));
    }
}