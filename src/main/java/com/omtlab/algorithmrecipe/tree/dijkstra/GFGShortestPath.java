package com.omtlab.algorithmrecipe.tree.dijkstra;

import java.util.Arrays;

/**
 * Dijkstra’s shortest path algorithm
 *
 * Check image GFGShortestPath.jpg in documentation for input related details.
 * https://www.youtube.com/watch?v=XB4MIexjvY0&t=327s
 * 
 */
public class GFGShortestPath {
    
    public  int[] sortestPath(int[][] graph, int src) {
        int[] calculatedDistance = new int[graph.length];
        boolean[] visitedNode = new boolean[graph.length];

        Arrays.fill(calculatedDistance, Integer.MAX_VALUE);
        calculatedDistance[src] = 0; // This will help to trigger src node index while executing findMinDistanceNode method.
        for(int treeLevel=0; treeLevel < graph.length-1; treeLevel++) {
            
            int u = findMinDistanceNode(calculatedDistance, visitedNode);
            visitedNode[u] = true;
            
            for(int v =0; v < graph.length; v++) {
                if(!visitedNode[v] 
                        && graph[u][v] != 0
                        && calculatedDistance[u] != Integer.MAX_VALUE
                        && calculatedDistance[u]+graph[u][v] < calculatedDistance[v]) {
                    calculatedDistance[v] = calculatedDistance[u]+graph[u][v];
                }
            }
        }
        return calculatedDistance;
    } 
    
    public int findMinDistanceNode(int[] calculatedDistance, boolean[] visitedNodes) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i =0; i < calculatedDistance.length; i++){
            if(!visitedNodes[i] && calculatedDistance[i] <= min) {
                min = calculatedDistance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
