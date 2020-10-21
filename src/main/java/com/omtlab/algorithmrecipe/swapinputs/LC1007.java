package com.omtlab.algorithmrecipe.swapinputs;

/**
 * 1007. Minimum Domino Rotations For Equal Row
 * <p>
 * In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.
 * (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 * <p>
 * We may rotate the i-th domino, so that A[i] and B[i] swap values.
 * <p>
 * Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.
 * <p>
 * If it cannot be done, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Find image in documentation/LC1007.png
 * <p>
 * Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 * Output: 2
 * Explanation:
 * The first figure represents the dominoes as given by A and B: before we do any rotations.
 * If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
 * Example 2:
 * <p>
 * Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
 * Output: -1
 * Explanation:
 * In this case, it is not possible to rotate the dominoes to make one row of values equal.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A[i], B[i] <= 6
 * 2 <= A.length == B.length <= 20000
 */
public class LC1007 {

    /**
     * See this video : https://www.youtube.com/watch?v=9Q73ScVu2GI
     */

    public int minDominoRotations(int[] A, int[] B) {
      /*

      Question: First of all what we need to make below thing possible
      "all the values in A are the same, or all the values in B are the same."

      Ans: We need to make sure we have
      A[0] in all A
           OR
      B[0] in all A
           OR
      A[0] in all B
           OR
      B[0] in all B

      if A[0] and B[0] are totally different then it is not possible to make values in A or B same.

              Time complexity of below algorithm is O(n)
       */

        int A0InAllA = getMinRotation(A[0], A, B);
        int B0InAllA = getMinRotation(B[0], A, B);
        int A0InAllB = getMinRotation(A[0], B, A);
        int B0InAllB = getMinRotation(B[0], B, A);

        int min = Math.min(Math.min(A0InAllA, B0InAllA), Math.min(A0InAllB, B0InAllB));

        return min == Integer.MAX_VALUE ? -1 : min;
    }


    private int getMinRotation(int target, int[] A, int[] B) {
        int swap = 0;
        for (int i = 0; i < A.length; i++) {
            if (target != A[i] && target != B[i]) {
                return Integer.MAX_VALUE; // Totally different
            } else if (target == A[i]) {
                continue; // No swap needed.
            } else { // target == B[i]
                swap++; // Swap this value
            }
        }
        return swap;
    }

}
