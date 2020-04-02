package com.omtlab.algorithmrecipe.tree.preorder;

import com.omtlab.algorithmrecipe.twopointer.GenerateTree;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC572Test {

    @Test
    public void isSubtree() {
        GenerateTree generateTree = new GenerateTree();
        Integer[] tree1 = {3,4,5,1,2};
        Integer[] subtree1 = {4,1,2};
        Assert.assertTrue(new LC572().isSubtree(generateTree.getRootNode(tree1), generateTree.getRootNode(subtree1)));

        Integer[] tree2 = {3,4,5,1,2, null, null,null,null,0,null};
        Integer[] subtree2 = {4,1,2};
        Assert.assertFalse(new LC572().isSubtree(generateTree.getRootNode(tree2), generateTree.getRootNode(subtree2)));
    }
}