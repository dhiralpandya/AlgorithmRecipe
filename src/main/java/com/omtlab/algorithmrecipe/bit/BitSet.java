package com.omtlab.algorithmrecipe.bit;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Given a string s with only characters A, B, C and D, find if a substring of length 10 is located twice in the string.
 * <p>
 * Idea 1) Compute all the substrings of length 10 and put in a hashset. If we encounter the string again, return true. Else return false at the end.
 * <p>
 * Interviewer said this solution is good, but he wants me to optimize on space.
 * The key here is to realize that we are given only characters [A,B,C,D]. We need 2 bits to represent each character, so we could use 20 bits total. Since 20Bits < 32 bits, we could put our string representation inside an Integer!
 * <p>
 * I also mentioned that we could have a tree like structure, and for every 1 bit we go left, and for 0, we go right. He said this was good but he wanted something different. He said I got brownie points for bring this up :)
 * <p>
 * We eventually settled on the BitSet data structure. He did not expect me to come up with this, and gave me the API definitions.
 */
public class BitSet {
    /**
     * The key here is to realize that we are given only characters [A,B,C,D].
     * We need 2 bits to represent each character, so we could use 20 bits total.
     * Since 20Bits < 32 bits,
     * we could put our string representation inside an Integer!
     */
    Map<Character, Integer> charToBit = new TreeMap<Character, Integer>() {
        {
            put('A', 0);
            put('B', 1);
            put('C', 2);
            put('D', 3);
        }
    };

    public boolean manualBitSet(String input, int length) {
        if (length > 10) {
            throw new RuntimeException("Lenght more than 10 not supported");
        }

        Set<Integer> subStrings = new TreeSet<>();

        for (int i = 0; i < input.length() - length + 1; i++) {
            String subString = input.substring(i, i + length);
            int n = getMask(subString);
            if (subStrings.contains(n)) {
                return true;
            }

            subStrings.add(n);
        }

        return false;
    }

    private int getMask(String s) {
        int a = 0;

        for (Character c : s.toCharArray()) {
            // 2 bit because B is 2 which is 010 and C is 3 which is 011
            // Making space for next char
            a = (a << 2) | charToBit.get(c);
        }
        return a;
    }


    public boolean usingBitSet(String input, int length) {
        if (length > 10) {
            throw new RuntimeException("Lenght more than 10 not supported");
        }

        java.util.BitSet subStrings = new java.util.BitSet(32);

        for (int i = 0; i < input.length() - length + 1; i++) {
            String subString = input.substring(i, i + length);
            int n = getMask(subString);
            if (subStrings.get(n)) {
                return true;
            }

            subStrings.set(n);
        }

        return false;
    }


}
