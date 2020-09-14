package com.omtlab.algorithmrecipe.array;

import com.omtlab.algorithmrecipe.twopointer.LC977;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LC977Test {

    private LC977 lc977 = new LC977();

    @Test
    void testSortedSquares() {
        int[] input1 = {-4,-1,0,3,10};
        int[] output1 = lc977.sortedSquares(input1);
        int[] expected1 = {0,1,9,16,100};
        assertEquals(Arrays.toString(expected1), Arrays.toString(output1));

        int[] input2 = {-7,-3,2,3,11};
        int[] output2 = lc977.sortedSquares(input2);
        int[] expected2 = {4,9,9,49,121};
        assertEquals(Arrays.toString(expected2), Arrays.toString(output2));
    }

    @Test
    void testSortedSquaresLessSpace() {
        int[] input1 = {-4,-1,0,3,10};
        lc977.sortedSquaresInplaceLessSpace(input1);
        int[] expected1 = {0,1,9,16,100};
        assertEquals(Arrays.toString(expected1), Arrays.toString(input1));

        int[] input2 = {-7,-3,2,3,11};
        lc977.sortedSquaresInplaceLessSpace(input2);
        int[] expected2 = {4,9,9,49,121};
        assertEquals(Arrays.toString(expected2), Arrays.toString(input2));
    }

}