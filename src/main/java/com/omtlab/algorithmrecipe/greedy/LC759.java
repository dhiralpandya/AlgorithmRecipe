package com.omtlab.algorithmrecipe.greedy;

import java.util.*;

/**
 * 759. Employee Free Time
 * 
 * We are given a list schedule of employees, which represents the working time for each employee.
 *
 * Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
 *
 * Return the list of finite intervals representing common, positive-length free time for all employees, also in 
 * sorted order.
 *
 * (Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or 
 * arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined).  
 * Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.
 *
 *
 *
 * Example 1:
 *
 * Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
 * Output: [[3,4]]
 * Explanation: There are a total of three employees, and all common
 * free time intervals would be [-inf, 1], [3, 4], [10, inf].
 * We discard any intervals that contain inf as they aren't finite.
 * Example 2:
 *
 * Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
 * Output: [[5,6],[7,9]]
 *
 *
 * Constraints:
 *
 * 1 <= schedule.length , schedule[i].length <= 50
 * 0 <= schedule[i].start < schedule[i].end <= 10^8
 */
public class LC759 {


   public static class Interval implements Comparable<Interval>{
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }


        @Override
        public int compareTo(Interval o) {
            if(start != o.start) {
                return start - o.start;
            }
            
            return  end - o.end;
        }
        
        public String toString() {
            return "["+start+", "+end+"]";
        }
    }

    public List<Interval> employeeFreeTimeLittleSimple(List<List<Interval>> schedule) {
        List<Interval> output = new ArrayList<>();
        List<Interval> allInputInSingleList = new ArrayList<>();

        for(List<Interval> lists : schedule) {
            for(Interval interval:lists) {
                allInputInSingleList.add(interval);
            }
        }

        Collections.sort(allInputInSingleList);

        Interval previous = allInputInSingleList.get(0);

        for(int index = 1; index < allInputInSingleList.size(); index++) {
            Interval next = allInputInSingleList.get(index);

            if(previous.end >= next.start) {
                previous.end = Math.max(previous.end, next.end);
            } else {
                Interval freeTime = new Interval();
                freeTime.start = previous.end;
                freeTime.end = next.start;
                output.add(freeTime);
                previous = next; //IMP Step
            }
        }

        return output;
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> output = new ArrayList<>();

        PriorityQueue<Interval> priorityQueue = new PriorityQueue<>();
        
        for(List<Interval> lists : schedule) {
            for(Interval interval:lists) {
                priorityQueue.offer(interval);
            }
        }
        
        while(priorityQueue.size() > 1) {
            Interval first = priorityQueue.poll();
            Interval second = priorityQueue.poll();
            
            if(first.end >= second.start) {
                //Merging
                first.end = Math.max(first.end, second.end);
                priorityQueue.offer(first);
            } else {
                Interval freeTime = new Interval();
                freeTime.start = first.end;
                freeTime.end = second.start;
                output.add(freeTime);
                // Discarding first. Only adding second
                priorityQueue.offer(second);
            }
            
        }
        
        return output;
    }
}
