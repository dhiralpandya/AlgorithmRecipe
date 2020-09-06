package com.omtlab.algorithmrecipe.sortingalgorithms;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

/**
 * Bucket Sort
 * <p>
 * Bucket sort is mainly useful when input is uniformly distributed over a range. For example, consider the following problem.
 * Sort a large set of floating point numbers which are in range from 0.0 to 1.0 and are uniformly distributed across the range. How do we sort the numbers efficiently?
 * <p>
 * A simple way is to apply a comparison based sorting algorithm. The lower bound for Comparison based sorting algorithm (Merge Sort, Heap Sort, Quick-Sort .. etc) is Ω(n Log n), i.e., they cannot do better than nLogn.
 * Can we sort the array in linear time? Counting sort can not be applied here as we use keys as index in counting sort. Here keys are floating point numbers.
 * The idea is to use bucket sort. Following is bucket algorithm.
 * <p>
 * bucketSort(arr[], n)
 * 1) Create n empty buckets (Or lists).
 * 2) Do following for every array element arr[i].
 * .......a) Insert arr[i] into bucket[n*array[i]]
 * 3) Sort individual buckets using insertion sort.
 * 4) Concatenate all sorted buckets.
 * <p>
 * Find IMAGE for bucket sort in documentation/bucketsort.png
 */
public class BucketSort {
    /**
     * Here are the steps in our algorithm.
     * <p>
     * 1. Create bucket with empty list of list
     * 2. Calculate newIndex and add data to that bucket.
     * 3. Sort each bucket.
     * 4. Update actual input.
     */
    public void sort(float[] input) {
        List<List<Float>> bucket = Lists.newArrayList();

        // Create bucket with empty list of list
        for (int index = 0; index < input.length; index++) {
            bucket.add(Lists.newArrayList());
        }

        // Calculate newIndex and add data to that bucket.
        int n = input.length;
        for (int index = 0; index < input.length; index++) {
            int newIndex = (int) (n * input[index]);
            bucket.get(newIndex).add(input[index]);
        }

        // Sort each bucket.
        bucket.stream().forEach(Collections::sort);

        // Update actual input.
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            for (Float data : bucket.get(i)) {
                input[index] = data;
                index++;
            }
        }
    }
}
