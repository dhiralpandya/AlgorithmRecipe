package com.omtlab.algorithmrecipe.dp.matrix.startwithzero;



/**
 * https://www.geeksforgeeks.org/edit-distance-dp-5/
 * Edit Distance | DP-5
 * Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits 
 * (operations) required to convert ‘str1’ into ‘str2’.
 *
 * Insert
 * Remove
 * Replace
 * All of the above operations are of equal cost.
 */
public class GFGEditDistance {
    
    public int findMinEditDistacne(String s1, String s2){
        //Here we are going to take one extra row and column for empty string 
        int resultCache[][] = new int[s1.length()+1][s2.length()+1];
        
        //Fill data for extra row
        for(int i =0; i<resultCache.length;i++){
            resultCache[i][0] = i;
        }

        //Fill data for extra column
        for(int i =0; i<resultCache[0].length;i++){
            resultCache[0][i] = i;
        }
        
        for(int i = 1; i < resultCache.length; i++){
            for(int j=1;j<resultCache[0].length;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    resultCache[i][j] = resultCache[i-1][j-1];
                } else {
                    int min = Math.min(Math.min(resultCache[i-1][j-1],resultCache[i-1][j]),resultCache[i][j-1]);
                    resultCache[i][j]=min+1;
                }
            }
        }
        
        
        return resultCache[s1.length()][s2.length()];
    }
    
}
