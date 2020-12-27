package com.omtlab.algorithmrecipe.bit;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Test;

public class GFGTwoNumOddTimesTest {

    private GFGTwoNumOddTimes gfg = new GFGTwoNumOddTimes();

    @Test
    public void getTwoOddOccurrencesNumbers() {
        int[] input1 = {12, 23, 34, 12, 12, 23, 12, 45};
        Assertions.assertThat(gfg.getTwoOddOccurrencesNumbers(input1)).hasSameElementsAs(Lists.newArrayList(34, 45));
        int[] input2 = {4, 4, 100, 5000, 4, 4, 4, 4, 100, 100};
        Assertions.assertThat(gfg.getTwoOddOccurrencesNumbers(input2)).hasSameElementsAs(Lists.newArrayList(100, 5000));
        int[] input3 = {10, 20};
        Assertions.assertThat(gfg.getTwoOddOccurrencesNumbers(input3)).hasSameElementsAs(Lists.newArrayList(10, 20));
    }
}