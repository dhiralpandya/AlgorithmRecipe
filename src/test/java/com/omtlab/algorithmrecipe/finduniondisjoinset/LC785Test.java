package com.omtlab.algorithmrecipe.finduniondisjoinset;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC785Test {

    @Test
    public void isBipartite() {
       int[][] graph =  {{1,3}, {0,2}, {1,3}, {0,2}};
       Assert.assertTrue(new LC785().isBipartite(graph));

       int[][] graph2 =  {{1,2,3}, {0,2}, {0,1,3}, {0,2}};
       Assert.assertFalse(new LC785().isBipartite(graph2));
    }
}