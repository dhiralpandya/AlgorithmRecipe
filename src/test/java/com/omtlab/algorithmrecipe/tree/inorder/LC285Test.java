package com.omtlab.algorithmrecipe.tree.inorder;

import com.omtlab.algorithmrecipe.common.node.TreeNode;
import com.omtlab.algorithmrecipe.twopointer.GenerateTree;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC285Test {

    @Test
    public void inorderSuccessor() {
        Integer a[] = {8,6,10,4,7,9,12};
        TreeNode root = new GenerateTree().getRootNode(a);
        TreeNode tn = new TreeNode();
        tn.integerValue = 4;
        LC285 lc285 = new LC285();
        Assert.assertEquals((Integer) 6,(Integer)lc285.inorderSuccessor(root,tn).integerValue);
        tn.integerValue = 10;
        Assert.assertEquals((Integer) 12,(Integer)lc285.inorderSuccessor(root,tn).integerValue);
    }
}