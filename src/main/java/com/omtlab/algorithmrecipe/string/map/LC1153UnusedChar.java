package com.omtlab.algorithmrecipe.string.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 1153. String Transforms Into Another String
 * <p>
 * Given two strings str1 and str2 of the same length, determine whether you can transform str1 into str2 by doing zero or more conversions.
 * <p>
 * In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.
 * <p>
 * Return true if and only if you can transform str1 into str2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: str1 = "aabcc", str2 = "ccdee"
 * Output: true
 * Explanation: Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. Note that the order of conversions matter.
 * Example 2:
 * <p>
 * Input: str1 = "leetcode", str2 = "codeleet"
 * Output: false
 * Explanation: There is no way to transform str1 to str2.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= str1.length == str2.length <= 10^4
 * Both str1 and str2 contain only lowercase English letters.
 */
public class LC1153UnusedChar {

    /*
    Read problem carefully
        In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.
     */

    /*
   Explanation
        Scan s1 and s2 at the same time,
        record the transform mapping into a map/array.
        The same char should transform to the same char.
        Otherwise we can directly return false.

        To realise the transformation:

        transformation of link link ,like a -> b -> c:
        we do the transformation from end to begin, that is b->c then a->b

        transformation of cycle, like a -> b -> c -> a:
        in this case we need a tmp
        c->tmp, b->c a->b and tmp->a
        Same as the process of swap two variable.

        In both case, there should at least one character that is unused,
        to use it as the tmp for transformation.
        So we need to return if the size of set of unused characters < 26.


        Complexity
        Time O(N) for scanning input
        Space O(26) to record the mapping
        running time can be improved if count available character during the scan.
     */
    public boolean canConvertUsingUnusedChar(String s1, String s2) {
        if (s1.equals(s2)) return true;
        Map<Character, Character> dp = new HashMap<>();
        for (int i = 0; i < s1.length(); ++i) {
            /*
            Example : s1="aba" and s2="ded"
             Now first time for position 0 we will map : a -> d
                 AT POSITION 0: a->d
                 AT POSITION 1: b->e
                 AT POSITION 2: we are expecting "a" value from "Map" should match with "d" from "s2"
             */
            if (dp.getOrDefault(s1.charAt(i), s2.charAt(i)) != s2.charAt(i))
                // It means mismatch in position, Creating wrong pattern,
                // We have solved this with pattern as well See LC1153.java in same package.
                return false;
            dp.put(s1.charAt(i), s2.charAt(i));
        }
        return new HashSet<Character>(dp.values()).size() < 26; // we need one tmp to store value temporary
    }

}
