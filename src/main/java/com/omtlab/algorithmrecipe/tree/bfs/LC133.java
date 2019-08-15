package com.omtlab.algorithmrecipe.tree.bfs;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * 133. Clone Graph
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in
 * the graph contains a val (int) and a list (List[Node]) of its neighbors.
 *
 *
 *
 * Example:
 *
 *
 *
 * Input:
 * {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4",
 * "neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 *
 * Explanation:
 * Node 1's value is 1, and it has two neighbors: Node 2 and 4.
 * Node 2's value is 2, and it has two neighbors: Node 1 and 3.
 * Node 3's value is 3, and it has two neighbors: Node 2 and 4.
 * Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 *
 *
 * Note:
 *
 * The number of nodes will be between 1 and 100.
 * The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
 * Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
 * You must return the copy of the given node as a reference to the cloned graph.
 */
public class LC133 {


    static class Node {
        public int val;
        public List<Node> neighbors = Lists.newArrayList();

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
        
    }


    public Node cloneGraph(Node root) {
            
        if(root == null){
            return null;
        }
        
        Node rootCopy = new Node(root.val, Lists.newArrayList());
        Map<Node,Node> originalCopyMap = new HashMap<>();
        originalCopyMap.put(root,rootCopy);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            
            for(Node n : node.neighbors){
                if(!originalCopyMap.containsKey(n)){//Use this as VISITED check also
                    originalCopyMap.put(n,new Node(n.val,Lists.newArrayList()));
                    queue.offer(n);
                }
                originalCopyMap.get(node).neighbors.add(originalCopyMap.get(n));
            }
            
        }
        
        return rootCopy;
    } 
    
    
    
    
}
