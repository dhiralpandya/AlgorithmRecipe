package com.omtlab.algorithmrecipe.string.map;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 336. Palindrome Pairs
 * <p>
 * Get more details about this implementation in Documentation/LC336.pdf
 * <p>
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the
 * concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Example 2:
 * <p>
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 */
public class LC336 {

    /**
     * Algorithm
     * <p>
     * We'll call a suffix a "valid suffix" of a word if the remainder (prefix) of the word forms a palindrome. The
     * function allValidSuffixes finds all such suffixes. For example, the "valid suffixes" of the word "exempt" are
     * "xempt" (remove "e") and "mpt" (remove 'exe').
     * <p>
     * We'll call a prefix a "valid prefix" of a word if the remainder (suffix) of the word forms a palindrome. The
     * function allValidPrefixes finds all such prefixes in a similar way to how the allValidSuffixes function does.
     * It is possible to combine more of the code for these functions here, but after going back and forth on the
     * issue, I decided against it for this explanation because while it decreases the length of the code and some
     * repetition, the cognitive load to understand it is higher. In your own code, it would be fine to combine it.
     * <p>
     * Examples of case 1 can be found by reversing the current word and looking it up. One edge case to be careful
     * of is that if a word is a palindrome by itself, then we don't want to add a pair that includes that same word
     * twice. This case only comes up in case 1, because case 1 is the only case that deals with pairs where the
     * words are of equal length.
     * <p>
     * Examples of case 2 can be found by calling allValidSuffixes and then reversing each of the suffixes found and
     * looking them up.
     * <p>
     * Examples of case 3 can be found by calling allValidPrefixes and then reversing each of the prefixes found and
     * looking them up.
     * <p>
     * It would be possible to simplify further (not done here) by recognizing that case 1 is really just a special
     * case of case 2 and case 3. This is because the empty string is a palindrome prefix/ suffix of any word.
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> output = Lists.newArrayList();

        Map<String, Integer> wordToIndex = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            wordToIndex.put(words[i], i);
        }

        for (String word : words) {
            int index = wordToIndex.get(word);
            String reverse = StringUtils.reverse(word);
            if (wordToIndex.containsKey(reverse) && wordToIndex.get(reverse) != index) {
                output.add(Lists.newArrayList(index, wordToIndex.get(reverse)));
            }

            List<String> allValidSuffixes = allValidSuffixes(word);
            List<String> allValidPrefixes = allValidPrefix(word);

            for (String suffix : allValidSuffixes) {
                String revSuffix = StringUtils.reverse(suffix);
                if (wordToIndex.containsKey(revSuffix)) {
                    output.add(Lists.newArrayList(wordToIndex.get(revSuffix), index)); // Reverse suffix should be at first position in output array
                }
            }
            
            for (String prefix : allValidPrefixes) {
                String revPrefix = StringUtils.reverse(prefix);
                if (wordToIndex.containsKey(revPrefix)) {
                    output.add(Lists.newArrayList(index, wordToIndex.get(revPrefix))); // Reverse prefix should be at 2nd position in output array
                }
            }
        }

        return output;
    }

    /**
     * Suffix is valid if prefix is palindrome
     */
    private List<String> allValidSuffixes(String word) {
        List<String> validSuffixes = Lists.newArrayList();
        for (int i = 0; i < word.length(); i++) {
            if (isPalindromeBetween(word, 0, i)) { // IMP Step
                validSuffixes.add(word.substring(i + 1));
            }
        }
        return validSuffixes;
    }

    /**
     * Prefix is valid of suffix is palindrome
     */
    private List<String> allValidPrefix(String word) {
        List<String> validPrefix = Lists.newArrayList();
        for (int i = 0; i < word.length(); i++) {
            if (isPalindromeBetween(word, i, word.length() - 1)) { // IMP Step
                validPrefix.add(word.substring(0, i));
            }
        }
        return validPrefix;
    }


    private boolean isPalindromeBetween(String word, int from, int to) {
        while (from < to) {
            if (word.charAt(from) != word.charAt(to)) {
                return false;
            }
            from++;
            to--;
        }


        return true;
    }

}
