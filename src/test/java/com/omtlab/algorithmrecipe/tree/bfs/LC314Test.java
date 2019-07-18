package com.omtlab.algorithmrecipe.tree.bfs;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class LC314Test {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Object[]> params = new ArrayList<>();
        Integer[] input1 = {3,9,20,null,null,15,7};
        List<List<Integer>> output1 = Lists.newArrayList();
        output1.add(Lists.newArrayList(9));
        output1.add(Lists.newArrayList(3,15));
        output1.add(Lists.newArrayList(20));
        output1.add(Lists.newArrayList(7));


        Integer[] input2 = {3,9,8,4,0,1,7,null,null,null,2,5};
        List<List<Integer>> output2 = Lists.newArrayList();
        output2.add(Lists.newArrayList(4));
        output2.add(Lists.newArrayList(9,5));
        output2.add(Lists.newArrayList(3,0,1));
        output2.add(Lists.newArrayList(8,2));
        output2.add(Lists.newArrayList(7));



        params.add(Lists.newArrayList(input1,output1).toArray());
        params.add(Lists.newArrayList(input2,output2).toArray());
        return params;
    }
    
    
    private LC314 lc314 = new LC314();
    private Integer input[];
    private List<List<Integer>> output;
    
    public LC314Test(Integer input[], List<List<Integer>> output){
        this.input = input;
        this.output = output;
    }
    
    @Test
    public void getVerticalOrder() {
        Assert.assertEquals(output,lc314.getVerticalOrder(input));
    }
}