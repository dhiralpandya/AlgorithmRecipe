package com.omtlab.algorithmrecipe.tree.preorder;

import com.omtlab.algorithmrecipe.twopointer.GenerateTree;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC124Test {

    private LC124 lc124;
    private GenerateTree generateTree = new GenerateTree();

    @BeforeEach
    void setUp() {
        lc124 = new LC124();
    }

    @Test
    void testMaxPathSum() {
        Integer[] input1 = {1,2,3};
        int output1 = lc124.maxPathSum(generateTree.getRootNode(input1));
        Assert.assertEquals(6, output1);

        Integer[] input2 = {-10,9,20,null,null,15,7};
        int output2 = lc124.maxPathSum(generateTree.getRootNode(input2));
        Assert.assertEquals(42, output2);
    }
}