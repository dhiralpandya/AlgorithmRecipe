package com.omtlab.algorithmrecipe.tree.inorder;

import com.omtlab.algorithmrecipe.common.node.TreeNode;
import com.omtlab.algorithmrecipe.twopointer.GenerateTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LC426Test {

    private LC426 lc426;
    private GenerateTree generateTree;

    @BeforeEach
    void setup() {
        lc426 = new LC426();
        generateTree = new GenerateTree();
    }

    @Test
    void treeToDoublyListUsingQueue() {
        Integer[] input = {4,2,5,1,3};
        TreeNode treeNode = lc426.treeToDoublyListUsingQueue(generateTree.getRootNode(input));
        printSuccessor(treeNode);
        printPredecessor(treeNode);
    }

    @Test
    void treeToDoublyListInSingleLoop() {
        Integer[] input = {4,2,5,1,3};
        TreeNode treeNode = lc426.treeToDoublyListInSingleLoop(generateTree.getRootNode(input));
        printSuccessor(treeNode);
        printPredecessor(treeNode);
    }

    private void printSuccessor(TreeNode node) {
        Set<TreeNode> visited = new HashSet<>();
        System.out.println();
        while (node != null && !visited.contains(node)) {
            System.out.printf(node.integerValue+" -> ");
            visited.add(node);
            node = node.right;
        }
    }

    private void printPredecessor(TreeNode node) {
        Set<TreeNode> visited = new HashSet<>();
        System.out.println();
        while (node != null && !visited.contains(node)) {
            System.out.printf(node.integerValue+" <- ");
            visited.add(node);
            node = node.left;
        }
    }
}