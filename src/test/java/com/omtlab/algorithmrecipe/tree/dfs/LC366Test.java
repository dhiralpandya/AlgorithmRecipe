package com.omtlab.algorithmrecipe.tree.dfs;

import com.omtlab.algorithmrecipe.common.node.TreeNode;
import com.omtlab.algorithmrecipe.twopointer.GenerateTree;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class LC366Test {

    @Test
    public void collectLeafNodes() {
        Integer input[] = {1, 2, 3, 4, 5};
        TreeNode root = new GenerateTree().getRootNode(input);
        List<List<Integer>> output = new LC366().collectLeafNodes(root);
        for (List<Integer> data : output) {
            System.out.println(data.stream().map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }
    }
}