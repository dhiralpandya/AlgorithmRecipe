package com.omtlab.algorithmrecipe.priorityqueue;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC332Test {

    @Test
    public void findItinerary1() {
        String[][] inputArray = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        String[] outputArray = {"JFK", "MUC", "LHR", "SFO", "SJC"};

        List<List<String>> input = new ArrayList<>();
        for (String[] s : inputArray) {
            input.add(Arrays.asList(s));
        }

        List<String> output = new LC332().findItinerary(input);
        Assertions.assertThat(output).isEqualTo(Arrays.asList(outputArray));
    }

    @Test
    public void findItinerary2() {
        String[][] inputArray = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        String[] outputArray = {"JFK", "ATL", "JFK", "SFO", "ATL", "SFO"};

        List<List<String>> input = new ArrayList<>();
        for (String[] s : inputArray) {
            input.add(Arrays.asList(s));
        }

        List<String> output = new LC332().findItinerary(input);
        Assertions.assertThat(output).isEqualTo(Arrays.asList(outputArray));
    }
}