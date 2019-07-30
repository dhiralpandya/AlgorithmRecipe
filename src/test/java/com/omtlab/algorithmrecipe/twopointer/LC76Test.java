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
public class LC76Test {

    private String s;
    private String t;
    private String output;
    private LC76 lc76 = new LC76();
    
    public LC76Test(String s, String t, String output){
        this.s = s;
        this.t = t;
        this.output = output;
    }
    
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        List<Object[]> data = Lists.newArrayList();
        
        data.add(Lists.newArrayList("ADOBECODEBANC","ABC","BANC").toArray());
        
        return data;
    }

    @Test
    public void minWindow() {
        Assert.assertEquals(output,lc76.minWindow(s,t));
    }
}