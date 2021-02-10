package com.omtlab.algorithmrecipe.tree.bfs;

import com.omtlab.algorithmrecipe.common.node.TreeNode;
import com.omtlab.algorithmrecipe.twopointer.GenerateTree;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LC226Test {
    final GenerateTree generateTree = new GenerateTree();

    @Test
    public void invertTree() {
        Integer[] input = {4, 2, 7, 1, 3, 6, 9};
        TreeNode treeNode = generateTree.getRootNode(input);
        treeNode = new LC226().invertTree(treeNode);
        Integer[] output = new LC297().serializeBinaryTree(treeNode);
        Integer[] expected = {4, 7, 2, 9, 6, 3, 1};
        Assertions.assertThat(output).isEqualTo(expected);
    }
}