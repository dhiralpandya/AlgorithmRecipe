package com.omtlab.algorithmrecipe.twopointer;

/**
 * 680. Valid Palindrome II
 * 
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class LC680 {
    
    public boolean isValidPalindrome(String input){
        int i = 0;
        int j = input.length() -1;
        while(i < j){
           
            if(input.charAt(i) != input.charAt(j)){
                break;
            }
            
            i++;
            j--;
        }
        
        if(i < j){
            return isValidPalindrome(i+1,j,input) || isValidPalindrome(i,j-1,input);
        }
        
        return true;
    }
    
    public boolean isValidPalindrome(int i, int j, String input){
        
        while(i<j){
            if(input.charAt(i) != input.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}
