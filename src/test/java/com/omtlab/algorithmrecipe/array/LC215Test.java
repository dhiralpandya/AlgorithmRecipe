package com.omtlab.algorithmrecipe.array;

import com.omtlab.algorithmrecipe.quicksort.LC215;
import org.junit.Assert;
import org.junit.Test;

/**
 * 215. Kth Largest Element in an Array
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, 
 * not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class LC215Test {

    @Test
    public void getKthLargest() {
        int[] a = {3,2,3,1,2,4,5,5,6};
        Assert.assertEquals(4,new LC215().getKthLargest(a,4));

        int[] b = {3,2,1,5,6,4};
        Assert.assertEquals(5,new LC215().getKthLargest(b,2));
    }

    @Test
    public void getKthLargetWithQuickSort() {
        int[] a = {3,2,3,1,2,4,5,5,6};
        Assert.assertEquals(4,new LC215().getKthLargetWithQuickSort(a,4));

        int[] b = {3,2,1,5,6,4};
        Assert.assertEquals(5,new LC215().getKthLargetWithQuickSort(b,2));
    }
}