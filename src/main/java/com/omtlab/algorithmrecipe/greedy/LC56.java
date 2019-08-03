package com.omtlab.algorithmrecipe.greedy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 56. Merge Intervals
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method 
 * signature.
 */
public class LC56 {
    
    public static class Interval implements Comparable<Interval>{
        public int start;
        public int end;
        
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            return start-o.start;
        }
    }
    
    
    public List<Interval> merge(List<Interval> input){
        LinkedList<Interval> output = new LinkedList<>();
        Collections.sort(input);
        
        for(Interval interval:input){
            if(output.isEmpty() || output.getLast().end < interval.start){
                output.add(interval);
            } else {
                output.getLast().end = Math.max(output.getLast().end,interval.end);
            }
        }
        return output;
    } 
    
}
