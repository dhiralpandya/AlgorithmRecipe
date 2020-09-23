package com.omtlab.algorithmrecipe.binarysearch.rotated;

import org.junit.Assert;
import org.junit.Test;

public class LC81Test {

    LC81 lc81 = new LC81();
    @Test
    public void searchSimpleWay() {

        int a[] = {4,5,6,7,0,1,2};
        for(int i = 0; i < a.length; i++){
            Assert.assertEquals(true,lc81.searchSimpleWay(a,a[i]));
        }

        int b[] = {5,1,2,3,4};

        for(int i = 0; i < b.length; i++){
            Assert.assertEquals(true,lc81.searchSimpleWay(b,b[i]));
        }

        int c[] = {1,1,3,1};
        for(int i = 0; i < c.length; i++){
            Assert.assertEquals(true,lc81.searchSimpleWay(c,c[i]));
        }

        int d[] = {1,3,1,1,1,1};
        for(int i = 0; i < d.length; i++){
            Assert.assertEquals(true,lc81.searchSimpleWay(d,d[i]));
        }
    }
}