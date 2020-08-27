package com.omtlab.algorithmrecipe.array.sumarray;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
 * Given an array A[] and a number x, check for pair in A[] with sum as x
 * 
 */
public class GFGFindPairForSum {

    /**
     * Lets say 
     * Integer1 + Integer2 = Sum 
     * Integer1 = Sum - Integer2
     * We will keep storing [Sum-Integer2] in map and checking current Integer1 is there in map or now.
     * @param input
     * @param sum
     * @return
     */
    public List<Integer> findPairDiff(Integer[] input, int sum){
        Map<Integer,Integer> sumAndIndex = new TreeMap<>();
        int one=-1;
        int two = -1;


        for(int i =0; i<input.length;i++){
            int sumKey = sum - input[i];
            int currentInt = input[i];
            if(sumAndIndex.containsKey(sumKey)){
                one = sumAndIndex.get(sumKey);
                two = i;
                break;
            } else {
                sumAndIndex.put(currentInt,i);
            }
        }

        return Lists.newArrayList(one,two);
    }

    /**
     * This is really confusing solution, no need to spend much time on this one.
     * @param input
     * @param sum
     * @return
     */
    @Deprecated
    public List<Integer> findPair(Integer[] input, int sum){
        Map<Integer,Integer> sumAndIndex = new TreeMap<>();
        int one=-1;
        int two = -1;


        for(int i =0; i<input.length;i++){
            int sumKey = sum - input[i];
            int currentInt = input[i];
            if(sumAndIndex.containsKey(currentInt)){
                one = sumAndIndex.get(currentInt);
                two = i;
                break;
            } else {
                sumAndIndex.put(sumKey,i);
            }
        }

        return Lists.newArrayList(one,two);
    }

}
