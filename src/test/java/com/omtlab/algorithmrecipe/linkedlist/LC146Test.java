package com.omtlab.algorithmrecipe.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC146Test {
    
    
    @Test
    public void testLRU(){
        LC146.LRU lru = new LC146.LRU(2);
        lru.put(1,1);
        lru.put(2,2);
        Assert.assertEquals(1, lru.get(1));
        lru.put(3,3);
        Assert.assertEquals(-1, lru.get(2));
        lru.put(4,4);
        Assert.assertEquals(-1, lru.get(1));
        Assert.assertEquals(3, lru.get(3));
        Assert.assertEquals(4, lru.get(4));
        
    }

}