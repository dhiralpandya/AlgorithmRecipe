package com.omtlab.algorithmrecipe.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 715. Range Module
 * <p>
 * A Range Module is a module that tracks ranges of numbers. Your task is to design and implement the following interfaces in an efficient manner.
 * <p>
 * addRange(int left, int right) Adds the half-open interval [left, right), tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval [left, right) that are not already tracked.
 * queryRange(int left, int right) Returns true if and only if every real number in the interval [left, right) is currently being tracked.
 * removeRange(int left, int right) Stops tracking every real number currently being tracked in the interval [left, right).
 * Example 1:
 * addRange(10, 20): null
 * removeRange(14, 16): null
 * queryRange(10, 14): true (Every number in [10, 14) is being tracked)
 * queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
 * queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked, despite the remove operation)
 * Note:
 * <p>
 * A half open interval [left, right) denotes all real numbers left <= x < right.
 * 0 < left < right < 10^9 in all calls to addRange, queryRange, removeRange.
 * The total number of calls to addRange in a single test case is at most 1000.
 * The total number of calls to queryRange in a single test case is at most 5000.
 * The total number of calls to removeRange in a single test case is at most 1000.
 */
public class LC715 {

    private List<Interval> ranges = new ArrayList<>();

    public void addRange(int start, int end) {
        Set<Interval> newSortedRanges = new TreeSet<>();
        int index = 0;
        // Add all intervals before this new one.
        while (index < ranges.size() && ranges.get(index).end < start) {
            newSortedRanges.add(ranges.get(index));
            index++;
        }

        // Merge intervals
        while (index < ranges.size() && end >= ranges.get(index).start) {
            start = Math.min(start, ranges.get(index).start);
            end = Math.max(end, ranges.get(index).end);
            index++;
        }
        newSortedRanges.add(new Interval(start, end));

        // Add remaining intervals
        while (index < ranges.size()) {
            newSortedRanges.add(ranges.get(index));
            index++;
        }

        ranges = new ArrayList<>(newSortedRanges);
    }

    public boolean queryRange(int start, int end) {
        for (Interval interval : ranges) {
            if (interval.start <= start && end <= interval.end) {
                return true;
            }
        }
        return false;
    }

    public void removeRange(int start, int end) {
        Set<Interval> newSortedRanges = new TreeSet<>();
        int index = 0;

        // All non overlapping
        while (index < ranges.size() && ranges.get(index).end < start) {
            newSortedRanges.add(ranges.get(index));
            index++;
        }

        // Brake down
        while (index < ranges.size() && end >= ranges.get(index).start) {
            if (ranges.get(index).start < start) {
                newSortedRanges.add(new Interval(ranges.get(index).start, start));
            }

            if (end < ranges.get(index).end) {
                newSortedRanges.add(new Interval(end, ranges.get(index).end));
            }

            index++;
        }

        // Remaining
        while (index < ranges.size()) {
            newSortedRanges.add(ranges.get(index));
            index++;
        }

        ranges = new ArrayList<>(newSortedRanges);
    }


    public static class Interval implements Comparable<Interval> {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval that) {
            if (this.end == that.end) {
                return this.start - that.start;
            }
            return this.end - that.end;
        }
    }

}
