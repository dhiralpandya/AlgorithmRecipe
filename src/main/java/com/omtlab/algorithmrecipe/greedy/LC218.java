package com.omtlab.algorithmrecipe.greedy;

/**
 * 218. The Skyline Problem
 *
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance.
 * Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A),
 * write a program to output the skyline formed by these buildings collectively (Figure B).
 *
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi],
 * where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively,
 * and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0.
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 *
 * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 * The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ]
 * that uniquely defines a skyline.
 * A key point is the left endpoint of a horizontal line segment.
 * Note that the last key point, where the rightmost building ends,
 * is merely used to mark the termination of the skyline, and always has zero height.
 * Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
 For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 Notes:
 The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 The input list is already sorted in ascending order by the left x position Li.
 The output list must be sorted by the x position.
 There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]*/

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**This video is super clear and helpful: https://www.youtube.com/watch?v=GSBLe8cKu0s
 Algorithm:
 First observation: all the points in the final result come from the four angles that each building has
 Scan through the horizontal lines
 Use a PriorityQueue to hold each building, and make the PriorityQueue to sort on the height of the buildings
 whenever we encounter the start of a building, we push it into the PriorityQueue, whenever we finished scanning that building, we remove it from the PriorityQueue
 Also, in the scan process, we’ll keep updating the maxHeight in the PriorityQueue if we find a new maxHeight which means the building will be overshadowed by the new higher one

 Three edge cases (see the graph illustration in the above video at 12’18”):
 when two buildings have the same start point, the one with higher height shows up in the final result
 when two buildings have the same end point, the one with higher height shows up in the final result
 when the start point of one building is is also the end point of another building, the one with higher height shows up in the final result
 We use TreeMap over a normal PriorityQueue:
 For the sake of efficiency (better time complexity), we’ll use TreeMap which supports O(logn) for remove() operation,
 this is the reason we choose TreeMap over a normal PriorityQueue in Java (PriorityQueue supports add() and getMaxVal() in both O(logn) time, however, for remove(), it does NOT.)
 But TreeMap in Java supports all the three operations in O(logn) time.*/
public class LC218 {
    /**
     * SEE THIS VIDEO
     * https://www.youtube.com/watch?v=GSBLe8cKu0s
     * 
     * Find three edge condition in documentation/LC218.png that we want to consider. 
     * 
     * 
     * Algorithm is very simple, We just want to separate input into start and end and sort it by start.
     * [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] 
     * 
     * Lets see in above input. 
     * 2,10 is start
     * 9,10 is end
     * 
     * But for sorting we have to consider three edge condition find details in documentation/LC218.png
     * 
     */

    /*
      See image in documentation/LC218_Main.png
      Algorithm is simple, We just need to store data in output when there is a change in max height.
      See image carefully, All the points are pointing to height changes. So use priority queue and keep track of max height,
      if you see changes in max height just store the data in output.
     */
    public List<List<Integer>> getSkyline(int[][] building){
        List<List<Integer>> output = Lists.newArrayList();
        
        List<BuildingPoint> buildingPoints = new ArrayList<>();
        
        for(int[] b:building){
            BuildingPoint b1 = new BuildingPoint(b[0],b[2],true);
            BuildingPoint b2 = new BuildingPoint(b[1],b[2],false);
            buildingPoints.add(b1);
            buildingPoints.add(b2);
        }

        Collections.sort(buildingPoints);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.add(0);
        
        int maxHeight = 0;
        for(BuildingPoint bp : buildingPoints){
            
            
            if(bp.isStart){
                queue.add(bp.height);
            } else {
                queue.remove(bp.height);
            }
            
            boolean isMaxHeightChanged = maxHeight != queue.peek();
            
            //Add if height changed, Mark a point.
            if(isMaxHeightChanged){
                output.add(Lists.newArrayList(bp.x,queue.peek()));
            }
            
            maxHeight = queue.peek();
        }
        
        
        return output;
    }
    
    
    
    
    public static class BuildingPoint implements Comparable<BuildingPoint>{

        public int height;
        public int x;
        public boolean isStart;
        
        public BuildingPoint(int x, int height, boolean isStart){
         this.height = height;
         this.x = x;
         this.isStart = isStart;
        }
        
        @Override
        public int compareTo(BuildingPoint o) {
            //for sorting we have to consider 
            // three edge condition find details in documentation/LC218.png
            
            //Normal condition if not same
            if(this.x != o.x){
                return this.x - o.x;
            }
            
            //All three edge conditions 
            
            //1 If both are start. Take bigger building first 
            if(this.isStart && o.isStart){
                return o.height - this.height;//IMP step we are switching the o and this to put bigger first 
            }
            
            //2 If both are end, Take smaller first because we dont want to change max height value in our actual algorithm
            // Why smaller first ?
            // Since both end are with same X value,
            // If we put bigger height first, then we remove bigger first which will change max height
            // and will add point in wrong location (Location at the end of max height).

            // Why Do you think its wrong location ?
            // For max height we need point at left corner, but if we remove max first, it will put point in right corner.
            // Example :
            // *---- : Left corner is correct.
            // ----* : Right corner is wrong.
            if(!this.isStart && !o.isStart) {
                return this.height - o.height;//Smaller first
            }
            
            //3 If one is start and other one is end, then put start of building first. 
            if(this.isStart){
                return -1;
            } else {
                return 1;
            }
        }
    }
    
    
}
