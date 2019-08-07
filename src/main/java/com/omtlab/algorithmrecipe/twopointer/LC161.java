package com.omtlab.algorithmrecipe.twopointer;

import java.util.Map;

/**
 * 161. One Edit Distance
 *
 * Given two strings s and t, determine if they are both one edit distance apart.
 *
 * Note:
 *
 * There are 3 possiblities to satisify one edit distance apart:
 *
 *     Insert a character into s to get t
 *     Delete a character from s to get t
 *     Replace a character of s to get t
 *
 * Example 1:
 * Input: s = "ab", t = "acb"
 * Output: true
 * Explanation: We can insert 'c' into s to get t.
 *
 * Example 2:
 * Input: s = "cab", t = "ad"
 * Output: false
 * Explanation: We cannot get t from s by only one step.
 *
 * Example 3:
 * Input: s = "1203", t = "1213"
 * Output: true
 * Explanation: We can replace '0' with '1' to get t.
 */
public class LC161 {
    
    
    public boolean oneEditDistance(String s, String t){
        if(Math.abs(s.length()-t.length()) > 1){
            return false;
        }
        
        int minSize = Math.min(s.length(),t.length());
        
        
        int sCount = 0;
        int tCount =0;
        
        for(int i=0; i<minSize;i++,sCount++,tCount++){
            if(s.charAt(i) != t.charAt(i)){
                return oneEditDistance(i+1,i,s,t) || oneEditDistance(i,i+1,s,t);
            }
        }
        
        return (sCount==s.length() && tCount==t.length())
                || (sCount==s.length() && tCount==t.length()-1)
                || (sCount==s.length()-1 && tCount==t.length());
                
    }
    
    private boolean oneEditDistance(int sCount, int tCount, String s, String t){
        while(sCount<s.length() && tCount<t.length()){
            if(s.charAt(sCount) != t.charAt(tCount)){
                return false;
            }
            sCount++;
            tCount++;
        }
        
        return sCount==s.length() && tCount==t.length();
    }
    
}
