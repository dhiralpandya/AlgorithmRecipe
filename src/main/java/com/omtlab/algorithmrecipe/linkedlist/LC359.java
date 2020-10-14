package com.omtlab.algorithmrecipe.linkedlist;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 359. Logger Rate Limiter
 * <p>
 * Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.
 * <p>
 * Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
 * <p>
 * It is possible that several messages arrive roughly at the same time.
 * <p>
 * Example:
 * <p>
 * Logger logger = new Logger();
 * <p>
 * // logging string "foo" at timestamp 1
 * logger.shouldPrintMessage(1, "foo"); returns true;
 * <p>
 * // logging string "bar" at timestamp 2
 * logger.shouldPrintMessage(2,"bar"); returns true;
 * <p>
 * // logging string "foo" at timestamp 3
 * logger.shouldPrintMessage(3,"foo"); returns false;
 * <p>
 * // logging string "bar" at timestamp 8
 * logger.shouldPrintMessage(8,"bar"); returns false;
 * <p>
 * // logging string "foo" at timestamp 10
 * logger.shouldPrintMessage(10,"foo"); returns false;
 * <p>
 * // logging string "foo" at timestamp 11
 * logger.shouldPrintMessage(11,"foo"); returns true;
 */
public class LC359 {

    private Map<String, Integer> messageToTimestamp = new HashMap<>();
    private Deque<String> deque = new LinkedList<>();

    public LC359() {

    }

    /*
    Why we are adding this in LinkedList ?????
      Because it is using LRU implementation, so i wanted to keep LRU related in this package.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        removeOldEntry(timestamp);
        System.out.println("Size of map:" + messageToTimestamp.size());
        if (!messageToTimestamp.containsKey(message) || timestamp - messageToTimestamp.get(message) >= 10) {
            deque.addLast(message);
            messageToTimestamp.put(message, timestamp);
            return true;
        }
        // IMP Step
        deque.remove(message);
        deque.addLast(message);
        return false;
    }

    private void removeOldEntry(int timestamp) {
        while (!deque.isEmpty() && timestamp - messageToTimestamp.get(deque.peekFirst()) >= 10) {
            String entryRemoved = deque.removeFirst();
            messageToTimestamp.remove(entryRemoved);
        }
    }

}
