package com.omtlab.algorithmrecipe.minimax;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 843. Guess the Word
 * <p>
 * This problem is an interactive problem new to the LeetCode platform.
 * <p>
 * We are given a word list of unique words, each word is 6 letters long, and one word in this list is chosen as secret.
 * <p>
 * You may call master.guess(word) to guess a word.
 * The guessed word should have type string and must be from the original list with 6 lowercase letters.
 * <p>
 * This function returns an integer type, representing the number of exact matches (value and position) of your guess to the secret word.  Also, if your guess is not in the given wordlist, it will return -1 instead.
 * <p>
 * For each test case, you have 10 guesses to guess the word. At the end of any number of calls, if you have made 10 or less calls to master.guess and at least one of these guesses was the secret, you pass the testcase.
 * <p>
 * Besides the example test case below, there will be 5 additional test cases, each with 100 words in the word list.  The letters of each word in those testcases were chosen independently at random from 'a' to 'z', such that every word in the given word lists is unique.
 * <p>
 * Example 1:
 * Input: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"]
 * <p>
 * Explanation:
 * <p>
 * master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
 * master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6 matches.
 * master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
 * master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
 * master.guess("abcczz") returns 4, because "abcczz" has 4 matches.
 * <p>
 * We made 5 calls to master.guess and one of them was the secret, so we pass the test case.
 * Note:  Any solutions that attempt to circumvent the judge will result in disqualification.
 */
public class LC843 {

    // ---------------------------------------------------- //
    /*
        Now we want to try a better solution.
        Generally, we will get 0 matches from the master.guess.
        As a result, the size of wordlist reduces slowly.

        Recall some math here, the possibility that get 0 matched is:
        (25/26) ^ 6 = 79.03%

        That is to say, if we make a blind guess,
        we have about 80% chance to get 0 matched with the secret word.

        To simplify the model,
        we're going to assume that,
        we will always run into the worst case (get 0 matched).

        In this case,
        we have 80% chance to eliminate the candidate word
        as well as its close words which have at least 1 match.

        Additionally, in order to delete a max part of words,
        we select a candidate who has a big "family",
        (that is, the fewest 0 matched with other words.)
        We want to guess a word that can minimum our worst outcome.

        So we compare each two words and count their matches.
        For each word, we note how many word of 0 matches it gets.
        Then we guess the word with minimum words of 0 matches.

        In this solution, we apply a minimax idea.
        We minimize our worst case,
        The worst case is max(the number of words with x matches),
        and we assume it equal to "the number of words with 0 matches"

        Time complexity O(N^2)
        Space complexity O(N)
     */
    // ---------------------------------------------------- //

    /*
      SOME MORE DETAILS ON WHY WE ARE TAKING WORD WITH MIN ZERO MATCH
      Nice Solution. Anyone who doesn't know why checking 0 match instead of 1,2,3...6 matches, please take a look at this comment.
      The probability of two words with 0 match is (25/26)^6 = 80%.
      {
        For a position that can choose from 26 characters (a,b,...,z),
        the possibility of the guess one is different than the truth is 25/26.
        There are totally 6 independent positions and therefore the chance that a guess has 0 match with the truth is (25/26) ^ 6.

        Still confused ?????
         - Here to calculate possibility, We can consider word of 1 char only, instead of 6 chars
         - Now from a to z we have total 26 chars, and here lets say we pick char "a" so from a...z, "a" will only match with "a",
              It means "a" will not match any of from b...z which is 25 chars.
         - So now possibility of getting zero is 25/26
         - But now we have 6 chars per word in this problem, So we will use permutations and do exponent of 6
         - (25/26) ^ 6
         - Read more : 1. Permutations with Repetition : https://www.mathsisfun.com/combinatorics/combinations-permutations.html
      }
      That is to say, for a candidate word, we have 80% chance to see 0 match with the secret word.
      In this case, we had 80% chance to eliminate the candidate word and its "family" words which have at least 1 match. Additionally,
      in order to delete a max part of words, we select a candidate who has a big "family" (fewest 0 match with other words).
     */
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> remainingWords = new ArrayList<String>(Arrays.asList(wordlist));
        for (int i = 0; i < 20; i++) {
            Map<String, Integer> wordWithZeroMatchCount = wordWithZeroMatchCount(remainingWords);
            String guess = getWordWithMinZero(wordWithZeroMatchCount);
            final String wordToGuess = StringUtils.isEmpty(guess) ? remainingWords.get(0) : guess;
            int matchWithSecret = master.guess(wordToGuess);
            List<String> filteredWords = remainingWords.stream()
                    .filter(word -> match(wordToGuess, word) == matchWithSecret)
                    .collect(Collectors.toList());
            remainingWords = new ArrayList<>(filteredWords);
        }
    }

    public String getWordWithMinZero(Map<String, Integer> wordWithZeroMatchCount) {
        int minZeroCount = Integer.MAX_VALUE;
        String word = "";

        for (Map.Entry<String, Integer> entry : wordWithZeroMatchCount.entrySet()) {
            if (entry.getValue() < minZeroCount) {
                minZeroCount = entry.getValue();
                word = entry.getKey();
            }
        }

        return word;
    }

    private Map<String, Integer> wordWithZeroMatchCount(List<String> wordlist) {
        Map<String, Integer> wordToZeroMatchCount = new HashMap<>();
        for (String w1 : wordlist) {
            for (String w2 : wordlist) {
                if (match(w1, w2) == 0) {
                    wordToZeroMatchCount.put(w1,
                            wordToZeroMatchCount.getOrDefault(w1, 0) + 1);
                }
            }
        }
        return wordToZeroMatchCount;
    }

    private int match(String w1, String w2) {
        int match = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) == w2.charAt(i)) {
                match++;
            }
        }
        return match;
    }

    // ---------------------------------------------------- //
    //                  Helper classes                      //
    // ---------------------------------------------------- //
    @RequiredArgsConstructor
    @AllArgsConstructor
    static class Master {
        public String secret;
        private int totalGuessMade = 0;

        public int guess(String word) {
            if (totalGuessMade > 10) {
                throw new FailureException();
            }
            totalGuessMade++;
            int totalMatch = match(word);
            if (totalMatch == secret.length()) {
                throw new SuccessException();
            }
            return totalMatch;
        }

        private int match(String word) {
            int match = 0;
            System.out.println("Secret: " + secret + " Word:" + word);
            for (int i = 0; i < secret.length(); i++) {

                if (secret.charAt(i) == word.charAt(i)) {
                    match++;
                }
            }
            return match;
        }

    }

    public static class FailureException extends RuntimeException {
        public FailureException() {
            super("Fail to guess word in 10 try");
        }
    }

    public static class SuccessException extends RuntimeException {
        public SuccessException() {
            super("Successfully able to guess word");
        }
    }
}
