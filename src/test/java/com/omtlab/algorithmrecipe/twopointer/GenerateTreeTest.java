package com.omtlab.algorithmrecipe.twopointer;

import com.omtlab.algorithmrecipe.common.util.TreeUtil;
import org.junit.Test;

public class GenerateTreeTest {

    @Test
    public void getRootNode() {
        Integer a[] = {3,9,20,null,null,15,7};
        TreeUtil.printTreeNode(new GenerateTree().getRootNode(a));
    }

    @Test
    public void getRootNode2() {
        Integer a[] = {3,9,8,4,0,1,7};
        TreeUtil.printTreeNode(new GenerateTree().getRootNode(a));
    }

    @Test
    public void getRootNode3() {
        Integer a[] = {3,9,8,4,0,1,7,null,null,null,2,5};
        TreeUtil.printTreeNode(new GenerateTree().getRootNode(a));
    }
}