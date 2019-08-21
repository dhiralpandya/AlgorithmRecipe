package com.omtlab.algorithmrecipe.tree.preorder;

import com.omtlab.algorithmrecipe.common.node.TreeNode;
import com.omtlab.algorithmrecipe.twopointer.GenerateTree;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC404Test {

    @Test
    public void total() {
        Integer[] a = {3,9,8,4,0,1,7};
        TreeNode root = new GenerateTree().getRootNode(a);
        int total = new LC404().total(root);
        Assert.assertEquals(5,total);
    }
}