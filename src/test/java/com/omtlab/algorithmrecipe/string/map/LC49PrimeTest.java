package com.omtlab.algorithmrecipe.string.map;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LC49PrimeTest {

    @Test
    public void groupAnagrams() {
        
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>>  output = new LC49Prime().groupAnagrams(input);
        for(List<String> list:output){
            System.out.println(Arrays.toString(list.toArray(new String[list.size()])));
        }
    }
}