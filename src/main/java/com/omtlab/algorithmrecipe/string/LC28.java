package com.omtlab.algorithmrecipe.string;

/**
 * 28. Implement strStr()
 * 
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr
 * () and Java's indexOf().
 */
public class LC28 {

    public int strStr(String haystack, String needle) {

        if(needle.isEmpty()){
            return 0;
        }
        
        if(haystack.length() < needle.length()){
            return -1;
        }
        
        char[] hChar = haystack.toCharArray();
        char[] nChar = needle.toCharArray();
        
        int maxSize = hChar.length;
        
        for(int i = 0; i < maxSize; i++){
            if(hChar[i] == nChar[0] && found(i,hChar,nChar)){
                return  i;
            }
        }
        
        
        return -1;
    }
    
    public boolean found(int index, char[] hChar, char[] nChar){
        int minSize = Math.min(hChar.length-index,nChar.length);
        
        if(minSize < nChar.length){
            return false;
        }
        
       
        for(int i = index, j=0; i-index < minSize && j < minSize; i++,j++){
            if(hChar[i] != nChar[j]){
                return  false;
            }
        }
        
        return  true;
    }

}
