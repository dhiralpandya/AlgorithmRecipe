package com.omtlab.algorithmrecipe.tree.dijkstra;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * 787. Cheapest Flights Within K Stops
 * 
 * There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.
 *
 * Now given all the cities and flights, together with starting city src and the destination dst, your task is to 
 * find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 *
 * Example 1:
 * Input: 
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation: 
 * The graph looks like this:
 *
 *
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 * Example 2:
 * Input: 
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation: 
 * The graph looks like this:
 *
 *
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 * Note:
 *
 * The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
 * The size of flights will be in range [0, n * (n - 1) / 2].
 * The format of each flight will be (src, dst, price).
 * The price of each flight will be in the range [1, 10000].
 * k is in the range of [0, n - 1].
 * There will not be any duplicated flights or self cycles.
 */
public class LC787 {
    /**
     * Here we are going to use BFS with  Dijkstra Algorithm
     */
    public static class Node implements Comparable<Node> {
        int id;
        int price;
        int k;
        List<Node> adj = Lists.newArrayList();
        
        public Node(int id, int price, int k) {
            this.id = id;
            this.price = price;
            this.k = k;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(price, o.price);
        }
    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Node> idToNodeMap = new HashMap<>();
        
        for(int[] flight:flights) {
            
            Node sNode = idToNodeMap.getOrDefault(flight[0],new Node(flight[0],0,0));
            // New destination object each time to avoid override price value.
            // Lets say 1-> 3 (Price 100) and 2->3 (Price 50) , If object of 3 is same then price will get override at time of 2->3
            Node dNode = new Node(flight[1],flight[2],0);
            sNode.adj.add(dNode);
            idToNodeMap.put(flight[0],sNode);
        }

        //BFS
        Queue<Node> queue = new PriorityQueue<>();
        Node srcNode = new Node(src,0,k+1);// IMP Step, Starting with K+1
        queue.add(srcNode);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.id == dst) {
                return node.price;
            }
            if(node.k > 0) {
                //Get actual node to get all Adj nodes
                for(Node adj:idToNodeMap.get(node.id).adj) {
                    adj.price +=node.price;
                    adj.k =  node.k-1;
                    queue.offer(adj);
                }
            }
            
        }
        return -1;
    }
    
}
