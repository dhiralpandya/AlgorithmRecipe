package com.omtlab.algorithmrecipe.tree.bfs;

import com.omtlab.algorithmrecipe.common.node.TreeNode;
import com.omtlab.algorithmrecipe.twopointer.GenerateTree;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class LC297Test {

    private Integer[] output;
    private TreeNode rootNode;
    private LC297 lc297 = new LC297();
    
    public LC297Test(Integer[] output,TreeNode rootNode){
        this.output = output;
        this.rootNode = rootNode;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Object[]> data = Lists.newArrayList();

        Integer output1[] = {3,9,20,null,null,15,7};
        TreeNode input1 = new GenerateTree().getRootNode(output1);

        Integer output2[] = {3,9,8,4,0,1,7};
        TreeNode input2 = new GenerateTree().getRootNode(output2);

        Integer output3[] = {3,9,8,4,0,1,7,null,null,null,2,5};
        TreeNode input3 = new GenerateTree().getRootNode(output3);
        
        data.add(Lists.newArrayList(output1,input1).toArray());
        data.add(Lists.newArrayList(output2,input2).toArray());
        data.add(Lists.newArrayList(output3,input3).toArray());
        
        return data;
    }
    
    @Test
    public void serializeBinaryTree() {
        Assert.assertArrayEquals(output,lc297.serializeBinaryTree(rootNode));
    }
}