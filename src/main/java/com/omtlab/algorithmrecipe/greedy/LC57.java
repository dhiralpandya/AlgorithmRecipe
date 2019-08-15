package com.omtlab.algorithmrecipe.greedy;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 57. Insert Interval
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method 
 * signature.
 */
public class LC57 {

    public static class Interval {
        public int start;
        public int end;

        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    
    public List<Interval> insertInterval(List<Interval> input, Interval newInterval){
        List<Interval> output = Lists.newArrayList();
        
        int index = 0;
        
        //Add all interval which are not overlap
        while(index < input.size() && input.get(index).end <  newInterval.start){
            output.add(input.get(index));
            index++;
        }
        
        while (index<input.size() && newInterval.end >= input.get(index).start){
            newInterval.start = Math.min(newInterval.start, input.get(index).start);
            newInterval.end = Math.max(newInterval.end,input.get(index).end);
            index++;
        }
        
        output.add(newInterval);
        
        //Remaining 
        while (index < input.size()){
            output.add(input.get(index));
            index++;
        }
        
        return output;
    }
}
