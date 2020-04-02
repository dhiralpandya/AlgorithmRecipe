package com.omtlab.algorithmrecipe.tree.bfs;

import com.omtlab.algorithmrecipe.common.node.TreeNode;
import com.omtlab.algorithmrecipe.twopointer.GenerateTree;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC101Test {

    @Test
    public void isSymmetric() {
        GenerateTree gn = new GenerateTree();

        Integer[] n1= {1,2,2,3,4,4,3};
        TreeNode tn1 = gn.getRootNode(n1);

        Assert.assertTrue(new LC101().isSymmetric(tn1));

        Integer[] n2 = {1,2,2,null,3,null,3};
        TreeNode tn2 = gn.getRootNode(n2);

        Assert.assertFalse(new LC101().isSymmetric(tn2));

    }
}