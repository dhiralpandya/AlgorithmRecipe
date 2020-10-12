package com.omtlab.algorithmrecipe.string.map;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
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
public class LC1153 {

    /*
    Read problem carefully
        In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.
     */

    /*
    Both strings have same length,
    We can only replace string 1 with string 2 if both are making same pattern.
    Same patterns mean for each char in String1 should have some equivalent char in String2 in all same positions.
    For example
       aabcc > ccbee, here a and c both are at position 0 and 1, same c and e are also making same pattern (position 3, 4)
     */
    public boolean canConvertUsingPattern(String str1, String str2) {
        System.out.println(makePattern(str1));
        System.out.println(makePattern(str2));
        System.out.println("--------------------");
        return makePattern(str1).equals(makePattern(str2));
    }

    private String makePattern(String s) {
        Map<Character, List<Integer>> charToPositionsMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (charToPositionsMap.containsKey(s.charAt(i))) {
                charToPositionsMap.get(s.charAt(i)).add(i);
            } else {
                charToPositionsMap.put(s.charAt(i), Lists.newArrayList(i));
            }
        }
        // We have to maintain order of pattern generated for each char.
        // NOTE : Hashmap will change the order of key, We have two options here,
        // Use LinkedHashMap to maintain the order or use below method to get pattern by proper order.
        StringBuilder sb = new StringBuilder();

        for (Character c : s.toCharArray()) {
            sb.append(charToPositionsMap.get(c).toString());
        }

        return sb.toString();
    }
}
