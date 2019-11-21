package com.omtlab.algorithmrecipe.finduniondisjoinset;

import com.omtlab.algorithmrecipe.common.graph.Graph;
import com.omtlab.algorithmrecipe.common.graph.Node;
import com.omtlab.algorithmrecipe.common.graph.State;

import java.util.HashMap;
import java.util.Map;

public class GFGFindCycleInGraphUnionFindPathComp {
    public boolean isCycleInGraph(Graph graph) {
        Map<Node, Node> subSet = new HashMap<Node, Node>();
        for (Node n : graph.getVertices()) {
            if (n.getAdjacent() != null && !n.getAdjacent().isEmpty()) {
                n.setState(State.VISITED);
                for (Node to : n.getAdjacent()) {
                    if (to.isVisited()) {
                        continue;
                    }
                    Node n1 = find(subSet, n);
                    Node n2 = find(subSet, to);
                    if (n1 == n2) {
                        return true;
                    } else {
                        union(subSet, n, to);
                    }
                }
            }
        }
        return false;
    }

    public static Node find(Map<Node, Node> subSet, Node n) {

        if (subSet.get(n) == null) {
            return n;
        }

        return find(subSet, subSet.get(n));
    }

    public static void union(Map<Node, Node> subSet, Node from, Node to) {
        Node n1 = find(subSet, from);
        Node n2 = find(subSet, to);

        if (n1.getNodeId() < n2.getNodeId()) {
            subSet.put(n2, n1);
        } else if (n1.getNodeId() > n2.getNodeId()) {
            subSet.put(n1, n2);
        } else {
            n1.setNodeId(n1.getNodeId() + 1);
            subSet.put(n1, n2);
        }

    }
}
