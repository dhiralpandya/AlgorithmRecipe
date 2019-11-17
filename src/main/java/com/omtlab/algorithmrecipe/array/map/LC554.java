package com.omtlab.algorithmrecipe.array.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 554. Brick Wall
 * 
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the
 * same height but different width. You want to draw a vertical line from the top to the bottom and cross the least 
 * bricks.
 *
 * The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each 
 * brick in this row from left to right.
 *
 * If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how
 * to draw the line to cross the least bricks and return the number of crossed bricks.
 *
 * You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously
 * cross no bricks.
 *
 *
 *
 * Example:
 *
 * Input: [[1,2,2,1],
 *         [3,1,2],
 *         [1,3,2],
 *         [2,4],
 *         [3,1,2],
 *         [1,3,1,1]]
 *
 * Output: 2
 *
 * Explanation: 
 *
 * Find image in LC554.png in documentation
 *
 * Note:
 *
 * The width sum of bricks in different rows are the same and won't exceed INT_MAX.
 * The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number 
 * of bricks of the wall won't exceed 20,000.
 */
public class LC554 {

    /**
     * This is pretty simple problem but need to think smart
     * 
     * Lets understand with bricks with two rows as per below. 
     * 
     * --|-|---
     * -|--|---
     * 
     * Pipes are the gep between two brick, Here if we draw line between 2nd pipe in both row then output will be 0
     * 
     * How we will identify the gaps. 
     * we make use of a HashMap
     * map which is used to store entries in the form:
     * (sum,count). Here,
     * sum refers to the cumulative sum of the bricks' widths encountered in the current row, and
     * count refers to the number of times the corresponding sum is obtained. Thus,
     * sum in a way, represents the positions of the bricks's boundaries relative to the leftmost boundary.
     *
     * This is done based on the following observation:
     * We will never obtain the same value of sum twice while traversing over a particular row.
     * Thus, if the sum value is repeated while traversing over the rows, it means some row's brick boundary coincides with some previous row's brick boundary.
     * This fact is accounted for by incrementing the corresponding count value.
     * But, for every row, we consider the sum only upto the second last brick, since the last boundary isn't a valid boundary for the solution. 
     * 
     * 
     * HERE WE WILL TAKE SUM and COUNT Map 
     * 
     * SUM will tell us at which location we will get edge and how many edges will get for any perticular sum. 
     * 
     * Lets say SUM = 2 comes 3 times. It means there are three edges that we found, 
     * So in above condition  line will not cross at least 3 edges, 
     * so remaing line will cross SIZE_OF_WALL_ROW - 3 edges = RESULT
     * 
     * 
     * 
     */
    public int leastBricks(List<List<Integer>> wall) {

        Map<Integer,Integer> sumCountMap = new HashMap<>();
       //NOTE : We will skip last brick in each row since it doesn't matter
       for(List<Integer> row:wall){
           int sum = 0;
           for(int i=0; i < row.size()-1; i++){//NOTE : We will skip last brick in each row since it doesn't matter
               sum+=row.get(i);
               int count = sumCountMap.containsKey(sum)?sumCountMap.get(sum)+1:1;
               sumCountMap.put(sum,count);
           }
       }


        //so remaing line will cross SIZE_OF_WALL_ROW - 3 edges = RESULT
        int SIZE_OF_WALL_ROW = wall.size();
        int result = wall.size();

        for(int key : sumCountMap.keySet()){
            result = Math.min(result,SIZE_OF_WALL_ROW - sumCountMap.get(key));
        }

        return result; 
        
    }
    
    
    public int leastBricksSimple(List<List<Integer>> wall){

        int WALL_HEIGHT = wall.size();
        int result = WALL_HEIGHT;
        
        Map<Integer,Integer> sumCountMap = new HashMap<>();
        //NOTE : We will skip last brick in each row since it doesn't matter
        for(List<Integer> row:wall){
            int sum = 0;
            for(int i=0; i < row.size()-1; i++){//NOTE : We will skip last brick in each row since it doesn't matter
                sum+=row.get(i);
                int count = sumCountMap.containsKey(sum)?sumCountMap.get(sum)+1:1;
                sumCountMap.put(sum,count);
                result = Math.min(result,WALL_HEIGHT-count);
            }
        } 
        
        return result;
    }

}
