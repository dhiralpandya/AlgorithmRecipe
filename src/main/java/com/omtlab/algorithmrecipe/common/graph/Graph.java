package com.omtlab.algorithmrecipe.common.graph;

import java.util.*;

public class Graph {

    private List<Node> vertices = new ArrayList<>();

    private Map<String,Node> vertexNodeMap = new HashMap<>();
    
    public void addVertex(Node node) {
        vertexNodeMap.put(node.getVertex(),node);
        vertices.add(node);
    }
    
    public Node getVertexNode(String vertex){
        return vertexNodeMap.get(vertex);
    }
    
    public void put(String parent, String child){
        
        if(!vertexNodeMap.containsKey(parent)){
            addVertex(new Node(parent));
        }

        if(!vertexNodeMap.containsKey(child)){
            addVertex(new Node(child));
        }
        
        
        getVertexNode(parent).addAdjacent(getVertexNode(child));
        
    }

    public List<Node> getVertices() {
        return vertices;
    }

    public int getEdgeCount() {
        return getEdges().size();
    }

    public Set<Edge> getEdges() {
        Set<Edge> totalEdges = new HashSet<>();
        for (Node n : vertices) {
            totalEdges.addAll(n.getEdges());
        }
        return totalEdges;
    }

}