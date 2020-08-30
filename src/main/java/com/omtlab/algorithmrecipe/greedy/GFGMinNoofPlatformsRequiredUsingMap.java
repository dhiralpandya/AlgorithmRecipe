package com.omtlab.algorithmrecipe.greedy;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 * <p>
 * Given arrival and departure times of all trains that reach a railway station,
 * the task is to find the minimum number of platforms required for the railway station so that no train waits.
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
public class GFGMinNoofPlatformsRequiredUsingMap {

    public int minPlatforms(List<Train> trains) {
        Character typeArrival = 'A';
        Character typeDeparture = 'D';

        Map<Float, Character> sortedByTime = new TreeMap();
        trains.forEach(train -> {
            sortedByTime.put(train.arrival, typeArrival);
            sortedByTime.put(train.departure, typeDeparture);
        });

        int currentTotalNumberOfPlatform = 0;
        int maxPlatformTillNow = 0;

        for (Entry<Float, Character> entry : sortedByTime.entrySet()) {
            if (typeArrival == entry.getValue()) {
                currentTotalNumberOfPlatform++;
            } else {
                currentTotalNumberOfPlatform--;
            }

            maxPlatformTillNow = Math.max(maxPlatformTillNow, currentTotalNumberOfPlatform);
        }

        return maxPlatformTillNow;
    }

    @AllArgsConstructor
    public static class Train implements Comparable<Train> {
        public float arrival;
        public float departure;

        @Override
        public int compareTo(Train o) {
            return (int) (this.arrival - o.arrival);
        }
    }
}
