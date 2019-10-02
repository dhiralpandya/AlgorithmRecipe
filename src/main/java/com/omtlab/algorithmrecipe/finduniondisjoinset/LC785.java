package com.omtlab.algorithmrecipe.finduniondisjoinset;

/**
 * 785. Is Graph Bipartite?
 * 
 * Given an undirected graph, return true if and only if it is bipartite.
 *
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that 
 * every edge in the graph has one node in A and another node in B.
 *
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j
 * exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: 
 * graph[i] does not contain i, and it doesn't contain any element twice.
 *
 * Example 1:
 * Input: [[1,3], [0,2], [1,3], [0,2]]
 * Output: true
 * Explanation: 
 * The graph looks like this:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * We can divide the vertices into two groups: {0, 2} and {1, 3}.
 * Example 2:
 * Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * Output: false
 * Explanation: 
 * The graph looks like this:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * We cannot find a way to divide the set of nodes into two independent subsets.
 *
 *
 * Note:
 *
 * graph will have length in range [1, 100].
 * graph[i] will contain integers in range [0, graph.length - 1].
 * graph[i] will not contain i or duplicate values.
 * The graph is undirected: if any element j is in graph[i], then i will be in graph[j].
 */
public class LC785 {

    /**
     * Read carefully and understand the issue.
     * 
     * Pay attention : Every edge[CHECK LC785.png] in the graph has [one node in A] and [another node in B.]
     *   0----1
     *   |    |
     *   |    |
     *   3----2
     * Here in above graph we have one edge is 0-1 so one node 0 will be in A and other node 1 will be in B
     * A[0]
     * B[1]
     * 
     * Now take one more edge 0-3, So 0 should be in A and 3 should be in B
     * 
     * A[0]
     * B[1,3]
     * 
     * Same as for other edges, so output will be as per below.
     * A[0,2]
     * B[1,3]
     * 
     * Here we are going to use find and union approach, so lets first focus of our input. 
     * 
     * [ 0->[1,3] , 1->[0,2] , 2->[1,3] , 3->[0,2] ]
     * 
     * Lets focus more on very first element of input which is 
     *  0->[1,3]
     *  
     * Now in above element we are fine with [1,3] in one subset and 0 in different. 
     *  
     * Lets apply jisjoin subset on first element but first assign default parents for each elements
     * 
     * parents[0] = 0 ... parents[n] = n
     * 
     * 
     * Lets apply jisjoin subset on first element : 0->[1,3]
     * 
     * Take element at position ZERO in [1,3] as parent element for all other element
     * here 1 is at position ZERO so store 1 as parent of all other elements in array.
     * 
     * parents[3] = 1
     * 
     * and parents[1] is already 1 as per our first iteration. 
     * 
     * and once we are done assigning parents 
     * 
     * For one for loop and check parents[i] should not equal parents[graph[i][0]] 
     * which means for 0->[1,3],  parents[0] should not equal to parents[1], 
     * that way [1,3] in one subset and 0 in different. 
     * 
     */
    public boolean isBipartite(int[][] graph) {
        
        int totalNodes = graph.length;
        int[] parents = new int[totalNodes];
        
        //Assign default parents
        for(int i = 0; i < totalNodes; i++){
            parents[i]=i;
        }
        
        for(int i=0; i < totalNodes; i++){
            int nodeAtZero = graph[i][0]; // Its 1 in 0->[1,3]
            for(int j=1; j < graph[i].length; j++){
                parents[graph[i][j]]=nodeAtZero;
            }
        }
        
        for(int i=0; i <totalNodes; i++){
            if(parents[i] == parents[graph[i][0]]) {// 0->[1,3]
                //Here we are checking parent of 0 with parent of 1 and is should not same.
                //if it is same then its in same subset and return false
                
                return false;
            }
        }
        
        return true;
    }
    
}
