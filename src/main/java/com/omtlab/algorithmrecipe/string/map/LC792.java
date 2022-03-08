package com.omtlab.algorithmrecipe.string.map;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 792. Number of Matching Subsequences
 * <p>
 * Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde".
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcde", words = ["a","bb","acd","ace"]
 * Output: 3
 * Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
 * Example 2:
 * <p>
 * Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * Output: 2
 */
public class LC792 {

    public int numMatchingSubseq_BruteForce(String s, String[] words) {
        return bruteforce(s, words);
    }


    /**
     * Explanation:
     * I go through S once, and while I'm doing that, I move through all words accordingly. That is, I keep track of how much of each word I've already seen, and with each letter of S, I advance the words waiting for that letter. To quickly find the words waiting for a certain letter, I store each word (and its progress) in a list of words waiting for that letter. Then for each of the lucky words whose current letter just occurred in S, I update their progress and store them in the list for their next letter.
     * <p>
     * Let's go through the given example:
     * <p>
     * S = "abcde"
     * words = ["a", "bb", "acd", "ace"]
     * I store that "a", "acd" and "ace" are waiting for an 'a' and "bb" is waiting for a 'b' (using parentheses to show how far I am in each word):
     * <p>
     * 'a':  ["(a)", "(a)cd", "(a)ce"]
     * 'b':  ["(b)b"]
     * Then I go through S. First I see 'a', so I take the list of words waiting for 'a' and store them as waiting under their next letter:
     * <p>
     * 'b':  ["(b)b"]
     * 'c':  ["a(c)d", "a(c)e"]
     * None: ["a"]
     * You see "a" is already waiting for nothing anymore, while "acd" and "ace" are now waiting for 'c'. Next I see 'b' and update accordingly:
     * <p>
     * 'b':  ["b(b)"]
     * 'c':  ["a(c)d", "a(c)e"]
     * None: ["a"]
     * Then 'c':
     * <p>
     * 'b':  ["b(b)"]
     * 'd':  ["ac(d)"]
     * 'e':  ["ac(e)"]
     * None: ["a"]
     * Then 'd':
     * <p>
     * 'b':  ["b(b)"]
     * 'e':  ["ac(e)"]
     * None: ["a", "acd"]
     * Then 'e':
     * <p>
     * 'b':  ["b(b)"]
     * None: ["a", "acd", "ace"]
     * And now I just return how many words aren't waiting for anything anymore.
     */
    public int numMatchingSubseq_Ideal(String s, String[] words) {
        int count = 0;
        Map<Character, Set<WordIterator>> charToWord = new TreeMap<>();
        for (Character c : s.toCharArray()) {
            charToWord.put(c, new TreeSet<>());
        }

        for (String w : words) {
            WordIterator wt = new WordIterator(w);
            if (charToWord.containsKey(wt.currentChar())) {
                charToWord.get(wt.currentChar()).add(wt);
            }
        }

        for (Character c : s.toCharArray()) {
            if (!charToWord.get(c).isEmpty()) {
                Set<WordIterator> ws = charToWord.get(c);
                charToWord.put(c, new TreeSet<>());

                for (WordIterator wt : ws) {
                    if (!wt.moveToNext()) {
                        count++;
                    } else if (charToWord.containsKey(wt.currentChar())) {
                        charToWord.get(wt.currentChar()).add(wt);
                    }
                }
            }
        }

        return count;
    }

    private int bruteforce(String s, String[] words) {
        int count = 0;
        for (String w : words) {
            int wordIndex = 0;
            for (Character c : s.toCharArray()) {
                if (wordIndex == w.length()) {
                    break;
                }
                if (w.charAt(wordIndex) == c) {
                    wordIndex++;
                }
            }
            if (wordIndex == w.length()) {
                count++;
            }
        }

        return count;
    }

    private static class WordIterator implements Comparable<WordIterator> {
        private String word;
        private int wordLength;
        private int currentIndex = 0;

        WordIterator(String word) {
            this.word = word;
            wordLength = word.length();
        }

        public boolean isDone() {
            return currentIndex >= wordLength - 1;
        }

        public boolean moveToNext() {
            if (isDone()) {
                return false;
            }
            currentIndex++;
            return true;
        }

        public Character currentChar() {
            return word.charAt(currentIndex);
        }

        @Override
        public int compareTo(WordIterator o) {
            return o.word.compareTo(word);
        }
    }
}
