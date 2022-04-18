package com.omtlab.algorithmrecipe.tree.topological;

import com.omtlab.algorithmrecipe.common.util.MatrixUtil;
import org.junit.Test;

import java.util.Arrays;

public class PlaceElementsInMatrixTest {

    @Test
    public void placeElements() {
        PlaceElementsInMatrix placeElementsInMatrix = new PlaceElementsInMatrix();
        int[][] matrix = placeElementsInMatrix.placeElements(3, Arrays.asList("1-LEFT-2",
                "2-RIGHT-3",
                "1-ABOVE-3",
                "3-BELOW-2"));

        MatrixUtil.printMatrix(matrix);
    }
}