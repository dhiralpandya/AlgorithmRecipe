package com.omtlab.algorithmrecipe.recursion;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 * <p>
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique
 * combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class LC39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = Lists.newArrayList();
        List<Integer> initialList = Lists.newArrayList();
        recursionAndBacktracking(initialList, output,target,0,candidates);
        return output;
    }

    private void recursionAndBacktracking(List<Integer> currentList, List<List<Integer>> output, int target, int index, int[] candidates) {
        if(index >= candidates.length || target < 0) {
            return;
        }
        
        if(target == 0) {
            output.add(new ArrayList<>(currentList));
            return;
        }
        
        for(int i = index; i < candidates.length; i++) {
            currentList.add(candidates[i]);
            recursionAndBacktracking(currentList,output,target-candidates[i], i, candidates);
            currentList.remove(currentList.size()-1);
        }
    }
}
