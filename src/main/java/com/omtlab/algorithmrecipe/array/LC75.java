package com.omtlab.algorithmrecipe.array;

/**
 * 75. Sort Colors
 * <p>
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are
 * adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for this problem.
 * <p>
 * Example:
 * <p>
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 * <p>
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then
 * 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class LC75 {

    /**
     * One pass solution using "Dutch national flag problem"
     * Time complexity : O(N) since it's one pass along the array of length N.
     */
    public void sortColorOnePass(int[] nums) {
        int current = 0;
        int left = 0;
        int right = nums.length - 1;

        while (current <= right) {
            if (nums[current] == 0) {
                swap(left, current, nums);
                left++;
                current++;
            } else if (nums[current] == 2) {
                swap(right, current, nums);
                right--;
            } else { // nums[current] == 1
                current++;
            }
        }
    }


    private void swap(int a, int b, int[] array) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * This is two pass solution
     */
    public void sortColor(int[] nums) {
        int[] threeColorsCount = new int[3];
        for (int i = 0; i < nums.length; i++) {
            int color = nums[i];
            threeColorsCount[color] += 1;
        }

        int index = 0;
        for (int color = 0; color < 3; color++) {
            int colorCount = threeColorsCount[color];
            for (int j = 0; j < colorCount; j++) {
                nums[index++] = color;
            }
        }
    }

}
