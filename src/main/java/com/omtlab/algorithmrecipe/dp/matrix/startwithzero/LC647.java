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

    /**
     * 
     * Here initial matrix would be like this
     * 
     * Input : aaa
     * 
     * Matrix 
     * 
     *   0 a a a
     * 0 0 1 2 3
     * 1 0
     * 2 0
     * 
     * Here column is Characters in string, initial column will start with ZERO
     * Here row is size or lenght of string, starting with 1 to string length.
     * NOTE : Here length 1 is actually zero th row. 
     * 
     * So lets say for length 2
     * 
     * initial for loop for column will be 1 to string length.
     * 
     * First we will take max value from [row-1][col-1], [row][col-1], [row-1][col]
     * 
     * now if col < lenght we will just store max value in cell and continue with next column
     * 
     * now once we reach to col >= lenght 
     * 
     * we will identify start 
     * 
     *  start = col- lenght 
     *  end = col;
     *  
     *  Here for length 2 and col =2 
     *  
     *  start = 0
     *  end = 2 
     *  
     *  SubString will be "aa" [Col index : 1 and 2] 
     *  
     * 
     *  Here "aa" is Palindromic, now add +1 in max count and take count from start result. 
     *  
     *  
     * Final output 
     *   0 a a a
     * 0 0 1 2 3
     * 1 0 1 3 5 - Here 5 means : [aa at col index 1,2 = 2 max + 1 of current = 3 + aa at col index 1,3 = 3 max + 1 current + 1 for result[row][1] = 5 ]
     * 2 0 1 3 6
     * 
     * 
     */
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
                    max+=1;//One for current 
                    max+=count[row][start]; // Add all previous count. 
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
