package com.omtlab.algorithmrecipe.quicksort;

import com.omtlab.algorithmrecipe.common.util.MatrixUtil;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC973Test {

    private LC973 lc973 = new LC973();

    @Test
    void kClosest() {
        Integer[][] input = {{1,3},{-2,2}};
        Integer[][] output = lc973.kClosest(input, 1);
        MatrixUtil.printMatrix(output);
    }

    @Test
    void kClosest2() {
        Integer[][] input = {{3,3},{5,-1},{-2,4}};
        Integer[][] output = lc973.kClosest(input, 2);
        MatrixUtil.printMatrix(output);
    }
}