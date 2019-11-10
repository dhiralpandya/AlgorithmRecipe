package com.omtlab.algorithmrecipe.dp.matrix;

/**
 * 85. Maximal Rectangle
 * 
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 
 * Output: 6
 */
public class LC85 {

    public int maximalRectangle(char[][] matrix) {
        
        GFGLargestAreaHistogram gfgLargestAreaHistogram = new GFGLargestAreaHistogram();
        
        int max =0;
        
        int[] input = new int[matrix[0].length];
        for(int row =0; row <matrix.length; row++){
            
            for(int column=0; column < matrix[row].length;column++){
                int value = Character.getNumericValue(matrix[row][column]);
                
                if(value == 0){
                   input[column] = 0; 
                } else {
                    input[column]+=value;
                }
            }
            
            max = Math.max(max,gfgLargestAreaHistogram.getArea(input));
        }
        
        return max;
    }
    
}
