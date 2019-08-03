package com.omtlab.algorithmrecipe.greedy;

import com.google.common.collect.Lists;
import com.omtlab.algorithmrecipe.greedy.LC56.Interval;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LC56Test {

    
    private List<Interval> input;
    private List<Interval> output;
    private LC56 lc56 = new LC56();
    
    public LC56Test(List<Interval> input, List<Interval> output){
        this.input = input;
        this.output = output;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Object[]> list = Lists.newArrayList();
        
        list.add(Lists.newArrayList(Lists.newArrayList(new Interval(1,3),new Interval(2,6),new Interval(8,10),new Interval(15,18)),
                Lists.newArrayList(new Interval(1,6),new Interval(8,10),new Interval(15,18))).toArray());


        list.add(Lists.newArrayList(Lists.newArrayList(new Interval(1,4),new Interval(4,5)),
                Lists.newArrayList(new Interval(1,5))).toArray());
        
        return list;
    }
    
    
    
    @Test
    public void merge() {
        List<Interval> actualOutput = lc56.merge(input);
        Assert.assertEquals(output.size(),actualOutput.size());
        
        int index = 0;
        for (Interval interval:output){
            
            Assert.assertEquals(interval.start,actualOutput.get(index).start);
            Assert.assertEquals(interval.end,actualOutput.get(index).end);
            
            index++;
        }
    }
}