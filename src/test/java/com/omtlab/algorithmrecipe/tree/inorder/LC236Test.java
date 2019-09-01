package com.omtlab.algorithmrecipe.tree.inorder;

import com.omtlab.algorithmrecipe.common.node.TreeNode;
import com.omtlab.algorithmrecipe.common.util.TreeUtil;
import com.omtlab.algorithmrecipe.twopointer.GenerateTree;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC236Test {

    LC236 lc236 = new LC236();
    
    @Test
    public void lowestCommonAncestor() {
        Integer input[] = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = new GenerateTree().getRootNode(input);
        TreeNode node5 = TreeUtil.getNodeByValue(root,5);
        TreeNode node1 = TreeUtil.getNodeByValue(root,1);
        TreeNode node3 = TreeUtil.getNodeByValue(root,3);
        TreeNode node4 = TreeUtil.getNodeByValue(root,4);

        Assert.assertEquals(node3,lc236.lowestCommonAncestor(root,node5,node1));
        Assert.assertEquals(node5,lc236.lowestCommonAncestor(root,node5,node4));

    }
}