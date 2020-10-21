package com.omtlab.algorithmrecipe.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 38. Count and Say
 * <p>
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 */
public class LC38 {


    public String usingRegex(int n) {
        /*
        Find image in documentation with more details.
            (.)\1*

            1st Capturing Group (.)
            . matches any character (except for line terminators)
            \1* matches the same text as most recently matched by the 1st capturing group
            * Quantifier — Matches between zero and unlimited times, as many times as possible,
            giving back as needed (greedy)
         */
        String currentString = "1";

        Pattern pattern = Pattern.compile("(.)\\1*");


        for (int i = 1; i < n; i++) {
            Matcher matcher = pattern.matcher(currentString);
            StringBuilder sb = new StringBuilder();
            while (matcher.find()) {
                String group = matcher.group();
                sb.append(group.length());
                sb.append(group.charAt(0));
            }
            currentString = sb.toString();
        }

        return currentString;
    }

    /**
     * Problem defination is little confusing, Here we just want to count the same char
     * and add the count in front
     * <p>
     * Example : For 11222 = Count of 1 is 2 and Count of 2 is 3
     * So output will be COUNT[1]COUNT[2]  = 2132 that's it.
     */

    public String countAndSay(int n) {

        String[] preCalculate = {"1", "11", "21", "1211", "111221"};

        if (n <= preCalculate.length) {
            return preCalculate[n - 1];
        }

        String pre = "111221";
        StringBuilder running = new StringBuilder();

        for (int i = 5; i < n; i++) {
            int count = 1;
            Character lastChar = null;

            for (int j = 0; j < pre.length(); j++) {
                if (j == 0) {
                    lastChar = pre.charAt(j);
                } else {
                    if (lastChar != pre.charAt(j)) {
                        running.append(count).append(lastChar);
                        lastChar = pre.charAt(j);
                        count = 1;
                    } else {
                        count++;
                    }
                }
            }

            running.append(count).append(lastChar);
            pre = running.toString();
            running = new StringBuilder();
        }

        return pre;
    }

}
