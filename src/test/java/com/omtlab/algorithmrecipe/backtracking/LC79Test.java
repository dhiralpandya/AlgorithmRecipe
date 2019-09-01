package com.omtlab.algorithmrecipe.backtracking;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC79Test {

    @Test
    public void exist() {
        char[][] input = {
                            {'A','B','C','E'},
                            {'S','F','C','S'},
                            {'A','D','E','E'}
                        };

        Assert.assertTrue(new LC79().exist(input,"ABCCED"));
        Assert.assertTrue(new LC79().exist(input,"SEE"));
        Assert.assertFalse(new LC79().exist(input,"ABCB"));
    }
}