package com.omtlab.algorithmrecipe.binarysearch;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LC875Test {

    private int[] piles;
    private int H;
    private int output;
    
    private LC875 lc875 = new LC875();
    
    public LC875Test(int[] piles, int H, int output){
        this.piles = piles;
        this.H = H;
        this.output = output;
    }
    
    

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Object[]> list = Lists.newArrayList();
        int a[] = {3,6,7,11};
        list.add(Lists.newArrayList(a,8,4).toArray());
        
        int b[] = {30,11,23,4,20};
        list.add(Lists.newArrayList(b,5,30).toArray());


        int c[] = {30,11,23,4,20};
        list.add(Lists.newArrayList(c,6,23).toArray());
        
        return list;
    }
    
    
    @Test
    public void minEatingSpeed() {
        Assert.assertEquals(output,lc875.minEatingSpeed(piles,H));
    }
}