package com.omtlab.algorithmrecipe.string.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging 
the letters of a different word or phrase, 
typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 */
public class LC242 {

    public boolean isAnagram(String s, String t) {
        Map<Character, LetterCount> charToCountMap = new HashMap<>();
        if(s.length() != t.length()) {
            return false;
        }

        for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            LetterCount sLt = charToCountMap.getOrDefault(sChar, new LetterCount());
            sLt.letter = sChar;
            sLt.sCount++;
            charToCountMap.put(sChar, sLt);

            LetterCount tLt = charToCountMap.getOrDefault(tChar, new LetterCount());
            tLt.letter = tChar;
            tLt.tCount++;
            charToCountMap.put(tChar, tLt);
        }

        for(LetterCount lc : charToCountMap.values()) {
            if (!lc.isSame()) {
                System.out.println(lc.letter + " is not the same count ["+lc.sCount+", "+lc.tCount+"]");
                return false;
            }
        }

        return true;
    }
    
    class LetterCount{
        char letter; 
        int sCount = 0;
        int tCount = 0;
        boolean isSame() {
            return sCount == tCount;
        }
    }
}
