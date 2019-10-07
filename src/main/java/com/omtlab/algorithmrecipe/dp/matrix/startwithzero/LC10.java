package com.omtlab.algorithmrecipe.dp.matrix.startwithzero;

/*
Companies: [FACEBOOK, UBER]
 */

/**
 * https://www.youtube.com/watch?v=l3hda49XcDE&t=984s
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/RegexMatching.java
 * 
 * 10. Regular Expression Matching
 * 
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * Example 5:
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */
public class LC10  {

    /**
     * Find image LC10 in documentation package.
     *
     * Equation :
     * 
     * T[i][j] =   
     *             if string[i] == pattern[j] OR  pattern[j] = "."
     *                     SET Value at T[i-1][j-1]
     *                     
     *             if pattern[j] == "*"
     *                      CHECK if T[i][j-2] is true or not
     *                          if T[i][j-2] is false then
     *                              Check pattern[j-1] == string[i] OR pattern[j-1] == "."
     *                                  SET Above Value T[i-1][j] 
     *            
     *            
     * 
     */
    public boolean isMatch(String string,String pattern){
        //Here we are going to take one extra row and column for empty string 
        boolean result[][] = new boolean[string.length()+1][pattern.length()+1];
        
        result[0][0] = true;
        
        for(int i =1;i<result[0].length;i++){
            if(pattern.charAt(i-1) == '*'){
                result[0][i]=result[0][i-2];
            }
        }
        
        for(int i =1; i < result.length; i++){
            for(int j=1;j<result[0].length;j++){
                if(pattern.charAt(j-1)=='.' || pattern.charAt(j-1) == string.charAt(i-1)){
                    result[i][j]=result[i-1][j-1];
                } else if(pattern.charAt(j-1)=='*'){
                    boolean previousPreviousValue = result[i][j-2];
                    if(!previousPreviousValue 
                            && ((pattern.charAt(j-2)  == string.charAt(i-1))
                            || pattern.charAt(j-2) == '.')){
                        result[i][j] = result[i-1][j];
                    } else if(previousPreviousValue){
                        result[i][j] = true; 
                    }
                } else {
                    result[i][j] = false;
                }
            }
        }

        return result[string.length()][pattern.length()];
    }
    
    
}
