package com.omtlab.algorithmrecipe.set;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * See test class for more details
 */
public class SubSetExample {

    public List<Integer> returnIntegersBetween(List<Integer> integers, int startInclusive, int endExclusive) {
        SortedSet<Integer> sortedSet = new TreeSet<>();
        sortedSet.addAll(integers);

        return new ArrayList<>(sortedSet.subSet(startInclusive, endExclusive));
    }

    public List<String> returnWordsBetween(List<String> words, String startInclusive, String endExclusive) {
        SortedSet<String> sortedSet = new TreeSet<>();
        sortedSet.addAll(words);

        return new ArrayList<>(sortedSet.subSet(startInclusive, endExclusive));
    }

    public List<String> returnWordsStartsWithTailSet(List<String> words, String startInclusive) {
        SortedSet<String> sortedSet = new TreeSet<>();
        sortedSet.addAll(words);

        return new ArrayList<>(sortedSet.tailSet(startInclusive));
    }
}
