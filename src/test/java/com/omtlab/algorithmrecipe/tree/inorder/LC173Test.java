package com.omtlab.algorithmrecipe.tree.inorder;

import com.omtlab.algorithmrecipe.common.node.TreeNode;
import com.omtlab.algorithmrecipe.common.util.TreeUtil;
import com.omtlab.algorithmrecipe.twopointer.GenerateTree;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC173Test {
    
    @Test
    public void test1(){
        Integer[] input = {7,3,15,null,null,9,20};
        TreeNode treeNode = new GenerateTree().getRootNode(input);
        String expectedOutput = "3|7|9|15|20|";
        
        LC173 lc173 = new LC173(treeNode);
        String output = "";
        while(lc173.hasNext()){
            output+=lc173.next()+"|";
        }

        Assert.assertEquals(expectedOutput,output);
        
    }

}