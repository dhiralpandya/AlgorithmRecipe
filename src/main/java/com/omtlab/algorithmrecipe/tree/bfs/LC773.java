package com.omtlab.algorithmrecipe.tree.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 773. Sliding Puzzle
 * 
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.
 *
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 *
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 *
 * Given a puzzle board, return the least number of moves required so that the state of the board is solved. If it is
 * impossible for the state of the board to be solved, return -1.
 *
 * Examples:
 *
 * Input: board = [[1,2,3],[4,0,5]]
 * Output: 1
 * Explanation: Swap the 0 and the 5 in one move.
 * 
 * Input: board = [[1,2,3],[5,4,0]]
 * Output: -1
 * Explanation: No number of moves will make the board solved.
 * 
 * Input: board = [[4,1,2],[5,0,3]]
 * Output: 5
 * 
 * Explanation: 5 is the smallest number of moves that solves the board.
 * An example path:
 * After move 0: [[4,1,2],[5,0,3]]
 * After move 1: [[4,1,2],[0,5,3]]
 * After move 2: [[0,1,2],[4,5,3]]
 * After move 3: [[1,0,2],[4,5,3]]
 * After move 4: [[1,2,0],[4,5,3]]
 * After move 5: [[1,2,3],[4,5,0]]
 * Input: board = [[3,2,4],[1,5,0]]
 * Output: 14
 * Note:
 *
 * board will be a 2 x 3 array as described above.
 * board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].
 */
public class LC773 {

    public static class Node {
        String pattern;
        int level;
    }
    
    /**
     * Consider each state in the board as a graph node, 
     * we just need to find out the min distance between start node and final target node "123450". 
     * Since it's a single point to single point questions, Dijkstra is not needed here. 
     * We can simply use BFS, and also count the level we passed. 
     * Every time we swap 0 position in the String to find the next state. 
     * Use a hashTable to store the visited states.
     */
    public int slidingPuzzle(int[][] board) {
        /**
         *  All swappable positions in 2x3 matrix
         *  0 1 2   
         *  3 4 5
         *  
         *  See above, Here you can swap position 0 with 1 and 3
         *  Swap position 1 with 0, 2, and 3
         *  and so on for other
         */
        int[][] validSwap = {{ 1, 3 }, { 0, 2, 4 },
                { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 }};

        StringBuilder inputString = new StringBuilder();
        for(int[] i:board) {
            for(int j:i){
                inputString.append(j);
            }
        }
        String start = inputString.toString();
        String end = "123450";
        
        Node startingNode = new Node();
        startingNode.level = 0;
        startingNode.pattern = start;

        Set<String> visitedNode = new HashSet<>(); 
        Queue<Node> queue = new LinkedList<>();
        queue.offer(startingNode);
        visitedNode.add(startingNode.pattern);
        
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            if(n.pattern.equals(end)) {
                return n.level;
            }
            int nextLevel = n.level+1;
            int i = n.pattern.indexOf("0"); // IMP Step
            for(int j:validSwap[i]) {
                String next = swap(n.pattern, i, j);
                if(!visitedNode.contains(next)) {
                    Node nextNode = new Node();
                    nextNode.level = nextLevel;
                    nextNode.pattern = next;
                    queue.add(nextNode);
                    visitedNode.add(next); //IMP Step to avoid adding same pattern in queue.
                }
            }
        }
        return -1;
    }
    
    public String swap(String pattern, int i, int j) {
        StringBuilder sb = new StringBuilder(pattern);
        sb.setCharAt(j,pattern.charAt(i));
        sb.setCharAt(i,pattern.charAt(j));
        return sb.toString();
    }

    
}
