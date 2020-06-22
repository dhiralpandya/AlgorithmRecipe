
package com.omtlab.algorithmrecipe.priorityqueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC621Test {

    private LC621 lc621 = new LC621();

    @Test
    void leastIntervalTest() {
        char[] input1 = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n1 = 2;
        int output1 = 8;
        assertEquals(output1, lc621.leastInterval(input1, n1));

        char[] input2 = {'A','A','A','B','B','B'};
        int n2 = 0;
        int output2 = 6;
        assertEquals(output2, lc621.leastInterval(input2, n2));

        char[] input3 = {'A','B','C','D','E','A','B','C','D','E'};
        int n3 = 4;
        int output3 = 10;
        assertEquals(output3, lc621.leastInterval(input3, n3));
    }

}