package com.omtlab.algorithmrecipe.array;

/**
 * 896. Monotonic Array
 * <p>
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * <p>
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * <p>
 * Return true if and only if the given array A is monotonic.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,2,3]
 * Output: true
 * Example 2:
 * <p>
 * Input: [6,5,4,4]
 * Output: true
 * Example 3:
 * <p>
 * Input: [1,3,2]
 * Output: false
 * Example 4:
 * <p>
 * Input: [1,2,4,5]
 * Output: true
 * Example 5:
 * <p>
 * Input: [1,1,1]
 * Output: true
 */
public class LC896 {

    public static int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }

    /**
     * This is really simple problem, there are many way to solve this,
     * 1. keep two boolean flag, 1. increasing 2. decreasing
     * 2. Maintain consistency at each stage.
     * <p>
     * We are going to use 2nd method here
     */
    public boolean isMonotonic(int[] a) {
        int consistency = 0;
        for (int index = 0; index < a.length - 1; index++) {
            int compare = compare(a[index], a[index + 1]);
            // No need to change consistency for duplicate integers.
            // Ex: [1,2,2,3] here 2 is duplicate.
            if (compare != 0) {
                if (compare != consistency && consistency != 0) {
                    return false;
                }
                consistency = compare;
            }
        }
        return true;
    }
}
