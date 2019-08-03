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
public class LC125Test {

    
    private boolean output;
    private String input;
    private LC125 lc125 = new LC125();
    
    public LC125Test(String input, boolean output){
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Object[]> data = Lists.newArrayList();
        data.add(Lists.newArrayList("A man, a plan, a canal: Panama",true).toArray());
        data.add(Lists.newArrayList("race a car",false).toArray());
        return data;
    }
    
    @Test
    public void isPalindrome() {
        Assert.assertEquals(output,lc125.isPalindrome(input));
    }
}