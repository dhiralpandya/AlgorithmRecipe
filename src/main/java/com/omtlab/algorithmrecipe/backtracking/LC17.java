package com.omtlab.algorithmrecipe.backtracking;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
/*
    Companies : [FACEBOOK]
 */
/**
 *
 * 17. Letter Combinations of a Phone Number
 * 
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could
 * represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any
 * letters.
 * 
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * Check Image in documentation with name LC17.png
 */
public class LC17 {


    public static final String[] digits2Letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    
    public void findAllPossibleCombination(String remainingDigit, String currentString, List<String> finalOutput) {
        
        if(remainingDigit.length() == 0){
            finalOutput.add(currentString);
            return;
        } else {
            char[] allChars = digits2Letters[remainingDigit.charAt(0)-'0'].toCharArray();
            if(allChars.length == 0){
                findAllPossibleCombination(remainingDigit.substring(1),currentString,finalOutput);
            } else {
                for(char c : allChars){
                    findAllPossibleCombination(remainingDigit.substring(1),currentString+c,finalOutput);
                }
            }
        }
        
    }

    public void indexBasedSolution(String input, int currentIndex, String currentString, List<String> output) {
        if(currentIndex == input.length()) {
            output.add(currentString);
            return;
        }

        String pattern = digits2Letters[input.charAt(currentIndex) - '0'];
        if(StringUtils.isEmpty(pattern)) {
            indexBasedSolution(input, currentIndex+1, currentString, output);
        } else {
            for (char c : pattern.toCharArray()) {
                indexBasedSolution(input, currentIndex + 1, currentString + c, output);
            }
        }
    }
}
