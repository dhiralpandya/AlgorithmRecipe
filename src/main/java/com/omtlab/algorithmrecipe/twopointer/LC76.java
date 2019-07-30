package com.omtlab.algorithmrecipe.twopointer;

/**
 * 76. Minimum Window Substring
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in 
 * complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class LC76 {
    
    
    public String minWindow(String s, String t){
        int totalCount = t.length();
        int mainLenght = s.length();
        int charCache[] = new int[256];
        
        int minLenght = Integer.MAX_VALUE;
        int minStart = 0;
        int end = 0;
        int start = 0;
        
        
        for(Character c: t.toCharArray()){
            charCache[c]++;
        }
        
        while (end < mainLenght){
            //charCache[]
            if(charCache[s.charAt(end)] > 0) {
                totalCount--;
            }
            charCache[s.charAt(end)]--;
            end++;
            
            while(totalCount == 0){
                if(end-start < minLenght){
                    minStart = start;
                    minLenght = end-start;
                }
                
                charCache[s.charAt(start)]++;
                if(charCache[s.charAt(start)] > 0){
                    totalCount++;
                }
                
                start++;
            }
            
        }
        if(minLenght == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(minStart,minStart+minLenght);
    }
    
    
}
