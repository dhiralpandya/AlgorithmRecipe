package com.omtlab.algorithmrecipe.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 809. Expressive Words
 * <p>
 * Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo",
 * "hi" -> "hiiii".  In these strings like "heeellooo",
 * we have groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".
 * <p>
 * For some given string S, a query word is stretchy if it can be made to be equal
 * to S by any number of applications of the following extension operation:
 * choose a group consisting of characters c, and add some number of characters c
 * to the group so that the size of the group is 3 or more.
 * <p>
 * For example, starting with "hello",
 * we could do an extension on the group "o" to get "hellooo",
 * but we cannot get "helloo" since the group "oo" has size less than 3.
 * Also, we could do another extension like "ll" -> "lllll"
 * to get "helllllooo".
 * If S = "helllllooo", then the query word "hello" would be stretchy
 * because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = S.
 * <p>
 * Given a list of query words, return the number of words that are stretchy.
 * <p>
 * <p>
 * <p>
 * Example:
 * Input:
 * S = "heeellooo"
 * words = ["hello", "hi", "helo"]
 * Output: 1
 * Explanation:
 * We can extend "e" and "o" in the word "hello" to get "heeellooo".
 * We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= len(S) <= 100.
 * 0 <= len(words) <= 100.
 * 0 <= len(words[i]) <= 100.
 * S and all words in words consist only of lowercase letters
 * Accepted
 * 51,181
 * Submissions
 * 109,042
 */
public class LC809 {

    public int expressiveWords(String S, String[] words) {
        int matchCount = 0;

        /*
          Before thinking of solution, Please read below line carefully
          > For some given string S,
          > a query word is stretchy if it can be made to be equal to S by
          > any number of applications of the following extension operation:
          > choose a group consisting of characters c,
          > and add some number of characters c to the group so that the size of the group is 3 or more.

              Add some number of chars to that group SIZE become 3 or more.

            Here are the all conditions we will check
            1. Word should have all char of input and all of them should be in same positions.
            2. if char in input < 3 then char in word also exactly same
               - lest say Input is "caat" then matching word would be "caat" only
                - here c1a2t1 in both input and word.
            3 if char in input >= 3 then char in word <= input

         */
        // Here we want to maintain order of char but we also need count of each one based on order.
        // We will use list to maintain order and keep track of count of each char,
        // Example : Lets say heeellloooeeeew   '
        // List would have h,1,e,3,l,3,o,3,e,4,w,1
        List<Object> listOfCharAndCountInInputS = charAndCountList(S);

        for (String word : words) {
            List<Object> charAndCountInWord = charAndCountList(word);
            if (isValidWord(charAndCountInWord, listOfCharAndCountInInputS)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    private List<Object> charAndCountList(String s) {
        List<Object> charAtSamePositionAndCount = new ArrayList<>();

        char preChar = s.charAt(0);
        int count = 1;

        int i = 1;

        while (i < s.length()) {
            char currentChar = s.charAt(i);
            if (currentChar == preChar) {
                count++;
            } else {
                charAtSamePositionAndCount.add(preChar);
                charAtSamePositionAndCount.add(count);
                count = 1;
                preChar = currentChar;
            }
            i++;
        }

        // IMP Step
        charAtSamePositionAndCount.add(preChar);
        charAtSamePositionAndCount.add(count);

        return charAtSamePositionAndCount;
    }

    private boolean isValidWord(List<Object> wordWithCharCount, List<Object> inputWithCharCount) {
        if (wordWithCharCount.size() != inputWithCharCount.size()) {
            return false;
        }

        for (int index = 0; index < wordWithCharCount.size(); index++) {
            char c1 = (Character) inputWithCharCount.get(index);
            char c2 = (Character) wordWithCharCount.get(index);

            if (c1 != c2) {
                return false;
            }

            index++;
            int countInInput = (Integer) inputWithCharCount.get(index);
            int countInWord = (Integer) wordWithCharCount.get(index);

            if (countInInput < 3) {
                if (countInInput != countInWord) {
                    return false;
                }
            }

            if (countInInput >= 3) {
                if (!(countInWord <= countInInput)) {
                    return false;
                }
            }
        }

        return true;
    }
}
