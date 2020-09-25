package com.omtlab.algorithmrecipe.greedy;

import com.google.common.collect.Lists;
import com.omtlab.algorithmrecipe.greedy.LC759.Interval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LC759Test {

    @Test
    public void employeeFreeTime() {
        List<List<Interval>> input1 = new ArrayList<>();
        input1.add(Lists.newArrayList(new Interval(1,2), new Interval(5,6)));
        input1.add(Lists.newArrayList(new Interval(1,3)));
        input1.add(Lists.newArrayList(new Interval(4,10)));
        
        for(Interval interval: new LC759().employeeFreeTime(input1)) {
            System.out.println(interval.toString());
        }
        
    }

    @Test
    public void employeeFreeTime1() {
        List<List<Interval>> input1 = new ArrayList<>();
        input1.add(Lists.newArrayList(new Interval(1,3), new Interval(6,7)));
        input1.add(Lists.newArrayList(new Interval(2,4)));
        input1.add(Lists.newArrayList(new Interval(2,5), new Interval(9,12)));

        for(Interval interval: new LC759().employeeFreeTime(input1)) {
            System.out.println(interval.toString());
        }

    }


    @Test
    public void employeeFreeTimeLittleSimple() {
        List<List<Interval>> input1 = new ArrayList<>();
        input1.add(Lists.newArrayList(new Interval(1,2), new Interval(5,6)));
        input1.add(Lists.newArrayList(new Interval(1,3)));
        input1.add(Lists.newArrayList(new Interval(4,10)));

        for(Interval interval: new LC759().employeeFreeTimeLittleSimple(input1)) {
            System.out.println(interval.toString());
        }

    }

    @Test
    public void employeeFreeTime1LittleSimple() {
        List<List<Interval>> input1 = new ArrayList<>();
        input1.add(Lists.newArrayList(new Interval(1,3), new Interval(6,7)));
        input1.add(Lists.newArrayList(new Interval(2,4)));
        input1.add(Lists.newArrayList(new Interval(2,5), new Interval(9,12)));

        for(Interval interval: new LC759().employeeFreeTimeLittleSimple(input1)) {
            System.out.println(interval.toString());
        }

    }
}