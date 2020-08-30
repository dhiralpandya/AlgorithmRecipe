package com.omtlab.algorithmrecipe.greedy;

import lombok.Value;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 253. Meeting Rooms II
 * <p>
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * <p>
 * Example 1:
 * <p>
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [[7,10],[2,4]]
 * Output: 1
 */
public class LC253UsingMap {

    public int minRooms(List<Meeting> meetings) {

        Map<Integer, Integer> timeToCounterMap = new TreeMap<>();
        meetings.forEach(meeting -> {
            timeToCounterMap.put(meeting.getStart(), 1);
            timeToCounterMap.put(meeting.getEnd(), -1);
        });

        int maxRoomsTillNow = 0;
        int currentMaxRoomCount = 0;
        for (Integer counter : timeToCounterMap.values()) {
            currentMaxRoomCount += counter;
            maxRoomsTillNow = Math.max(maxRoomsTillNow, currentMaxRoomCount);
        }
        return maxRoomsTillNow;
    }

    @Value
    public static class Meeting {
        int start;
        int end;
    }
}

