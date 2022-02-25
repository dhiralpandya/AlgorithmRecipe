package com.omtlab.algorithmrecipe.design.using.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * 1146. Snapshot Array
 * <p>
 * Implement a SnapshotArray that supports the following interface:
 * <p>
 * SnapshotArray(int length) initializes an array-like data structure with the given length.  Initially, each element equals 0.
 * void set(index, val) sets the element at the given index to be equal to val.
 * int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
 * int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["SnapshotArray","set","snap","set","get"]
 * [[3],[0,5],[],[0,6],[0,0]]
 * Output: [null,null,0,null,5]
 * Explanation:
 * SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
 * snapshotArr.set(0,5);  // Set array[0] = 5
 * snapshotArr.snap();  // Take a snapshot, return snap_id = 0
 * snapshotArr.set(0,6);
 * snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
 */
public class LC1146StringKey {
    private Map<String, Integer> snapshotArray;
    private int snapId = 0;

    public LC1146StringKey(int length) {
        snapshotArray = new TreeMap<>();
    }

    public void set(int index, int val) {
        snapshotArray.put(generateKey(snapId, index), val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        return snapshotArray.getOrDefault(generateKey(snap_id, index), 0);
    }

    private String generateKey(int snapId, int index) {
        return String.format("S%s_I%s", snapId, index);
    }

}
