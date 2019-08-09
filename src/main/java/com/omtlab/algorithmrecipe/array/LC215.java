package com.omtlab.algorithmrecipe.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LC215 {

    public int getKthLargest(int[] nums, int k) {
      Arrays.sort(nums);
      return nums[nums.length-k];
    }
}
