package com.omtlab.algorithmrecipe.recursion;

import com.omtlab.algorithmrecipe.common.util.MatrixUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC39Test {

    LC39 lc39 = new LC39();
    
    @Test
    public void combinationSum() {
        int[] input1 = {2,3,6,7};
        int target = 7;
        MatrixUtil.printListOfList(lc39.combinationSum(input1, target));


        int[] input2 = {2,3,5};
        int target2 = 8;
        MatrixUtil.printListOfList(lc39.combinationSum(input2, target2));
    }
}