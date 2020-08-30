package com.omtlab.algorithmrecipe.greedy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 * <p>
 * Given arrival and departure times of all trains that reach a railway station, the task is to find the minimum number of platforms required for the railway station so that no train waits.
 * We are given two arrays which represent arrival and departure times of trains that stop.
 * <p>
 * Examples:
 * <p>
 * Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}
 * dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
 * Output: 3
 * Explantion: There are at-most three trains at a time (time between 11:00 to 11:20)
 * <p>
 * Input: arr[] = {9:00, 9:40}
 * dep[] = {9:10, 12:00}
 * Output: 1
 * Explantion: Only one platform is needed.
 */
public class GFGMinNoofPlatformsRequired {

    public int minPlatforms(List<TrainInterval> trainIntervals) {
        //Note: Sorting by start time. TrainInterval implements Comparable
        Collections.sort(trainIntervals);
        float lastEndTime = trainIntervals.get(0).end;
        int minPlatForms = 0;
        for (int index = 1; index < trainIntervals.size(); index++) {
            if (lastEndTime > trainIntervals.get(index).start) {
                minPlatForms++;
            }
            lastEndTime = Math.max(lastEndTime, trainIntervals.get(index).end);
        }

        return minPlatForms == 0 ? 1 : minPlatForms;
    }

    @Data
    @AllArgsConstructor
    public static class TrainInterval implements Comparable<TrainInterval> {
        float start;
        float end;

        @Override
        public int compareTo(TrainInterval o) {
            return (int) (start - o.start);
        }
    }
}
