package com.omtlab.algorithmrecipe.twopointer;

import com.omtlab.algorithmrecipe.common.util.Pair;

/**
 * 5. Longest Palindromic Substring
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class LC5 {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int start = 0;
        int end = 0;

        for(int i=0; i < s.length()-1; i++) {
            Pair<Integer, Integer> pairCaseOne = getStartEnd(i,i,s);
            Pair<Integer, Integer> pairCaseTwo = getStartEnd(i,i+1,s);

            int maxLenghtOne = pairCaseOne.getValue() - pairCaseOne.getKey() + 1;
            int maxLenghtTwo = pairCaseTwo.getValue() - pairCaseTwo.getKey() + 1;

            if(maxLenghtOne > maxLenghtTwo) {
                if(maxLenghtOne > maxLength) {
                    start = pairCaseOne.getKey();
                    end = pairCaseOne.getValue();
                    maxLength = maxLenghtOne;
                }
            } else {
                if(maxLenghtTwo > maxLength) {
                    start = pairCaseTwo.getKey();
                    end = pairCaseTwo.getValue();
                    maxLength = maxLenghtTwo;
                }
            }
        }

        return s.substring(start, end+1);// IMP Step
    }

    public Pair<Integer, Integer> getStartEnd(int start, int end, String s) {

        while(start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        return new Pair<>(start+1, end-1);
    }
}
