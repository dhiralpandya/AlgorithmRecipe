package com.omtlab.algorithmrecipe.tree.dfs;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * 1377. Frog Position After T Seconds
 * <p>
 * Given an undirected tree consisting of n vertices numbered from 1 to n. A frog starts jumping from vertex 1. In one second, the frog jumps from its current vertex to another unvisited vertex if they are directly connected. The frog can not jump back to a visited vertex. In case the frog can jump to several vertices, it jumps randomly to one of them with the same probability. Otherwise, when the frog can not jump to any unvisited vertex, it jumps forever on the same vertex.
 * <p>
 * The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi] means that exists an edge connecting the vertices ai and bi.
 * <p>
 * Return the probability that after t seconds the frog is on the vertex target.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
 * Output: 0.16666666666666666
 * Explanation: The figure above shows the given graph. The frog starts at vertex 1, jumping with 1/3 probability to the vertex 2 after second 1 and then jumping with 1/2 probability to vertex 4 after second 2. Thus the probability for the frog is on the vertex 4 after 2 seconds is 1/3 * 1/2 = 1/6 = 0.16666666666666666.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7
 * Output: 0.3333333333333333
 * Explanation: The figure above shows the given graph. The frog starts at vertex 1, jumping with 1/3 = 0.3333333333333333 probability to the vertex 7 after second 1.
 * Example 3:
 * <p>
 * Input: n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 20, target = 6
 * Output: 0.16666666666666666
 */
public class LC1377 {
    // Check more details in LC1377.pdf documentation.
    public double frogPosition(Node n, int t, int target) {
        int probability = dfs(n, t, target);

        return probability == 0 ? 0 : (1.0d / probability);
    }

    private int dfs(Node n, int timeInSecond, int target) {
        if (timeInSecond == 0) {
            if (n.id != target) {
                return 0;
            } else {
                return 1;
            }
        }

        if (target == n.id) {
            return 1;
        }

        int count = 0;
        for (Node v : n.vertices) {
            int tempCount = dfs(v, timeInSecond - 1, target);
            if (tempCount != 0) {
                count = tempCount;
                break;
            }
        }
        return count * n.vertices.size();
    }

    @AllArgsConstructor
    static class Node {
        List<Node> vertices = Lists.newArrayList();
        int id;
    }
}
