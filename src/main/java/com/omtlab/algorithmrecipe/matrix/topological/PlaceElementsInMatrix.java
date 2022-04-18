package com.omtlab.algorithmrecipe.matrix.topological;

import com.omtlab.algorithmrecipe.common.graph.Graph;
import com.omtlab.algorithmrecipe.common.graph.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * There are N objects in NxN room. Arrange these objects such that it follows  given relative positions.
 * Input:
 * N=3
 * 1 Left  of 2
 * 2 Right  of 3
 * 1 Above ⬆ 3
 * 3 below ⬇2
 * Output:
 * 1 _ _
 * _ _ 2
 * _ 3 _
 */
public class PlaceElementsInMatrix {
    /**
     * Input:
     * n = 3
     * <p>
     * 1-LEFT-2
     * 2-RIGHT-3
     * 1-ABOVE-3
     * 3-BELOW-2
     */
    public int[][] placeElements(int n, List<String> relativePosition) {
        int[][] matrix = new int[n][n];
        List<String> columnPositionData = relativePosition.stream()
                .filter(s -> s.contains("LEFT") || s.contains("RIGHT"))
                .collect(Collectors.toList());
        List<String> rowPositionData = relativePosition.stream()
                .filter(s -> s.contains("ABOVE") || s.contains("BELOW"))
                .collect(Collectors.toList());

        List<ParentChild> parentChildColumnData = columnPositionData.stream()
                .map(ParentChild::new)
                .collect(Collectors.toList());

        List<ParentChild> parentChildRawData = rowPositionData.stream()
                .map(ParentChild::new)
                .collect(Collectors.toList());
        Graph columnGraph = generateGraph(parentChildColumnData);
        Graph rawGraph = generateGraph(parentChildRawData);

        List<Integer> columnPositions = runTopological(columnGraph);
        List<Integer> rawPositions = runTopological(rawGraph);

        for (int i = 1; i <= n; i++) {
            int column = columnPositions.indexOf(i);
            int raw = rawPositions.indexOf(i);
            matrix[raw][column] = i;
        }

        return matrix;
    }

    private List<Integer> runTopological(Graph g) {
        Queue<String> output = new LinkedList<>();
        List<String> visited = new ArrayList<>();
        for (Node n : g.getVertices()) {
            runRecursion(n, visited, output);
        }

        List<Integer> result = new ArrayList<>();
        while (!output.isEmpty()) {
            result.add(Integer.parseInt(output.poll()));
        }
        return result;
    }

    private void runRecursion(Node n, List<String> visited, Queue<String> output) {
        if (visited.contains(n.getVertex())) {
            return;
        }

        visited.add(n.getVertex());

        for (Node child : n.getAdjacent()) {
            runRecursion(child, visited, output);
        }


        output.offer(n.getVertex());
    }


    private Graph generateGraph(List<ParentChild> parentChildren) {
        Graph g = new Graph();
        parentChildren.stream()
                .forEach(parentChild ->
                        g.put(parentChild.parent + "", parentChild.child + ""));
        return g;
    }

    private static class ParentChild {
        int parent;
        int child;

        ParentChild(String s) {
            if (s.contains("LEFT") || s.contains("RIGHT")) {
                initParentChildForColumn(s);
            } else {
                initParentChildForRow(s);
            }
        }

        void initParentChildForColumn(String input) {
            if (input.contains("LEFT")) {
                //1-LEFT-2
                // 2 in parent and 1 in child
                parent = Integer.valueOf(input.charAt(input.length() - 1) + "");
                child = Integer.valueOf(input.charAt(0) + "");
            } else {
                // 2-RIGHT-3
                // 2 in parent and 3 in child
                parent = Integer.valueOf(input.charAt(0) + "");
                child = Integer.valueOf(input.charAt(input.length() - 1) + "");
            }
        }

        void initParentChildForRow(String input) {
            if (input.contains("ABOVE")) {
                // 1-ABOVE-3
                // 1 in parent and 3 in child
                parent = Integer.valueOf(input.charAt(input.length() - 1) + "");
                child = Integer.valueOf(input.charAt(0) + "");
            } else {
                //3-BELOW-2
                // 2 in parent and 3 in child
                parent = Integer.valueOf(input.charAt(0) + "");
                child = Integer.valueOf(input.charAt(input.length() - 1) + "");
            }
        }
    }

}
