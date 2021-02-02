package com.omtlab.algorithmrecipe.tree.dfs;

import com.omtlab.algorithmrecipe.tree.dfs.LC1377.Node;
import org.assertj.core.util.Lists;
import org.junit.Test;

public class LC1377Test {

    Node n4 = new Node(Lists.newArrayList(), 4);
    Node n6 = new Node(Lists.newArrayList(), 6);
    Node n2 = new Node(Lists.newArrayList(n4, n6), 2);

    Node n5 = new Node(Lists.newArrayList(), 5);
    Node n3 = new Node(Lists.newArrayList(n5), 3);

    Node n7 = new Node(Lists.newArrayList(), 7);

    Node n1 = new Node(Lists.newArrayList(n7, n3, n2), 1);

    LC1377 lc1377 = new LC1377();

    @Test
    public void frogPosition() {
        double ans = lc1377.frogPosition(n1, 2, 4);
        System.out.println(ans);

        ans = lc1377.frogPosition(n1, 1, 7);
        System.out.println(ans);

        ans = lc1377.frogPosition(n1, 20, 6);
        System.out.println(ans);

        ans = lc1377.frogPosition(n1, 1, 6);
        System.out.println(ans);
    }
}