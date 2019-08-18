package com.omtlab.algorithmrecipe.array;

/**
 * 
 * 670. Maximum Swap
 * 
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the 
 * maximum valued number you could get.
 *
 * Example 1:
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 * Note:
 * The given number is in the range [0, 108]
 */
public class LC670 {
    
    public int maxValue(int input){
        char[] allChars = String.valueOf(input).toCharArray();
        int output = 0;
        
        int[] lastIndexOfEachInt = new int[10];
        for(int i = 0; i < allChars.length; i++){
            
        }
        
        return output;
    }
    
}
