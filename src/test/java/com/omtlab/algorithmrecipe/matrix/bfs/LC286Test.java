package com.omtlab.algorithmrecipe.matrix.bfs;

import com.omtlab.algorithmrecipe.common.util.MatrixUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC286Test {

    @Test
    public void wallsAndGates() {
        
        int[][] input = {
                {3,-1,0,1},
                {2,2,1,-1},
                {1,-1,2,-1},
                {0,-1,3,4}
        };
        new LC286().wallsAndGates(input);
        MatrixUtil.printMatrix(input);
        
    }
}