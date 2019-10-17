package com.omtlab.algorithmrecipe.design.using.list;

import java.util.*;

/**
 * 380 Insert Delete GetRandom O(1)
 * 
 * 
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of 
 * being returned.
 * Example:
 *
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 *
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 *
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 *
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 *
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 *
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 *
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 */
public class LC380 {

    /**
     * In this problem we are going to use List to store all the values 
     * and Map to store key as values and value as position of values in list. 
     * 
     * This way we can achieve O(1) during remove.
     */
    
     List<Integer> valList  = new ArrayList<>();
     Map<Integer,Integer> valAndPositionMap = new HashMap<>();
     Random random = new Random();
    

    /** Initialize your data structure here. */
    public LC380() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        
        if(valAndPositionMap.containsKey(val)){
            return false;
        }
        
        //Take one previous size, 
        //Lets say Val is the only int, 
        //So position will be ZERO not 1
        valAndPositionMap.put(val,valList.size());    
        valList.add(val);
        
        
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!valAndPositionMap.containsKey(val)) {
            return false;
        }
        
        int position = valAndPositionMap.get(val);
        if(position != valList.size() -1) {//If position is not last position
            int lastElement = valList.get(valList.size() -1);
            valList.set(position,lastElement);
            valAndPositionMap.put(lastElement,position);
        }
        
        valList.remove(valList.size()-1);//Remove last element
        valAndPositionMap.remove(val);
        
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return valList.get(random.nextInt(valList.size()));
    }
}

