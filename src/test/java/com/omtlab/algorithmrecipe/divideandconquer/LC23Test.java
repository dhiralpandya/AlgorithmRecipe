package com.omtlab.algorithmrecipe.divideandconquer;

import com.google.common.collect.Lists;
import com.omtlab.algorithmrecipe.common.node.LinkNode;
import com.omtlab.algorithmrecipe.common.util.NodeUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LC23Test {

    @Test
    public void getMergedNode() {
        List<LinkNode> input = Lists.newArrayList(NodeUtil.generateLinkNodeIntegerValue("1->4->5")
                ,NodeUtil.generateLinkNodeIntegerValue("1->3->4")
                ,NodeUtil.generateLinkNodeIntegerValue("2->6")
        );
        LinkNode output = new LC23().getMergedNode(input);
        String expectedOutput = "1->1->2->3->4->4->5->6";
        String outputString = "";
        while (output != null ){
            outputString+=output.value+"->";
            output = output.next;
        }
        Assert.assertEquals(expectedOutput,outputString.subSequence(0,outputString.length()-2));
    }

    @Test
    public void getMergedNode2() {
        List<LinkNode> input = Lists.newArrayList(NodeUtil.generateLinkNodeIntegerValue("10->14->15")
                ,NodeUtil.generateLinkNodeIntegerValue("1->3->4")
                ,NodeUtil.generateLinkNodeIntegerValue("2->6"));
        LinkNode output = new LC23().getMergedNode(input);
        String expectedOutput = "1->2->3->4->6->10->14->15";
        String outputString = "";
        while (output != null ){
            outputString+=output.value+"->";
            output = output.next;
        }
        Assert.assertEquals(expectedOutput,outputString.subSequence(0,outputString.length()-2));
    }
}