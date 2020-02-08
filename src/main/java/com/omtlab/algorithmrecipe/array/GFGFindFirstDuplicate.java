package com.omtlab.algorithmrecipe.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Find first duplicate number.
 * <p>
 * https://www.youtube.com/watch?v=XSdr_O-XVRQ
 * https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
 * <p>
 * Given an array nums containing n  integers where each integer is between 1 and n (inclusive)
 * NOTE: Numbers in array will not be larger than size of array.
 * <p>
 * Example Input : {1,4,3,4,2,1}
 * Here size of above array is 6 and there is no number greater than 6.
 * Output: Fist duplicate is  4
 */
public class GFGFindFirstDuplicate {

    public int solutionWithSet(int[] input) {
        Set<Integer> alreadyFound = new HashSet<>();
        for (int v : input) {
            if (alreadyFound.contains(v)) {
                return v;
            }
            alreadyFound.add(v);
        }

        return -1;
    }
    
    public int bestSolutionWithArrayOOfN(int[] input){
        boolean[] found = new boolean[input.length];
        
        for(int v: input) {
            int index = v-1;
            if(found[index]) {
                return v;
            }
            
            found[index] = true;
        }
        
        return -1;
    }


}
