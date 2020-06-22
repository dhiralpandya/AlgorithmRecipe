package com.omtlab.algorithmrecipe.priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 621. Task Scheduler
 *
 * You are given a char array representing tasks CPU need to do.
 * It contains capital letters A to Z where each letter represents a different task.
 * Tasks could be done without the original order of the array. Each task is done in one unit of time.
 * For each unit of time, the CPU could complete either one task or just be idle.
 *
 * However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array),
 * that is that there must be at least n units of time between any two same tasks.
 *
 * You need to return the least number of units of times that the CPU will take to finish all the given tasks.
 *
 *
 *
 * Example 1:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation:
 * A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 * Example 2:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 0
 * Output: 6
 * Explanation: On this case any permutation of size 6 would work since n = 0.
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * And so on.
 * Example 3:
 *
 * Input: tasks = ["A","B","C","D","E","A","B","C","D","E"], n = 4
 * Output: 10
 *
 *
 * Constraints:
 *
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 */
public class LC621 {

    /**
     * This is really hard problem to think in 20 min. We are going to solve it using Priority Queue.
     *
     * See below video to understand it properly
     * https://www.youtube.com/watch?v=ySTQCRya6B0
     */
    public int leastInterval(char[] tasks, int n) {
        int interval = 0;
        // It contains capital letters A to Z where each letter represents a different task.
        int[] occurrenceOfEachChar = new int[26];

        for(char c: tasks) {
            int distanceFromA = c-'A';
            occurrenceOfEachChar[distanceFromA]++;
        }

        //Max Heap
        // Find details About HeapDataStructure in documentation folder.
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i: occurrenceOfEachChar) {
            if(i > 0) {
                priorityQueue.add(i);
            }
        }

        while(!priorityQueue.isEmpty()) {

            List<Integer> tasksWeDid = new ArrayList<>();
            int COOLDOWN_AND_AT_LEAST_ONETASK = n+1; //Lets say n = 0 still we will perform 1 task
            for(int task=0; task < COOLDOWN_AND_AT_LEAST_ONETASK; task++) {
                if(!priorityQueue.isEmpty()) {
                  tasksWeDid.add(priorityQueue.remove());  // We are doing each task once. No repeating it here.
                }
            }

            for (int taskPerformed:tasksWeDid) {
                int remainingTask = taskPerformed-1;
                if(remainingTask > 0) {
                    priorityQueue.add(remainingTask);
                }
            }

            interval += priorityQueue.isEmpty() ? tasksWeDid.size() : COOLDOWN_AND_AT_LEAST_ONETASK;
        }

        return interval;
    }

}
