package com.omtlab.algorithmrecipe.backtracking;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

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

    public List<List<Integer>> solveNQueensIntegerOutput(int n) {
        
        int[] result = new int[n];
        Arrays.fill(result,-1);//IMP Step
        List<List<Integer>> output = Lists.newArrayList();
        Set<Integer> visitedColumns = Sets.newHashSet();
        runBacktracking(n,result,0,visitedColumns,output);
        
        return output;
        
    }

    public List<List<String>> solveNQueens(int n) {

        int[] result = new int[n];
        Arrays.fill(result,-1);//IMP Step
        List<List<Integer>> output = Lists.newArrayList();
        Set<Integer> visitedColumns = Sets.newHashSet();
        runBacktracking(n,result,0,visitedColumns,output);

        List<List<String>> stringOutput = Lists.newArrayList();
        
        for(List<Integer> intList:output){
            List<String> ls = Lists.newArrayList();
            for(Integer position:intList){
                StringBuilder sb = new StringBuilder();
                
                for(int i=0; i < n;i++){
                    if(i == position){
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                ls.add(sb.toString());
            }
            stringOutput.add(ls);
        }
        
        return stringOutput;

    }
    
    public void runBacktracking(int n, int[] result, int row, Set<Integer> visitedColumns, List<List<Integer>> output){
        if(row == n){
            List<Integer> list = new ArrayList<>();
            Arrays.stream(result).forEach(i->list.add(i));
            output.add(list);
            return;
        } 
        for(int col = 0; col < n; col++) {
            if (validatePosition(n, result, row,col, visitedColumns)) {
                visitedColumns.add(col);
                result[row] = col;
                runBacktracking(n, result, row + 1, visitedColumns, output);
                visitedColumns.remove(col); //Backtracking
                result[row] = -1; //Backtracking
            }
        }
        
        return;
    }
    
    public boolean validatePosition(int n,int[] result, int row, int column, Set<Integer> visitedColumn){
        
        if(visitedColumn.contains(column)){
            return false;
        }
        
        //Validate diagonal 
        
        //Move top left
        int top = row-1;
        int left = column-1;//This is attack position
        while(top >=0 && left >=0){
            int columnAtRow = result[top];
            if(columnAtRow == left){//attack possible
                return false;
            }
            top--;
            left--;
        }
        
        //Move Top Right
        top = row-1;
        int right = column+1;//This is attack position
        while(top >= 0 && right < n){
         
            int columnAtRow = result[top];
            if(columnAtRow == right){//attack possible
                return false;
            }
            
            top--;
            right++;
        }
        
        
        return true;
    }
}
