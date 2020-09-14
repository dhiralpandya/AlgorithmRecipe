package com.omtlab.algorithmrecipe.array;

import com.omtlab.algorithmrecipe.array.evenodd.LC280;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class LC280Test {

    @Test
    public void wiggleSort() {
        int a[] = {3,5,2,1,6,4};
        new LC280().wiggleSort(a);
        System.out.println(ArrayUtils.toString(a));
    }
}