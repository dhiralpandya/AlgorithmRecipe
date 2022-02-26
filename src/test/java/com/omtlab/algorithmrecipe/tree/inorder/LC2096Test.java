package com.omtlab.algorithmrecipe.tree.inorder;

import com.omtlab.algorithmrecipe.twopointer.GenerateTree;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LC2096Test {

    @Test
    public void getDirections() {
        Integer[] input1 = {5, 1, 2, 3, null, 6, 4};
        String actual1 = new LC2096()
                .getDirections(new GenerateTree().getRootNode(input1), 3, 6);
        Assertions.assertThat(actual1).isEqualTo("UURL");
        Integer[] input2 = {2, 1};
        String actual2 = new LC2096()
                .getDirections(new GenerateTree().getRootNode(input2), 2, 1);
        Assertions.assertThat(actual2).isEqualTo("L");
    }
}