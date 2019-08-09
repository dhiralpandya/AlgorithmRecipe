package com.omtlab.algorithmrecipe.tree.inorder;

import com.google.common.collect.Lists;
import com.omtlab.algorithmrecipe.common.node.TreeNode;
import com.omtlab.algorithmrecipe.twopointer.GenerateTree;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LC98Test {



    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Object[]> data = Lists.newArrayList();
        
        Integer a[] = {5,1,4,null,null,3,6};
        data.add(Lists.newArrayList(new GenerateTree().getRootNode(a),false).toArray());

        Integer b[] = {2,1,3};
        data.add(Lists.newArrayList(new GenerateTree().getRootNode(b),true).toArray());

        Integer c[] = {1,1};
        data.add(Lists.newArrayList(new GenerateTree().getRootNode(c),false).toArray());

        Integer d[] = {Integer.MAX_VALUE};
        data.add(Lists.newArrayList(new GenerateTree().getRootNode(d),true).toArray());

        return data;
    }

    private  TreeNode root; 
    private  boolean output;
    private LC98 lc98 = new LC98();
    
    public LC98Test(TreeNode root,boolean output ){
        this.output = output;
        this.root = root;
    }
    
    @Test
    public void isBST() {
        Assert.assertEquals(output,lc98.isBST(root));
    }
}