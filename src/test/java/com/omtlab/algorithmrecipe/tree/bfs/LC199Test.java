package com.omtlab.algorithmrecipe.tree.bfs;

import com.omtlab.algorithmrecipe.common.node.TreeNode;
import com.omtlab.algorithmrecipe.twopointer.GenerateTree;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LC199Test {

    @Test
    void rightSideView() {
        Integer[] input = {1,2,3,null,5,null,4};
        LC199 lc199 = new LC199();
        TreeNode node = new GenerateTree().getRootNode(input);
        List<Integer> output = lc199.rightSideView(node);
        System.out.println(Arrays.toString(output.toArray(new Integer[0])));
    }
}