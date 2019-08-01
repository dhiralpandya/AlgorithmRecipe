package com.omtlab.algorithmrecipe.backtracking;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LC282Test {

    private String input;
    private int target;
    private List<String> output;
    private LC282 lc282 = new LC282();
    
    public LC282Test(String input, int target, List<String> output){
        this.input = input;
        this.target = target;
        this.output = output;
    }
    
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Object[]> list = Lists.newArrayList();
        
        list.add(Lists.newArrayList("123",6, Lists.newArrayList("1+2+3","1*2*3")).toArray());
        list.add(Lists.newArrayList("232",8, Lists.newArrayList("2*3+2","2+3*2")).toArray());
        list.add(Lists.newArrayList("105",5, Lists.newArrayList("1*0+5","10-5")).toArray());
        
        return list;
    }
    
    
    @Test
    public void generateAllCombination() {
        List<String> actualOutput = lc282.generateAllCombination(input,target);
        Assert.assertEquals(output.size(),actualOutput.size());
        output.forEach(s->Assert.assertTrue(actualOutput.contains(s)));
    }
}