package com.omtlab.algorithmrecipe.backtracking;

/**
 * 79. Word Search
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those 
 * horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class LC79 {


    public boolean exist(char[][] board, String word) {
         boolean visited[][] = new  boolean[board.length][board[0].length];
         for(int row=0; row < board.length; row++){
             for(int column =0; column<board[row].length; column++){
                 if(board[row][column] == word.charAt(0) && dfs(board,word,0,row,column,visited)){
                     return true;
                 }
             }
         }
         
         return false;
    }


    public boolean dfs(char[][] board,
                       String word,
                       int wordIndex,
                       int row,
                       int column,
                       boolean[][] visited){

        if(wordIndex == word.length()) {
            return true;
        }


        if(isValidCell(board, word, wordIndex, row, column, visited)) {
            visited[row][column] = true;

            if(dfs(board, word, wordIndex+1, row+1, column, visited)
                    || dfs(board, word, wordIndex+1, row-1, column, visited)
                    || dfs(board, word, wordIndex+1, row, column+1, visited)
                    || dfs(board, word, wordIndex+1, row, column-1, visited)) {
                return true;
            }

            visited[row][column] = false; // Backtracking, Clearing the visited for next recursion
        }

        return false;
    }

    public boolean isValidCell(char[][] board,
                               String word,
                               int wordIndex,
                               int row,
                               int column,
                               boolean[][] visited) {

        if(row < 0 || column < 0 || row >= board.length || column >= board[0].length) {
            return false;
        }

        if(visited[row][column]) {
            return false;
        }

        if(board[row][column] != word.charAt(wordIndex)) {
            return false;
        }

        return true;
    }




//
//    public boolean dfs(char[][] board, String word, int wordIndex, int row, int column, boolean[][] visited){
//        if(wordIndex == word.length()){
//            return true;
//        }
//
//        if(word.charAt(wordIndex) != board[row][column]){
//            return false;
//        }
//
//
//        int nextChar = wordIndex+1;
//        if(nextChar == word.length()){ // No need to do dfs here, Just return true.
//            return true;
//        }
//
//        visited[row][column] = true; // Setting up flag
//
//        boolean anyOfFourSideIsTrue = false;//Check if any of top, bottom, left or right is true.
//
//        //Top
//        if(isValidCell(row-1,column,visited,board.length,board[row].length)
//                && !anyOfFourSideIsTrue && dfs(board,word,nextChar,row-1,column,visited) ){
//            anyOfFourSideIsTrue = true;
//        }
//
//
//        //Bottom
//        if(isValidCell(row+1,column,visited,board.length,board[row].length)
//                && !anyOfFourSideIsTrue && dfs(board,word,nextChar,row+1,column,visited)){
//            anyOfFourSideIsTrue = true;
//        }
//
//        //Left
//        if(isValidCell(row,column-1,visited,board.length,board[row].length)
//                && !anyOfFourSideIsTrue && dfs(board,word,nextChar,row,column-1,visited)){
//            anyOfFourSideIsTrue = true;
//        }
//
//        //Right
//        if(isValidCell(row,column+1,visited,board.length,board[row].length)
//                && !anyOfFourSideIsTrue && dfs(board,word,nextChar,row,column+1,visited)){
//            anyOfFourSideIsTrue = true;
//        }
//
//
//        visited[row][column] = false; //Backtracking, Clearing the visited for next recursion
//
//        return anyOfFourSideIsTrue;
//
//    }
//
//
//    boolean isValidCell(int row, int column, boolean[][] visited, int maxRow, int maxColumn){
//
//        if(row < 0
//                || column < 0
//                || row >=maxRow
//                || column>=maxColumn){
//            return false;
//        }
//        //True if  NOT VISITED
//        return !visited[row][column]; // MOST IMP Line
//    }
    
}
