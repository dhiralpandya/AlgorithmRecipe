package com.omtlab.algorithmrecipe.backtracking;

import com.omtlab.algorithmrecipe.common.util.MatrixUtil;
import org.junit.Test;

import java.util.List;

public class LC90Test {

    @Test
    public void subsetsWithDup() {
        int[] input = {1,2,2};
        List<List<Integer>> output = new LC90().subsetsWithDup(input);
        MatrixUtil.printListOfList(output);
    }
}