package com.omtlab.algorithmrecipe.tree.inorder;

import com.omtlab.algorithmrecipe.twopointer.GenerateTree;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class LC298Test {

    LC298 lc298;
    GenerateTree generateTree = new GenerateTree();
    @BeforeEach
    void setup() {
        lc298 = new LC298();
    }


    @Test
    void longestConsecutive() {
        Integer[] input1 = {1, null, 3, 2, 4, null, null, null, 5};
        assertEquals(3, lc298.longestConsecutive(generateTree.getRootNode(input1)));
    }

    @Test
    void longestConsecutive2() {
        Integer[] input2 = {2, null, 3, 2, null, 1, null};
        assertEquals(2, lc298.longestConsecutive(generateTree.getRootNode(input2)));
    }
}