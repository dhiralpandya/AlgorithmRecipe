package com.omtlab.algorithmrecipe.greedy;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LC57Test {


    private List<LC57.Interval> input;
    private LC57.Interval newInterval;
    private List<LC57.Interval> output;
    private LC57 lc57 = new LC57();

    public LC57Test(List<LC57.Interval> input, List<LC57.Interval> output,LC57.Interval newInterval){
        this.input = input;
        this.output = output;
        this.newInterval = newInterval;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Object[]> list = Lists.newArrayList();

        
        list.add(Lists.newArrayList(Lists.newArrayList(new LC57.Interval(1,3),new LC57.Interval(6,9)),
                Lists.newArrayList(new LC57.Interval(1,5),new LC57.Interval(6,9)),new LC57.Interval(2,5)).toArray());


        list.add(Lists.newArrayList(Lists.newArrayList(new LC57.Interval(1,2),new LC57.Interval(3,5),new LC57.Interval(6,7),new LC57.Interval(8,10),new LC57.Interval(12,16)),
                Lists.newArrayList(new LC57.Interval(1,2),new LC57.Interval(3,10),new LC57.Interval(12,16)), new LC57.Interval(4,8)).toArray());

        return list;
    }
    @Test
    public void insertInterval() {
        List<LC57.Interval> actualOutput = lc57.insertInterval(input,newInterval);
        Assert.assertEquals(output.size(),actualOutput.size());

        int index = 0;
        for (LC57.Interval interval:output){

            Assert.assertEquals(interval.start,actualOutput.get(index).start);
            Assert.assertEquals(interval.end,actualOutput.get(index).end);

            index++;
        }
    }
}