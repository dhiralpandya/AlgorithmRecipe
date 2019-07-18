package com.omtlab.algorithmrecipe.matrix.bfs;

import java.util.LinkedList;
import java.util.Queue;
/*
    Companies : [AMAZON]
 */

/**
 * 
 * 
 * 
 * https://www.geeksforgeeks.org/shortest-distance-two-cells-matrix-grid/
 * 
 * Shortest distance between two cells in a matrix or grid
 * Given a matrix of N*M order. Find the shortest distance from a source cell to a destination cell, traversing 
 * through limited cells only. Also you can move only up, down, left and right. If found output the distance else -1.
 * s represents ‘source’
 * d represents ‘destination’
 * * represents cell you can travel
 * 0 represents cell you can not travel
 * This problem is meant for single source and destination.
 * 
 * 
 * 
 * The idea is to BFS (breadth first search) on matrix cells. Note that we can always use BFS to find shortest path 
 * if graph is unweighted.
 *
 * Store each cell as a node with their row, column values and distance from source cell.
 * Start BFS with source cell.
 * Make a visited array with all having “false” values except ‘0’cells which are assigned “true” values as they can 
 * not be traversed.
 * Keep updating distance from source value in each move.
 * Return distance when destination is met, else return -1 (no path exists in between source and destination).
 */
public class GFGShortDistMrx {

     
    public int findMinDistance(char[][] matrix){
        
        boolean isVisited[][] = new boolean[matrix.length][matrix[0].length];
        Cell source = null;
       
        for(int i =0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                
                if(matrix[i][j] == '0'){
                    isVisited[i][j] = true;
                } else if(matrix[i][j] == 's'){
                    source = new Cell();
                    source.dist = 0;
                    source.row = i;
                    source.column = j;
                }
                
            }
        }


        int maxRow = matrix.length;
        int maxColumn = matrix[0].length;
        
        Queue<Cell> queue = new LinkedList<>();
        queue.add(source);
        
        while(!queue.isEmpty()){
            Cell cell = queue.poll();
            int row = cell.row;
            int column = cell.column;
            
            if(matrix[row][column] == 'd'){
                return cell.dist;
            }
            
            //Top
            if(row - 1 >= 0 && !isVisited[row-1][column]){
                isVisited[row-1][column] = true;
                Cell top = new Cell();
                top.dist = cell.dist+1;
                top.row = row-1;
                top.column = column;
                queue.add(top);
            }

            //Right
            if(column + 1 < maxColumn && !isVisited[row][column+1]){
                isVisited[row][column+1] = true;
                Cell right = new Cell();
                right.dist = cell.dist+1;
                right.row = row;
                right.column = column+1;
                queue.add(right);
            }
            
            //Left
            if(column - 1 >= 0 && !isVisited[row][column-1]){
                isVisited[row][column-1] = true;
                Cell left = new Cell();
                left.dist = cell.dist+1;
                left.row = row;
                left.column = column-1;
                queue.add(left);
            }


            //Bottom
            if(row + 1 < maxRow && !isVisited[row+1][column]){
                isVisited[row+1][column] = true;
                Cell bottom = new Cell();
                bottom.dist = cell.dist+1;
                bottom.row = row+1;
                bottom.column = column;
                queue.add(bottom);
            }
            
            
            
        }
        
        return -1;
    }
    
    
    
    
    
    
    static class Cell {
        int row;
        int column;
        int dist;
    }
   
}
