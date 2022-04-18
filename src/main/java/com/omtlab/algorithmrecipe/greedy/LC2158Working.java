package com.omtlab.algorithmrecipe.greedy;

import lombok.AllArgsConstructor;

import java.util.*;

/**
 * 2158. Amount of New Area Painted Each Day
 * <p>
 * There is a long and thin painting that can be represented by a number line. You are given a 0-indexed 2D integer array paint of length n, where paint[i] = [starti, endi]. This means that on the ith day you need to paint the area between starti and endi.
 * <p>
 * Painting the same area multiple times will create an uneven painting so you only want to paint each area of the painting at most once.
 * <p>
 * Return an integer array worklog of length n, where worklog[i] is the amount of new area that you painted on the ith day.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: paint = [[1,4],[4,7],[5,8]]
 * Output: [3,3,1]
 * Explanation:
 * On day 0, paint everything between 1 and 4.
 * The amount of new area painted on day 0 is 4 - 1 = 3.
 * On day 1, paint everything between 4 and 7.
 * The amount of new area painted on day 1 is 7 - 4 = 3.
 * On day 2, paint everything between 7 and 8.
 * Everything between 5 and 7 was already painted on day 1.
 * The amount of new area painted on day 2 is 8 - 7 = 1.
 * Example 2:
 * <p>
 * <p>
 * Input: paint = [[1,4],[5,8],[4,7]]
 * Output: [3,3,1]
 * Explanation:
 * On day 0, paint everything between 1 and 4.
 * The amount of new area painted on day 0 is 4 - 1 = 3.
 * On day 1, paint everything between 5 and 8.
 * The amount of new area painted on day 1 is 8 - 5 = 3.
 * On day 2, paint everything between 4 and 5.
 * Everything between 5 and 7 was already painted on day 1.
 * The amount of new area painted on day 2 is 5 - 4 = 1.
 * Example 3:
 * <p>
 * <p>
 * Input: paint = [[1,5],[2,4]]
 * Output: [4,0]
 * Explanation:
 * On day 0, paint everything between 1 and 5.
 * The amount of new area painted on day 0 is 5 - 1 = 4.
 * On day 1, paint nothing because everything between 2 and 4 was already painted on day 0.
 * The amount of new area painted on day 1 is 0.
 * <p>
 * <p>
 * FIND DETAILS IN DOCUMENTATION LC2158.pdf
 */
public class LC2158Working {

    public int[] amountPainted(int[][] paint) {
        int totalDays = paint.length;

        int[] output = new int[totalDays];

        Queue<Interval> fifo = new LinkedList<>();
        for (int[] inval : paint) {
            Interval interval = new Interval(inval[0], inval[1]);
            fifo.add(interval);
        }


        int index = 0;
        Integer previousEnd = null;
        Queue<Interval> remainingInterval = new PriorityQueue<>();
        while (!fifo.isEmpty()) {
            Interval interval = fifo.poll();

            if (previousEnd == null) {
                previousEnd = interval.end;
                output[index] = interval.end - interval.start;
                index++;
            } else {
                // [1,4],[4,7]
                if (previousEnd == interval.start) {
                    previousEnd = interval.end;
                    output[index] = interval.end - interval.start;
                    index++;
                    // [5,8],[6,10]
                } else if (previousEnd > interval.start
                        && previousEnd < interval.end) {
                    output[index] = interval.end - previousEnd;
                    previousEnd = interval.end;
                    index++;
                    // IMP [1,4],[5,8]
                } else if (previousEnd < interval.start) {
                    // Most IMP STEP
                    remainingInterval.add(new Interval(previousEnd, interval.start));
                    previousEnd = interval.end;
                    output[index] = interval.end - interval.start;
                    index++;
                    continue;
                    // [1,5],[2,4]
                } else if (previousEnd > interval.start
                        && previousEnd > interval.end) {
                    int count = calculate(remainingInterval, interval);
                    output[index] = count;
                    index++;
                    continue;
                }
            }

        }


        return output;
    }


    private int calculate(Queue<Interval> remaining, Interval interval) {
        int count = 0;

        List<Interval> temp = new ArrayList<>();
        // All before
        while (!remaining.isEmpty()
                && remaining.peek().end <= interval.start) {
            temp.add(remaining.poll());
        }

        // Merge
        while (!remaining.isEmpty()
                && remaining.peek().start < interval.end) {
            Interval remInt = remaining.poll();
            int start = Math.max(remInt.start, interval.start);
            int end = Math.min(remInt.end, interval.end);
            count += end - start;

            if (interval.end < remInt.end) { // Unused area
                temp.add(new Interval(end, remInt.end));
            }
            if (interval.end > remInt.end) { // keep finding
                interval = new Interval(remInt.end, interval.end);
            }
        }

        // All other
        remaining.addAll(temp);

        return count;
    }


    @AllArgsConstructor
    private static class Interval implements Comparable<Interval> {
        int start;
        int end;

        @Override
        public int compareTo(Interval o) {
            return start - o.start;
        }
    }
}
