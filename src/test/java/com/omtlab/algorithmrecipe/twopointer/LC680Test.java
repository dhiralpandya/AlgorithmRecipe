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
public class LC680Test {

    private String input;
    private boolean output;
    private LC680 lc680 = new LC680();
    
    public LC680Test(String input, boolean output){
        this.input=input;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Object[]> data = Lists.newArrayList();
        data.add(Lists.newArrayList("aba",true).toArray());
        data.add(Lists.newArrayList("abca",true).toArray());
        data.add(Lists.newArrayList("abcba",true).toArray());
        data.add(Lists.newArrayList("abcda",false).toArray());
        return data;
    }
    
    @Test
    public void isValidPalindrome() {
        Assert.assertEquals(output,lc680.isValidPalindrome(input));
    }
}