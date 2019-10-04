package com.omtlab.algorithmrecipe.tree.bfs;

import com.omtlab.algorithmrecipe.common.node.TreeNode;
import com.omtlab.algorithmrecipe.twopointer.GenerateTree;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LC102Test {

    @Test
    public void levelOrder() {
        Integer input[] = {3,9,20,null,null,15,7};
        TreeNode root = new GenerateTree().getRootNode(input);
        LC102 lc102 = new LC102();
        for(List<Integer> list:lc102.levelOrder(root)){
            System.out.println(Arrays.toString(list.toArray()));
        }
        
    }
}