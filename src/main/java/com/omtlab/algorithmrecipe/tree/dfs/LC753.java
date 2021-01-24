package com.omtlab.algorithmrecipe.tree.dfs;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * 753. Cracking the Safe
 * <p>
 * There is a box protected by a password. The password is a sequence of n digits where each digit can be one of the first k digits 0, 1, ..., k-1.
 * <p>
 * While entering a password, the last n digits entered will automatically be matched against the correct password.
 * <p>
 * For example, assuming the correct password is "345", if you type "012345", the box will open because the correct password matches the suffix of the entered password.
 * <p>
 * Return any password of minimum length that is guaranteed to open the box at some point of entering it.
 */
public class LC753 {
    // Must watch this video https://youtu.be/iPLQgXUiU14
    // We have two approaches here
    //1. hamilton cycle (Keep track of visited vertices)
    //2. euler cycle (Keep track of visited edges)

    //Find attached image which shows how this DFS works on graph.
    // Image will help you to visualize the approach.
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();

        String rootNode = String.join("", Collections.nCopies(n - 1, "0"));
        System.out.println("Root node:" + rootNode);

        dfs(sb, rootNode, new TreeSet<String>(), k);
        sb.append(rootNode);
        return sb.toString();
    }

    private void dfs(StringBuilder ans, String node, Set<String> visitedNodes, int k) {
        for (int i = 0; i < k; i++) {
            String edge = node + "" + i;
            if (!visitedNodes.contains(edge)) {
                visitedNodes.add(edge);
                dfs(ans, edge.substring(1), visitedNodes, k);
                ans.append(i);
            }
        }
    }

}
