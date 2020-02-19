package com.omtlab.algorithmrecipe.tree.dfs;

import java.util.*;

/**
 * 756. Pyramid Transition Matrix
 * We are stacking blocks to form a pyramid. Each block has a color which is a one letter string.
 *
 * We are allowed to place any color block C on top of two adjacent blocks of colors A and B, if and only if ABC is 
 * an allowed triple.
 *
 * We start with a bottom row of bottom, represented as a single string. We also start with a list of allowed triples
 * allowed. Each allowed triple is represented as a string of length 3.
 *
 * Return true if we can build the pyramid all the way to the top, otherwise false.
 *
 * Example 1:
 *
 * Input: bottom = "BCD", allowed = ["BCG", "CDE", "GEA", "FFF"]
 * Output: true
 * Explanation:
 * We can stack the pyramid like this:
 *     A
 *    / \
 *   G   E
 *  / \ / \
 * B   C   D
 *
 * We are allowed to place G on top of B and C because BCG is an allowed triple.  Similarly, we can place E on top of
 * C and D, then A on top of G and E.
 *
 *
 * Example 2:
 *
 * Input: bottom = "AABA", allowed = ["AAA", "AAB", "ABA", "ABB", "BAC"]
 * Output: false
 * Explanation:
 * We can't stack the pyramid to the top.
 * Note that there could be allowed triples (A, B, C) and (A, B, D) with C != D.
 *
 *
 * Note:
 *
 * bottom will be a string with length in range [2, 8].
 * allowed will have length in range [0, 200].
 * Letters in all strings will be chosen from the set {'A', 'B', 'C', 'D', 'E', 'F', 'G'}.
 */
public class LC756 {
    /**
     * We are going to do backtracking with help of DFS.
     * Going to start with bottom and go up till the top. 
     * How do we know if its a top ?????
     *  - we are going to check if row contains only 1 Character
     */
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        
        Map<String, Set<Character>> baseToTop = new HashMap<>();
        
        
        for(String allow:allowed) {
            // Each allowed triple is represented as a string of length 3.
            String base = allow.substring(0,2);
            Character  top = allow.charAt(2);
            baseToTop.putIfAbsent(base, new HashSet<>());
            baseToTop.get(base).add(top);
        }
        
        return dfs(bottom, "", 1, baseToTop);
    }
    
    
    private boolean dfs(String row, String newRow, int subStringIndex, Map<String, Set<Character>> baseToTop) {
        if(row.length() == 1) { // We found Top with one Character, Pyramid is possible
            return true; 
        }

        // This means we are done with current level and moving one level up
        // Level up will have one character less than current level. 
        if(newRow.length() == row.length()-1) {  
            return dfs(newRow, "", 1, baseToTop);
        }
        // subStringIndex-1,subStringIndex+1 is like sliding one char to right.
        // We can also pass 0 as subStringIndex and
        // do substring from -> subStringIndex to -> subStringIndex+2
        for(char c: baseToTop.getOrDefault(row.substring(subStringIndex-1,subStringIndex+1), new HashSet<>())) {
            // IMP Step
            if(dfs(row, newRow+c, subStringIndex+1,baseToTop)) {
                return true;
            }
        }
        return false;
    }
}
