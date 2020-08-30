package com.omtlab.algorithmrecipe.greedy;

import com.google.common.collect.Lists;
import com.omtlab.algorithmrecipe.greedy.GFGMinNoofPlatformsRequiredUsingMap.Train;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class GFGMinNoofPlatformsRequiredUsingMapTest {

    private GFGMinNoofPlatformsRequiredUsingMap algo = new GFGMinNoofPlatformsRequiredUsingMap();

    @Test
    public void minPlatforms() {
        List<Train> input = Lists.newArrayList(
                new Train(9.00f, 9.10f),
                new Train(15.00f, 19.00f),
                new Train(9.40f, 12.00f),
                new Train(11.00f, 11.30f),
                new Train(18.00f, 20.10f),
                new Train(9.50f, 11.20f)
        );
        int output = algo.minPlatforms(input);
        Assertions.assertEquals(3, output);
    }
}