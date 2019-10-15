package com.omtlab.algorithmrecipe.stack;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LC71Test {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Object[]> params = new ArrayList<>();

        params.add(Lists.newArrayList("/home/","/home" ).toArray());
        params.add(Lists.newArrayList("/../","/" ).toArray());
        params.add(Lists.newArrayList("/home//foo/","/home/foo" ).toArray());
        params.add(Lists.newArrayList("/a/./b/../../c/","/c" ).toArray());
        params.add(Lists.newArrayList("/a/../../b/../c//.//","/c" ).toArray());
        params.add(Lists.newArrayList("/a//b////c/d//././/..","/a/b/c" ).toArray());
        
        return params;
    }
    
    LC71 lc71 = new LC71();


    private String input;
    private String output;
    
    public LC71Test(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @Test
    public void simplifyPath() {
        Assert.assertEquals(output,lc71.simplifyPath(input));
    }
}