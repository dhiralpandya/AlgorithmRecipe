package com.omtlab.algorithmrecipe.linkedlist;

import com.omtlab.algorithmrecipe.common.node.LinkNode;
import com.omtlab.algorithmrecipe.common.util.NodeUtil;
import com.omtlab.algorithmrecipe.divideandconquer.LC23;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC206Test {

    @Test
    public void reverse() {
        LinkNode input = NodeUtil.generateLinkNodeIntegerValue("1->2->3->4->5");

        LinkNode output =new LC206().reverse(input);
        String expectedOutput = "5->4->3->2->1";
        String outputString = "";
        while (output != null ){
            outputString+=output.value+"->";
            output = output.next;
        }
        Assert.assertEquals(expectedOutput,outputString.subSequence(0,outputString.length()-2));

    }
}