package com.omtlab.algorithmrecipe.twopointer;

/**
 * 1423. Maximum Points You Can Obtain from Cards
 * <p>
 * There are several cards arranged in a row, and each card has an associated number of points The points are given in the integer array cardPoints.
 * <p>
 * In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
 * <p>
 * Your score is the sum of the points of the cards you have taken.
 * <p>
 * Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: cardPoints = [1,2,3,4,5,6,1], k = 3
 * Output: 12
 * Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
 * Example 2:
 * <p>
 * Input: cardPoints = [2,2,2], k = 2
 * Output: 4
 * Explanation: Regardless of which two cards you take, your score will always be 4.
 * Example 3:
 * <p>
 * Input: cardPoints = [9,7,7,9,7,7,9], k = 7
 * Output: 55
 * Explanation: You have to take all the cards. Your score is the sum of points of all cards.
 * Example 4:
 * <p>
 * Input: cardPoints = [1,1000,1], k = 1
 * Output: 1
 * Explanation: You cannot take the card in the middle. Your best score is 1.
 * Example 5:
 * <p>
 * Input: cardPoints = [1,79,80,1,1,1,200,1], k = 3
 * Output: 202
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= cardPoints.length <= 10^5
 * 1 <= cardPoints[i] <= 10^4
 * 1 <= k <= cardPoints.length
 */
public class LC1423 {
    /*
    This is amazing problem and solution, We will first get sum of all left and
    then take right one by one, add right to sum and subtract left from sum,
    compare new sum with max.
     */
    public int maxScore(int[] cardPoints, int k) {
        int max = 0;

        int left = 0;
        int sum = 0;
        while (left < k) {
            sum += cardPoints[left];
            left++;
        }

        max = sum;

        int right = cardPoints.length - 1;
        left = k - 1;
        while (right > cardPoints.length - 1 - k) {
            sum -= cardPoints[left];
            sum += cardPoints[right];
            max = Math.max(max, sum);
            right--;
            left--;
        }
        return max;
    }
}
