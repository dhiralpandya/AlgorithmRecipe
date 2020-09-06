package com.omtlab.algorithmrecipe.sortingalgorithms;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BucketSortTest {

    BucketSort bucketSort = new BucketSort();

    @Test
    public void sort() {
        float arr[] = {0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f};
        bucketSort.sort(arr);
        float expected[] = {0.1234f, 0.3434f, 0.565f, 0.656f, 0.665f, 0.897f};
        assertThat(expected, is(arr));
    }
}