package com.omtlab.algorithmrecipe.tree.dijkstra;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC787Test {

    @Test
    public void findCheapestPrice() {
        int[][] input = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0;
        int dst = 2;
        int k =1;
        Assert.assertEquals(200, new LC787().findCheapestPrice(3,input,src,dst,k));
    }

    @Test
    public void findCheapestPrice2() {
        int[][] input = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0;
        int dst = 2;
        int k =0;
        Assert.assertEquals(500, new LC787().findCheapestPrice(3,input,src,dst,k));
    }
}