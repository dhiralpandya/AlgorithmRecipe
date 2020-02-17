package com.omtlab.algorithmrecipe.array.sumarray;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class GFGFindPairForSumTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        List<Object[]> data = Lists.newArrayList();
        
        List<Integer> output1 = Lists.newArrayList(3,4);
        Integer[] input1 = {-8, 1, 4, 6, 10, 45};
        Integer sum1 = 16;
        data.add(Lists.newArrayList(output1,input1,sum1).toArray());
        
        return data;
        
    }
    
    private List<Integer> output;
    private Integer[] input;
    private Integer sum;
    private GFGFindPairForSum gfgFindPairForSum = new GFGFindPairForSum();
    
    
    public GFGFindPairForSumTest(List<Integer> output,Integer[] input,Integer sum){
        this.output= output;
        this.input = input;
        this.sum = sum;
    }
    
    @Test
    public void findPair() {
        Assert.assertEquals(output,gfgFindPairForSum.findPair(input,sum));
    }

    @Test
    public void findPairDiff() {
        Assert.assertEquals(output,gfgFindPairForSum.findPairDiff(input,sum));
    }
}