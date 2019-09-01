package com.omtlab.algorithmrecipe.common.util;

import com.omtlab.algorithmrecipe.common.node.TreeNode;

import java.util.*;

//Source : https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
public class TreeUtil {
    
    
    public static TreeNode getNodeByValue(TreeNode root, int value){
        if(root == null || root.integerValue == value){
            return root;
        }
        TreeNode found = getNodeByValue(root.right,value);
        return found == null?getNodeByValue(root.left,value):found;
    }
    
    
    public static <T extends Comparable<?>> void printTreeNode(TreeNode root) {
        int maxLevel = TreeUtil.maxLevel(root);

        printTreeNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printTreeNodeInternal(List<TreeNode> TreeNodes, int level, int maxLevel) {
        if (TreeNodes.isEmpty() || TreeUtil.isAllElementsNull(TreeNodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        TreeUtil.printWhitespaces(firstSpaces);

        List<TreeNode> newTreeNodes = new ArrayList<TreeNode>();
        for (TreeNode TreeNode : TreeNodes) {
            if (TreeNode != null) {
                System.out.print(TreeNode.getNodeName());
                newTreeNodes.add(TreeNode.left);
                newTreeNodes.add(TreeNode.right);
            } else {
                newTreeNodes.add(null);
                newTreeNodes.add(null);
                System.out.print(" ");
            }

            TreeUtil.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < TreeNodes.size(); j++) {
                TreeUtil.printWhitespaces(firstSpaces - i);
                if (TreeNodes.get(j) == null) {
                    TreeUtil.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (TreeNodes.get(j).left != null)
                    System.out.print("/");
                else
                    TreeUtil.printWhitespaces(1);

                TreeUtil.printWhitespaces(i + i - 1);

                if (TreeNodes.get(j).right != null)
                    System.out.print("\\");
                else
                    TreeUtil.printWhitespaces(1);

                TreeUtil.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printTreeNodeInternal(newTreeNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(TreeNode TreeNode) {
        if (TreeNode == null)
            return 0;

        return Math.max(TreeUtil.maxLevel(TreeNode.left), TreeUtil.maxLevel(TreeNode.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}