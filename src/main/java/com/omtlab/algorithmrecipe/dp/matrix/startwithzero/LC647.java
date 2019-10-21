package com.omtlab.algorithmrecipe.dp.matrix.startwithzero;

import com.omtlab.algorithmrecipe.common.util.MatrixUtil;

/**
 * 647. Palindromic Substrings
 * 
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist 
 * of same characters.
 *
 * Example 1:
 *
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 *
 * Example 2:
 *
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class LC647 {


    public int countSubstrings(String s) {
        
        int[][] count = new int[s.length()][s.length()+1]; //start with 0 column with value 0
        
        //Fill first row. for length 1
        for(int i =0; i < s.length()+1; i++){
            count[0][i]=i;
        }
        
        for(int lenght = 2; lenght < s.length()+1; lenght++){
            int row = lenght-1;
            for(int col = 1; col < s.length()+1; col++){
                
                int max = Math.max(count[row-1][col-1],Math.max(count[row-1][col],count[row][col-1]));
                
                if(col < lenght){
                    count[row][col] = max;
                    continue;
                } 
                
                int start = col-lenght;
                int end = col;
               
                boolean isPalindromic = isPalindromic(s.substring(start,end));

                //Below is most IMP step, Focus on (count[row][start])
                //Here if string is palindromic then we will do max+previous count.
                if(isPalindromic){
                    max+=1;
                    max+=count[row][start];
                }
                
                count[row][col] = max;
            }
        }
        
        System.out.println();
        MatrixUtil.printMatrix(count);
        
        return count[s.length()-1][s.length()];
    }
    
    
    public boolean isPalindromic(String s){
        
        for(int i =0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        
        return true;
    }
    
    
}
