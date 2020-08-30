package com.omtlab.algorithmrecipe.greedy;

import com.google.common.collect.Lists;
import com.omtlab.algorithmrecipe.greedy.GFGMinNoofPlatformsRequired.TrainInterval;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GFGMinNoofPlatformsRequiredTest {

    private GFGMinNoofPlatformsRequired algo = new GFGMinNoofPlatformsRequired();

    @Test
    public void minPlatforms() {
        List<TrainInterval> input = Lists.newArrayList(
                new TrainInterval(9.00f, 9.10f),
                new TrainInterval(15.00f, 19.00f),
                new TrainInterval(9.40f, 12.00f),
                new TrainInterval(11.00f, 11.30f),
                new TrainInterval(18.00f, 20.10f),
                new TrainInterval(9.50f, 11.20f)
        );
        int output = algo.minPlatforms(input);
        assertEquals(3, output);

    }
}