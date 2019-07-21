package com.omtlab.algorithmrecipe.dp.matrix.startwithzero;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GFGEditDistanceTest {

    private GFGEditDistance gfgEditDistance = new GFGEditDistance();
    private  String s1;
    private  String s2;
    private int output;
    
    public GFGEditDistanceTest(String s1, String s2, int output){
        this.s1=s1;
        this.s2=s2;
        this.output = output;
    }
    
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        List<Object[]> output  = Lists.newArrayList();
        
        String s11 = "abc";
        String s12 = "abd";
        int output1 = 1;
        output.add(Lists.newArrayList(s11,s12,output1).toArray());


        String s21 = "abcdfed";
        String s22 = "abd";
        int output2 = 4;
        output.add(Lists.newArrayList(s21,s22,output2).toArray());
        
        return output;
    }
    
    @Test
    public void findMinEditDistacne() {
        Assert.assertEquals(output,gfgEditDistance.findMinEditDistacne(s1,s2));
    }
}