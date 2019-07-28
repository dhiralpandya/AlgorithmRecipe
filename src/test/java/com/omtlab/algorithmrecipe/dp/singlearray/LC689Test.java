package com.omtlab.algorithmrecipe.dp.singlearray;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LC689Test {

    private  int[] input;
    private  int k_FromInput;
    private int[] output;
    private LC689 lc689 = new LC689(); 
    
    public LC689Test(int[] input,int k_FromInput,int[] output){
        this.input = input;
        this.k_FromInput = k_FromInput;
        this.output = output;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        List<Object[]> list = Lists.newArrayList();
        
        int[] input1 = {1,2,1,2,6,7,5,1};
        int[] output1 = {0, 3, 5};
        int k_FromInput1 = 2;
        list.add(Lists.newArrayList(input1,k_FromInput1,output1).toArray());



        int[] input2 = {1,8,5,10,9,13,1};
        int[] output2 = {3,4,5};
        int k_FromInput2 = 1;
        list.add(Lists.newArrayList(input2,k_FromInput2,output2).toArray());
        
        
        return list;
    }
    
    @Test
    public void getStartIndexs() {
        Assert.assertArrayEquals(output,lc689.getStartIndexs(input,k_FromInput));
    }
}