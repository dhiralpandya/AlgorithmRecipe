package com.omtlab.algorithmrecipe.string.map;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
Companies : [UBER]
 */

/**
 * Anagram Substring Search (Or Search for all permutations)
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints 
 * all occurrences of pat[] and its permutations (or anagrams) in txt[]. You may assume that n > m. 
 * Expected time complexity is O(n)
 * 
 * Examples:
 *
 * 1) Input:  txt[] = "BACDGABCDA"  pat[] = "ABCD"
 *    Output:   Found at Index 0
 *              Found at Index 5
 *              Found at Index 6
 * 2) Input: txt[] =  "AAABABAA" pat[] = "AABA"
 *    Output:   Found at Index 0
 *              Found at Index 1
 *              Found at Index 4
 */
public class GFGAnagramSubstringSearch {
    
    public List<Integer> getAllPosition(String mainString, String pat){
        Map<Character,Integer> patternCharCountMap =  new TreeMap<>();
        Map<Character,Integer> mainCharCountMap =  new TreeMap<>();
        
        List<Integer> output = Lists.newArrayList();
        
        int patLength = pat.length();
        int mainStringLength = mainString.length();
        
        for(int count = 0; count < patLength; count++){
            patternCharCountMap.put(pat.charAt(count),patternCharCountMap.getOrDefault(pat.charAt(count),0)+1);
            mainCharCountMap.put(mainString.charAt(count),mainCharCountMap.getOrDefault(mainString.charAt(count),0)+1);
        }
        
        for(int count = patLength; count<mainStringLength; count++){
            if(compare(patternCharCountMap,mainCharCountMap)){
                output.add(count-patLength);
            }
            
            mainCharCountMap.put(mainString.charAt(count),mainCharCountMap.getOrDefault(mainString.charAt(count),0)+1);
            mainCharCountMap.put(mainString.charAt(count-patLength),mainCharCountMap.get(mainString.charAt(count-patLength))-1);
        }
        
        if(compare(patternCharCountMap,mainCharCountMap)){
            output.add(mainStringLength-patLength);
        }
        
        return output;
    }
    
    
    public boolean compare(Map<Character,Integer> pattern, Map<Character,Integer> actual){
        
        for(Character key : pattern.keySet()){
            if(!actual.containsKey(key) || pattern.get(key) != actual.get(key)){
                return false;  
            }
        }
        
        return true;
    }
    
    
}
