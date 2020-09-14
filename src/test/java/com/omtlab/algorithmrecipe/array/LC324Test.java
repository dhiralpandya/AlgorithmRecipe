package com.omtlab.algorithmrecipe.array;

import com.omtlab.algorithmrecipe.quicksort.LC324;
import org.junit.Test;

import java.util.Arrays;

public class LC324Test {

    LC324 lc324 = new LC324();
    
    @Test
    public void wiggleSort() {
        int i[] = {1, 5, 1, 1, 6, 4, 8};
        lc324.wiggleSort(i);
        System.out.println(Arrays.toString(i));
    }
}