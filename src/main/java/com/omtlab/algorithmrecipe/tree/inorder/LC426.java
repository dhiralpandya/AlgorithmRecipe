package com.omtlab.algorithmrecipe.tree.inorder;

import com.omtlab.algorithmrecipe.common.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 426. Convert Binary Search Tree to Sorted Doubly Linked List
 *
 * Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
 *
 * You can think of the left and right pointers as synonymous to the predecessor and successor
 * pointers in a doubly-linked list.
 * For a circular doubly linked list, the predecessor of the first element is the last element,
 * and the successor of the last element is the first element.
 *
 * We want to do the transformation in place. After the transformation,
 * the left pointer of the tree node should point to its predecessor,
 * and the right pointer should point to its successor.
 * You should return the pointer to the smallest element of the linked list.
 *
 *
 * Find more details in Documentation/LC426.pdf
 *
 * Example 1:
 *
 *
 *
 * Input: root = [4,2,5,1,3]
 *
 *
 * Output: [1,2,3,4,5]
 *
 * Explanation: The figure below shows the transformed BST. The solid line indicates the successor relationship,
 * while the dashed line means the predecessor relationship.
 *
 * Example 2:
 *
 * Input: root = [2,1,3]
 * Output: [1,2,3]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 * Explanation: Input is an empty tree. Output is also an empty Linked List.
 * Example 4:
 *
 * Input: root = [1]
 * Output: [1]
 *
 */
public class LC426 {

    public TreeNode treeToDoublyListUsingQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        inOrder(queue, root);

        TreeNode firstNode = queue.poll();
        TreeNode lastNode = firstNode;
        while (!queue.isEmpty()) {
            TreeNode nextNode =  queue.poll();
            lastNode.right = nextNode;
            nextNode.left = lastNode;
            lastNode = nextNode;
        }

        lastNode.right = firstNode;
        firstNode.left = lastNode;

        return firstNode;
    }

    private void inOrder(Queue<TreeNode> queue, TreeNode root) {
        if(root == null) {
            return;
        }

        inOrder(queue, root.left);
        queue.add(root);
        inOrder(queue, root.right);
    }

    public TreeNode treeToDoublyListInSingleLoop(TreeNode root) {
        FirstAndLastElement firstAndLastElement = new FirstAndLastElement();
        inOrder(root, firstAndLastElement);
        firstAndLastElement.first.left = firstAndLastElement.last;
        firstAndLastElement.last.right = firstAndLastElement.first;
        return firstAndLastElement.first;
    }

    public TreeNode inOrder(TreeNode root, FirstAndLastElement element) {
        if(root == null) {
            return null;
        }
        TreeNode left = inOrder(root.left, element);
        TreeNode mid = root;
        TreeNode right = inOrder(root.right, element);

        if(left == null && right == null && element.first == null) {
            element.first = mid;
        } else {
            if(left != null) {
                left.right = mid;
                mid.left = left;
            }

            if(right != null) {
                mid.right = right;
                right.left = mid;
            }
        }

        if(right != null) {
            element.last = right;
            return right;
        }

        element.last = mid;
        return mid;
    }

    static class FirstAndLastElement {
        TreeNode first;
        TreeNode last;
    }
}
