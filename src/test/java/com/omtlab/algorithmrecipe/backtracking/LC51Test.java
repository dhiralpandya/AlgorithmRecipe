package com.omtlab.algorithmrecipe.backtracking;

import com.omtlab.algorithmrecipe.common.util.MatrixUtil;
import org.junit.Test;

public class LC51Test {

    @Test
    public void solveNQueens() {
        MatrixUtil.printListOfList(new LC51().solveNQueensIntegerOutput(4));
        MatrixUtil.printListOfListNewLine(new LC51().solveNQueens(4));
    }
}