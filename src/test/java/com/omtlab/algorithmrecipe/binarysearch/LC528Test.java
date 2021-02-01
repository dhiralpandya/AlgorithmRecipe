package com.omtlab.algorithmrecipe.binarysearch;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LC528Test {

    @Test
    public void pickIndex() {
        int[] input1 = {1, 9};
        LC528 lc528 = new LC528(input1);

        Map<Integer, Integer> indexAndCount = new HashMap<>();

        for (int i = 0; i < 1000; i++) {
            int index = lc528.pickIndex();
            int count = indexAndCount.getOrDefault(index, 0) + 1;
            indexAndCount.put(index, count);
        }

        indexAndCount.keySet().forEach(key ->
                System.out.println("For index[" + key + "] % of occurrence: "
                        + (indexAndCount.get(key) / 1000d) * 100));
    }

    @Test
    public void pickIndex2() {
        int[] input1 = {1, 4, 5};
        LC528 lc528 = new LC528(input1);

        Map<Integer, Integer> indexAndCount = new HashMap<>();

        for (int i = 0; i < 1000; i++) {
            int index = lc528.pickIndex();
            int count = indexAndCount.getOrDefault(index, 0) + 1;
            indexAndCount.put(index, count);
        }

        indexAndCount.keySet().forEach(key ->
                System.out.println("For index[" + key + "] % of occurrence: "
                        + (indexAndCount.get(key) / 1000d) * 100));
    }
}