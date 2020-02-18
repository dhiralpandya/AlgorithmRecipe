package com.omtlab.algorithmrecipe.dp.matrix.startwithzero;

import com.omtlab.algorithmrecipe.common.util.MatrixUtil;

import java.util.Arrays;

/**
 * 377. Combination Sum IV
 * 
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that 
 * add up to a positive integer target.
 *
 * Example:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * Note that different sequences are counted as different combinations.
 *
 * Therefore the output is 7.
 */
public class LC377 {

    /**
     * This is accepted by leetcode
     * 
     * This is how it works 
     * 
     * Lets say we have below input and target 
     * input = [1,2,3]  target = 4
     * 
     * We will prepare our matrix like this
     * 
     *   0 1 2 3 4
     * 1 1
     * 2 1
     * 3 1
     * 
     * Here in above matrix we will assign 1 to zero th column
     * 
     * Equation 
     *
     *  Start with row 0 to N
     *      Start with column 1 to Target
     *          
     *          if number at row is > than current column 
     *                  copy above value into current cell
     *          if number at row is <= current column 
     *                loop from currentRow to 0 th row
     *                 take value from same row but column will be [column-nums[row]] 
     *                      and add it in result[row][column]
     *                      
     * Final output would be. 
     * 
     *   0 1 2 3 4
     * 1 1 1 1 1 1
     * 2 1 1 2 3 5
     * 3 1 1 2 4 7
     * 
     * How to think about this problem.
     *
     * Here by looping through the currentRow to 0 means
     * we are trying each target with all  from nums at currentNum to nums at 0
     *
     * Since we are using DP. Divide the problem in to small parts
     *
     * Lets say we have one number in array and target is also one.
     * nums = [1] , target = 1
     * So possible output would be {1} only one
     *
     * Now nums = [1,2] and target = 1
     * Same output {1}
     *
     * Now nums = [1,2] and target = 2
     * There are two output = {1,1} and {2}
     *
     * Here we will use previously calculated value to get our ans.
     *
     * Here we will do 2-2 = 0 to get value from [row][0] which is 1
     * Now we will take previous value to get count from there,
     * previous value is 1 so 2-1 = 1 to get value from [row][1] is 1
     *
     * So total 1+1 = 2
     *
     */
    public int combinationSum4(int[] nums, int target) {

        if(nums.length == 0){
            return nums.length;
        }
        
        
        //IMP Step sorting
        Arrays.sort(nums);
        int[][] result = new int[nums.length][target+1];
        
        //Fist column is ZERO
        for(int row = 0; row < nums.length; row++){
            result[row][0] = 1;
        }
        
        for(int row =0; row < nums.length; row++ ){
            
            int num = nums[row];
            
            for(int column = 1; column < target+1; column++){
                int upperCellValue = 0;

                if(row > 0){
                    upperCellValue = result[row-1][column];
                }
                if(num > column){
                    result[row][column] = upperCellValue;
                    continue;
                }

                /**
                 * Loop from currentRow to 0 th row.
                 */
                int preRow = row;
                while(preRow > -1 ){
                    int preNum = nums[preRow];
                    result[row][column]+=result[row][column-preNum];
                    preRow--;
                }
            }
        }

        MatrixUtil.printMatrix(result);
        
        return result[nums.length-1][target];
    }

    
}
