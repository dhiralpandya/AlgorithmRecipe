package com.omtlab.algorithmrecipe.array;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LC13Test {

    private String input; 
    private int output;
    private LC13 lc13 = new LC13();
    
    public LC13Test(String input, int output){
        this.input = input;
        this.output = output;
    }
    
    
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        List<Object[]> data = Lists.newArrayList();
        
        data.add(Lists.newArrayList("III",3).toArray());
        data.add(Lists.newArrayList("IV",4).toArray());
        data.add(Lists.newArrayList("IX",9).toArray());
        data.add(Lists.newArrayList("LVIII",58).toArray());
        data.add(Lists.newArrayList("MCMXCIV",1994).toArray()); 
        
        return data;
    }
    
    @Test
    public void romanToIntNotGreatSolution() {
        Assert.assertEquals(output,lc13.romanToIntNotGreatSolution(input));
    }

    @Test
    public void romanToIntWowSolution() {
        Assert.assertEquals(output,lc13.romanToIntWowSolution(input));
    }
}