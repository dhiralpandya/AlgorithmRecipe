package com.omtlab.algorithmrecipe.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 273. Integer to English Words
 * <p>
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 * <p>
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 * <p>
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Example 4:
 * <p>
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
public class LC273 {


    private Map<Integer, String> ZERO_TO_NINE = new HashMap<Integer, String>() {
        {
            put(0, "");
            put(1, "One");
            put(2, "Two");
            put(3, "Three");
            put(4, "Four");
            put(5, "Five");
            put(6, "Six");
            put(7, "Seven");
            put(8, "Eight");
            put(9, "Nine");
        }
    };

    private Map<Integer, String> MAP_11_TO_19 = new HashMap<Integer, String>() {
        {
            put(11, "Eleven");
            put(12, "Twelve");
            put(13, "Thirteen");
            put(14, "Fourteen");
            put(15, "Fifteen");
            put(16, "Sixteen");
            put(17, "Seventeen");
            put(18, "Eighteen");
            put(19, "Nineteen");
        }
    };


    private Map<Integer, String> TEN_TO_NINETY = new HashMap<Integer, String>() {
        {
            put(10, "Ten");
            put(20, "Twenty");
            put(30, "Thirty");
            put(40, "Forty");
            put(50, "Fifty");
            put(60, "Sixty");
            put(70, "Seventy");
            put(80, "Eighty");
            put(90, "Ninety");
        }
    };

    private Map<Integer, String> ZERO_LENGTH_TO_TEXT = new HashMap<Integer, String>() {
        {
            put(1, "");
            put(2, "Hundred");
            put(3, "Thousand");
            put(4, "Thousand");
            put(5, "Thousand");
            put(6, "Million");
            put(7, "Million");
            put(8, "Million");
            put(9, "Billion");
            put(10, "Billion");
            put(11, "Billion");
            put(12, "Trillion");
            put(13, "Trillion");
            put(14, "Trillion");

        }
    };

    private Map<String, Integer> TEXT_START_AT = new HashMap<String, Integer>() {
        {
            put("Hundred", 2);
            put("Thousand", 3);
            put("Million", 6);
            put("Billion", 9);
            put("Trillion", 12);
        }
    };

    public String numberToWords(int num) {
        if(num < 1) {
            throw new IllegalArgumentException("Invalid number");
        }
        int numLenght = String.valueOf(num).length();

        if (numLenght > 14) {
            throw new IllegalArgumentException("Invalid number");
        } else if(numLenght == 1) {
            return handleOneNumber(num)+" ";
        } else if(numLenght == 2) {
            return handleTwoNumbers(num)+" ";
        }

        String numberInString = String.valueOf(num);
        String s1 = ZERO_LENGTH_TO_TEXT.get(numLenght-1); // IMP Step, This is total numLenght, lets say number 100, total lenght 3 but for hundred 1-- its only 2 digit
        int start = 0;
        int end = numLenght - TEXT_START_AT.get(s1);

        int prefixNum = Integer.parseInt(numberInString.substring(start, end));
        int suffix = Integer.parseInt(numberInString.substring(end));
        StringBuilder sb = new StringBuilder();
        sb.append(numberToWords(prefixNum));
        sb.append(s1);
        sb.append(" ");
        sb.append(numberToWords(suffix));
        sb.append(" ");
        return sb.toString();
    }


    private String handleOneNumber(int num) {
        return ZERO_TO_NINE.get(num);
    }

    private String handleTwoNumbers(int num) {
        if(num == 0) {
            return "";
        }

        if(num%10 == 0) { // If  second digit is zero
            return TEN_TO_NINETY.get(num);
        }

        int firstDig = num/10;
        int secondDig = num%10;

        StringBuilder sb = new StringBuilder();

        if(firstDig == 0) {
            //Do nothing
        } else if(firstDig == 1) {
            return MAP_11_TO_19.get(num);
        }

        sb.append(TEN_TO_NINETY.get(firstDig*10)); // IMP Step
        sb.append(" ");
        sb.append(handleOneNumber(secondDig));

        return sb.toString();
    }



}
