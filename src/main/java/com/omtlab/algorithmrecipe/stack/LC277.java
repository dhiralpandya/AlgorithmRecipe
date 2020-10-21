package com.omtlab.algorithmrecipe.stack;

/**
 * 277. Find the Celebrity
 * <p>
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity.
 * The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
 * Now you want to find out who the celebrity is or verify that there is not one.
 * The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B.
 * You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
 * <p>
 * Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.
 */

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/the-celebrity-problem/
 */
public class LC277 {
    private int[][] knowMatrix;

    public LC277(int[][] knowMatrix) {
        this.knowMatrix = knowMatrix;
    }


    public int findCelebritySimpleWay(int n) {
        int mayBeCelebrity = 0;

        for (int i = 1; i < n; i++) {
            // If i doesn't know mayBeCelebrity, means i could be celebrity
            if (!knows(i, mayBeCelebrity)) {
                mayBeCelebrity = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != mayBeCelebrity && (knows(mayBeCelebrity, i) || !knows(i, mayBeCelebrity))) {
                return -1;
            }
        }

        return mayBeCelebrity;
    }

    // Below is stack solution
    public int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int i = stack.pop();
            int j = stack.pop();
            if (knows(i, j)) {
                stack.push(j);
            } else {
                stack.push(i);
            }
        }

        int celebrity = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i != celebrity && (knows(celebrity, i) || !knows(i, celebrity))) {
                return -1;
            }
        }

        return celebrity;
    }


    public boolean knows(int i, int j) {
        return knowMatrix[i][j] == 1;
    }

}
