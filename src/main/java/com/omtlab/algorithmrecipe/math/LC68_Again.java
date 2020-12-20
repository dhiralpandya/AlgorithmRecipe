package com.omtlab.algorithmrecipe.math;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 68. Text Justification
 * <p>
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 * <p>
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * <p>
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * <p>
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * <p>
 * Note:
 * <p>
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * Example 2:
 * <p>
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified becase it contains only one word.
 * Example 3:
 * <p>
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
 * Output:
 * [
 * "Science  is  what we",
 * "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 */
public class LC68_Again {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> output = new ArrayList<>();

        int left = 0;
        while (left < words.length) {
            int right = uptoHowMuchWordsWeCanFit(left, words, maxWidth);

            runAlgorithm(words, maxWidth, output, left, right);

            left = right + 1;
        }

        return output;
    }

    private void runAlgorithm(String[] words, int maxWidth, List<String> output, int left, int right) {
        if (isItOnlyOneWordGoingToFitInThisLine(left, right)) {
            // Only one word, Add all spaces at the end.
            String word = words[left];
            int totalSpaces = maxWidth - word.length();
            String spaces = getSpaces(totalSpaces);
            output.add(word + spaces);
        } else if (isItLastLine(right, words)) {
            // This is last line,
            // Add one space between each words and remaining spaces at the end.
            StringBuilder sb = new StringBuilder();
            for (int i = left; i <= right; i++) {
                sb.append(words[i]);
                if (i != right) { // Dont append space for last word here, We will calculate remainingSpaces at the end.
                    sb.append(" ");
                }
            }
            int remainingSpaces = maxWidth - sb.toString().length();
            sb.append(getSpaces(remainingSpaces));
            output.add(sb.toString());
        } else {
            // For multiple words.
            int totalGapNeededBetweenEachWord = right - left;
            int combineLengthOfAllWords = sumOfLengthOfAllWords(left, right, words);
            int totalSpaces = maxWidth - combineLengthOfAllWords;
            int spaceBetweenEachWord = totalSpaces / totalGapNeededBetweenEachWord;
            int remainder = totalSpaces % totalGapNeededBetweenEachWord;

            StringBuilder sb = new StringBuilder();
            for (int i = left; i <= right; i++) {
                sb.append(words[i]);
                if (i != right) { // No need to add space for last word (i == right).
                    sb.append(getSpaces(spaceBetweenEachWord));
                    if (remainder > 0) {
                        sb.append(" ");
                        remainder--;
                    }
                }
            }
            output.add(sb.toString());
        }
    }

    private boolean isItOnlyOneWordGoingToFitInThisLine(int left, int right) {
        return (left - right) == 0;
    }

    private boolean isItLastLine(int right, String[] words) {
        return right == words.length - 1;
    }

    private int sumOfLengthOfAllWords(int left, int right, String[] words) {
        int sum = 0;

        for (int i = left; i <= right; i++) {
            sum += words[i].length();
        }

        return sum;
    }

    private int uptoHowMuchWordsWeCanFit(int startFromLeft, String[] words, int maxWidth) {
        int currentLength = 0;
        int right = startFromLeft;
        while (right < words.length && currentLength <= maxWidth) {
            int totalSpacesBetweenWords = 1; // IMP Step
            currentLength += words[right].length() + totalSpacesBetweenWords;

            // IMP Step
            // Why currentLength - 1 ??
            // Because last word not require extra space, Space should be between words.
            if (currentLength - 1 <= maxWidth) {
                right++;
            }
        }

        return right - 1;
    }

    private String getSpaces(int numberOfSpaces) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, numberOfSpaces).forEach(i -> sb.append(" "));
        return sb.toString();
    }
}
