package com.omtlab.algorithmrecipe.sortingalgorithms.bucket;

import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * 539. Minimum Time Difference
 * <p>
 * Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: timePoints = ["23:59","00:00"]
 * Output: 1
 * Example 2:
 * <p>
 * Input: timePoints = ["00:00","23:59","00:00"]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= timePoints.length <= 2 * 104
 * timePoints[i] is in the format "HH:MM".
 */
public class LC539 {
    public int findMinDifference(List<String> timePoints) {
        boolean[] allTimes = new boolean[24 * 60];
        for (String time : timePoints) {
            // Duplicate
            if (allTimes[getMin(time)]) {
                return 0;
            }

            allTimes[getMin(time)] = true;
        }

        int first = Integer.MAX_VALUE;
        int last = 0;
        int previous = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 24 * 60; i++) {
            if (allTimes[i]) {
                if (first == Integer.MAX_VALUE) {
                    first = i;
                } else if (first != Integer.MAX_VALUE) {
                    min = Math.min(min, i - previous);
                }
                previous = i;
                last = i; // Keep updating last
            }
        }

        return Math.min(min, 24 * 60 - last + first);
    }

    private int getMin(String time) {
        int hr = parseInt(time.split(":")[0]);
        int min = parseInt(time.split(":")[1]);

        return hr * 60 + min;
    }
}
