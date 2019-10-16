package com.omtlab.algorithmrecipe.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * 51. N-Queens
 * 
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each 
 * other.
 *
 * 
 * Find image : LC51.png in documentation for more details. 
 *
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate 
 * a queen and an empty space respectively.
 *
 * Example:
 *
 * Input: 4
 * Output: [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 * 
 * 
 */
public class LC51 {
    
    //Just see this video first, 
    //https://www.youtube.com/watch?v=xFv_Hl4B83A

    public List<List<String>> solveNQueens(int n) {
        
        
        return null;
        
    }
    
    public void runBacktracking(int n, int[] result, int row, int column, Set<Integer> visitedColumns, List<List<Integer>> output){
        if(row == n){
            List<Integer> list = new ArrayList<>();
            Arrays.stream(result).forEach(i->list.add(i));
            output.add(list);
        } 
        
        
    }
}
