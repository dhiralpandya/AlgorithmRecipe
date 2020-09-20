package com.omtlab.algorithmrecipe.backtracking;

import java.util.*;

/**
 * 90. Subsets II
 * 
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class LC90 {
    
    static class CustomList<T> extends ArrayList<T>{
        StringBuilder pattern = new StringBuilder();


        @Override
        public boolean addAll(Collection<? extends T> c) {
            boolean addedAll =  super.addAll(c);
            if(!c.isEmpty()) {
                Iterator iterator = c.iterator();
                while (iterator.hasNext()){
                    pattern.append(iterator.next());
                }
            }
            return addedAll;
        }

        @Override
        public boolean add(T integer) {
            boolean added = super.add(integer);
            pattern.append(integer);
            return added;
        }


        @Override
        public int hashCode() {
            return toString().hashCode();
        }

        @Override
        public boolean equals(Object o) {
            return toString().equals(o.toString());
        }

        @Override
        public String toString() {
            return sortPattern();
        }

        @Override
        public boolean contains(Object o) {
            return super.contains(o); // Contains method of ArrayList compares using equals method.
        }

        @Override
        public T remove(int index) {
            T removed = super.remove(index);
            pattern.deleteCharAt(index);
            return removed;
        }
        
        public String sortPattern(){
            char[] ary = pattern.toString().toCharArray();
            Arrays.sort(ary);
            return new String(ary);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> output = new CustomList();
        
        output.add(new CustomList<>());
        runBacktracking(nums,0,new CustomList<>(),output);
        
        
        return output;
    }
    
    
    public void runBacktracking(int[] nums, int index, List<Integer> currentList,List<List<Integer>> output) {
        for(int i = index; i < nums.length; i++){
            currentList.add(nums[i]);

            // Contains method of ArrayList compares on equals method.
            if(!output.contains(currentList)){
                CustomList<Integer> newList = new CustomList<>();
                newList.addAll(currentList);
                output.add(newList);
            }
            runBacktracking(nums,i+1,currentList,output);
            currentList.remove(currentList.size()-1);
        }
    }
    
}
