package com.omtlab.algorithmrecipe.matrix.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
Companies: [FACEBOOK]
 */

/**
 * 200. Number of Islands
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid 
 * are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * 
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class LC200 {
    static class Cell {
        int row;
        int column;
    }
    
    public int totalNumberOfIsland(int input[][]){
        boolean visited[][] = new boolean[input.length][input[0].length];
        int maxIsland = 0;
        
        for(int i = 0; i <  input.length; i++){
            for(int j=0; j < input[i].length; j++){
                if(input[i][j] == 0 || visited[i][j]){
                    visited[i][j] = true;
                } else {
                    maxIsland+=1;
                    Cell cell = new Cell();
                    cell.column = j;
                    cell.row = i;
                    bfs(cell,input,visited);
                }
            }
        }
        
        return maxIsland;
    }
    
    public void bfs(Cell start, int[][] input, boolean[][] visited){
        
        Queue<Cell> queue = new LinkedList<>();
        queue.add(start);
        
        while(!queue.isEmpty()){
            Cell cell = queue.poll();
            visited[cell.row][cell.column]=true;
            
            Cell top = new Cell();
            top.row=cell.row-1;
            top.column = cell.column;

            Cell left = new Cell();
            left.row=cell.row;
            left.column = cell.column-1;

            Cell down = new Cell();
            down.row=cell.row+1;
            down.column = cell.column;

            Cell right = new Cell();
            right.row=cell.row;
            right.column = cell.column+1;
            
            if(isValidCell(top,input,visited)){
                queue.add(top);
            }


            if(isValidCell(down,input,visited)){
                queue.add(down);
            }



            if(isValidCell(left,input,visited)){
                queue.add(left);
            }

            if(isValidCell(right,input,visited)){
                queue.add(right);
            }

        }
        
    }
    
    private static boolean isValidCell(Cell cell,int[][] input, boolean[][] visited){
        int maxRows = input.length;
        int maxColumn = input[0].length;
        
        if(cell.row < maxRows 
                && cell.column < maxColumn 
                && cell.row > -1 
                && cell.column > -1
                && !visited[cell.row][cell.column]
                && input[cell.row][cell.column] != 0){
            return true;
        }
        
        return false;
    }
}
