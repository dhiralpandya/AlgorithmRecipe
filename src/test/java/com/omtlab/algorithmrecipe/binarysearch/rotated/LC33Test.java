package com.omtlab.algorithmrecipe.binarysearch.rotated;

import org.junit.Assert;
import org.junit.Test;

public class LC33Test {

    private LC33 lc33 = new LC33();
    
    @Test
    public void search() {
        
        int a[] = {4,5,6,7,0,1,2};
        
        for(int i = 0; i < a.length; i++){
            Assert.assertEquals(i,lc33.search(a,a[i]));
        }

        int b[] = {5,1,2,3,4};

        for(int i = 0; i < b.length; i++){
            Assert.assertEquals(i,lc33.search(b,b[i]));
        }
    }

    @Test
    public void searchSimpleWay() {

        int a[] = {4,5,6,7,0,1,2};

        for(int i = 0; i < a.length; i++){
            Assert.assertEquals(i,lc33.searchSimpleWay(a,a[i]));
        }

        int b[] = {5,1,2,3,4};

        for(int i = 0; i < b.length; i++){
            Assert.assertEquals(i,lc33.searchSimpleWay(b,b[i]));
        }
    }
}