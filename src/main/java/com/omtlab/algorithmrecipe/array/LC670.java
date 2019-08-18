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
        int output = input;
        
        int[] lastIndexOfEachInt = new int[10];
        for(int i = 0; i < allChars.length; i++){
           lastIndexOfEachInt[Character.getNumericValue(allChars[i])]=i;    
        }

        for(int i = 0; i < allChars.length; i++){
            int currentInt = Character.getNumericValue(allChars[i]);
            for(int j = 9;j > currentInt; j--){//Make sure current Digit is greater than j 
                if(lastIndexOfEachInt[j] > i){//Index of Bigger J is more at right side than i 
                    allChars[i] = (char)(j+'0');
                    allChars[lastIndexOfEachInt[j]]=(char)(currentInt+'0');
                    return Integer.parseInt(new String(allChars));
                }
            }
        }
        
        return output;
    }
    
}
