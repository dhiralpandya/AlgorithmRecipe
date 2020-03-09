package com.omtlab.algorithmrecipe.tree.topological;

import java.util.HashMap;
import java.util.Map;

/**
 * 953. Verifying an Alien Dictionary
 *
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 *
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are English lowercase letters.
 */
public class LC953 {

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        int i=0;
        for(Character c:order.toCharArray()) {
            characterIntegerMap.put(c,i);
            i++;
        }

        return isAlienSorted(words, characterIntegerMap);
    }

    private boolean isAlienSorted(String[] words, Map<Character, Integer> characterIntegerMap) {
        for(int i=0; i < words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            int minLength = Math.min(word1.length(), word2.length());
            int charIndex = 0;
            // Increase charIndex until we get different characters.
            while(charIndex < minLength
                    && word1.charAt(charIndex) == word2.charAt(charIndex)) {
                charIndex++;
            }

            // If we reached to min length means till min length both words are exactly same,
            // So word1 should be less than word2, if word1 is greater means order is wrong
            if(charIndex == minLength && word1.length() > word2.length()) {
                return false;
            }


            if(characterIntegerMap.get(word1.charAt(charIndex)) > characterIntegerMap.get(word2.charAt(charIndex))) {
                return false;
            }
        }

        return true;
    }
}
