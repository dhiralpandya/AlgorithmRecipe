package com.omtlab.algorithmrecipe.twopointer;

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
        int count=0;
        
        for(int i =0; i < s.length(); i++){
            count+=extendSearch(i,i,s); //All odd combinations like: a, aaa etc
            count+=extendSearch(i,i+1,s); // All event combination like : aa, aa etc
        }
        
        return count;
    }
    
    public int extendSearch(int left, int right, String s){
        int count=0;
        
        while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
        
        return count;
    }
    
}
