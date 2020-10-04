package com.omtlab.algorithmrecipe.tree.inorder;

import com.google.common.collect.Lists;
import com.omtlab.algorithmrecipe.common.node.TreeNode;
import com.omtlab.algorithmrecipe.common.util.TreeUtil;
import com.omtlab.algorithmrecipe.twopointer.GenerateTree;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LC1110Test {

    @Test
    void delNodes() {
        Integer[] nodes = {1,2,3,4,5,6,7};
        TreeNode root = new GenerateTree().getRootNode(nodes);
        List<Integer> nodeToDelete = Lists.newArrayList(3, 5);
        List<TreeNode> output = new LC1110().delNodes(root, nodeToDelete);
        output.forEach(TreeUtil::printTreeNode);
    }
}