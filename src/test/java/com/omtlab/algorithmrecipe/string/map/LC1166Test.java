package com.omtlab.algorithmrecipe.string.map;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC1166Test {
    
    @Test
    public void fileSystem() {
        LC1166.FileSystem  fileSystem = new LC1166.FileSystem();
        Assert.assertTrue(fileSystem.createPath("/leet", 1));
        Assert.assertTrue(fileSystem.createPath("/leet/code",2));
        Assert.assertFalse(fileSystem.createPath("/leet/code",2));
        Assert.assertFalse(fileSystem.createPath("/c/d",2));
        Assert.assertEquals(-1,fileSystem.get("/c"));
        Assert.assertEquals(2 , fileSystem.get("/leet/code"));
        Assert.assertEquals(1 , fileSystem.get("/leet"));
    }

}