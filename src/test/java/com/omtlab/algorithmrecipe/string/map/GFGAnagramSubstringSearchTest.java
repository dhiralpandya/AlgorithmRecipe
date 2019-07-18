package com.omtlab.algorithmrecipe.string.map;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GFGAnagramSubstringSearchTest {

    private String main;
    private String pattern;
    private List<Integer> output;
    private GFGAnagramSubstringSearch gfgAnagramSubstringSearch = new GFGAnagramSubstringSearch();
    
    public GFGAnagramSubstringSearchTest(String main, String pattern, List<Integer> output){
        this.main = main;
        this.pattern = pattern;
        this.output = output;
    }
    
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        List<Object[]> output = Lists.newArrayList();
        
        String main1 = "BACDGABCDA";
        String pattern1 = "ABCD";
        List<Integer> output1 = Lists.newArrayList(0,5,6);
        
        output.add(Lists.newArrayList(main1,pattern1,output1).toArray());

        String main2 = "AAABABAA";
        String pattern2 = "AABA";
        List<Integer> output2 = Lists.newArrayList(0,1,4);

        output.add(Lists.newArrayList(main2,pattern2,output2).toArray());

        String main3 = "BACDEABCDA";
        String pattern3 = "ABCD";
        List<Integer> output3 = Lists.newArrayList(0,5,6);

        output.add(Lists.newArrayList(main3,pattern3,output3).toArray());
        
        return output;
    }
    
    @Test
    public void getAllPosition() {
        Assert.assertEquals(output,gfgAnagramSubstringSearch.getAllPosition(main,pattern));
    }
}