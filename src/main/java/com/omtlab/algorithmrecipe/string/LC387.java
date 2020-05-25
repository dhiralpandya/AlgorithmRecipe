package com.omtlab.algorithmrecipe.string;

import org.apache.commons.collections4.map.HashedMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 *
 * 387. First Unique Character in a String
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class LC387 {

    public int firstUniqCharNiceSolution(String s) {
        Map<Character, Integer> charWithIndex = new HashedMap<>();
        List<Character> allCharactersWithOneCount = new ArrayList<>();

        for (int index = 0; index < s.length(); index++) {
            Character character = s.charAt(index);
            if (allCharactersWithOneCount.contains(character)) { // It means character came 2nd time.
                allCharactersWithOneCount.remove(character);
            } else if (!charWithIndex.containsKey(character)) { // If not contains key means character is first time.
                allCharactersWithOneCount.add(character);
                charWithIndex.put(character, index);
            }
        }

        return allCharactersWithOneCount.size() > 0 ?
                charWithIndex.getOrDefault(allCharactersWithOneCount.get(0), -1) : -1;
    }


    public int firstUniqCharBestSolution(String s) {

        for(int i= 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            // If firstIndex == lastIndex means character came only once.
            if(s.indexOf(character) == s.lastIndexOf(character)) {
                return i;
            }
        }

        return -1;
    }


}
