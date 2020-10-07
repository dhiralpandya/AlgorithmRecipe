package com.omtlab.algorithmrecipe.slidingwindow;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 * <p>
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class LC438 {

    public List<Integer> findAnagrams(String s, String p) {
        int[] expectedPattern = new int[256];
        int[] currentPattern = new int[256];
        List<Integer> output = Lists.newArrayList();

        for (int index = 0; index < p.length(); index++) {
            expectedPattern[p.charAt(index)]++;
        }

        int start = 0;
        int patternLength = p.length();
        for (int end = start; end < s.length(); end++) {

            currentPattern[s.charAt(end)]++;
            patternLength--;

            if (patternLength == 0) {
                if (Arrays.equals(expectedPattern, currentPattern)) {
                    output.add(start);
                }
                patternLength++;
                currentPattern[s.charAt(start)]--;
                start++;
            }
        }

        return output;
    }
}
