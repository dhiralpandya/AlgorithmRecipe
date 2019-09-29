package com.omtlab.algorithmrecipe.matrix.bfs;

/**
 *
 * 286 Walls and Gates
 * 
 * You are given a m x n 2D grid initialized with these three possible values. 
 * -1 - A wall or an obstacle.
 0 - A gate.
 INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 For example, given the 2D grid:
 
 INF  -1  0  INF
 INF INF INF  -1
 INF  -1 INF  -1
 0  -1 INF INF
 
 After running your function, the 2D grid should be:
 
 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4
 
 */
public class LC286 {

    public void wallsAndGates(int[][] rooms) {
        for(int row=0; row < rooms.length; row++){
            for(int col = 0; col < rooms[row].length; col++){
                if(rooms[row][col] == 0){
                    bfs(rooms,row,col,rooms.length,rooms[row].length,0);
                }
            }
        }
    }
    
    
    public void bfs(int[][] rooms, int row, int col, int maxRow, int maxCol, int currentCount){
        
        int nextCount = currentCount+1;
        
        //TOP
        if(isValidCell(row-1,col,maxRow,maxCol,rooms,nextCount)){
            bfs(rooms,row-1,col,maxRow,maxCol,nextCount);
        }

        //Bottom
        if(isValidCell(row+1,col,maxRow,maxCol,rooms,nextCount)){
            bfs(rooms,row+1,col,maxRow,maxCol,nextCount);
        }

        //Left
        if(isValidCell(row,col-1,maxRow,maxCol,rooms,nextCount)){
            bfs(rooms,row,col-1,maxRow,maxCol,nextCount);
        }

        //Right
        if(isValidCell(row,col+1,maxRow,maxCol,rooms,nextCount)){
            bfs(rooms,row,col+1,maxRow,maxCol,nextCount);
        }
        
    }
    
    public boolean isValidCell(int row, int col, int maxRow, int maxCol, int[][] rooms, int nextCount){
        if(row < 0 
                || col < 0 
                || row >= maxRow 
                || col >= maxCol
                || nextCount > rooms[row][col]){
            return false;
        }
        
        return true;
    }
    
}
