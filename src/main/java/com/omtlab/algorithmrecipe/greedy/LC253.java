package com.omtlab.algorithmrecipe.greedy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.List;

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
public class LC253 {

    public int minRooms(List<MeetingInterval> meetings) {

        // Note: Sorting by start time, MeetingInterval has its own Comparable
        Collections.sort(meetings);

        int count = 0;
        int lastEndTime = meetings.get(0).end;
        for (int index = 1; index < meetings.size(); index++) {
            if (lastEndTime > meetings.get(index).start) {
                count++;
            }
            lastEndTime = Math.max(lastEndTime, meetings.get(index).end);
        }

        return count == 0 ? 1 : count;
    }

    @Data
    @AllArgsConstructor
    public static class MeetingInterval implements Comparable<MeetingInterval> {
        int start;
        int end;

        @Override
        public int compareTo(MeetingInterval o) {
            return start - o.start;
        }
    }
}
