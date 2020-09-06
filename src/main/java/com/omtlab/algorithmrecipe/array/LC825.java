package com.omtlab.algorithmrecipe.array;

/**
 * 825. Friends Of Appropriate Ages
 * <p>
 * Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person.
 * <p>
 * Person A will NOT friend request person B (B != A) if any of the following conditions are true:
 * <p>
 * age[B] <= 0.5 * age[A] + 7
 * age[B] > age[A]
 * age[B] > 100 && age[A] < 100
 * Otherwise, A will friend request B.
 * <p>
 * Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.
 * <p>
 * How many total friend requests are made?
 * <p>
 * Example 1:
 * <p>
 * Input: [16,16]
 * Output: 2
 * Explanation: 2 people friend request each other.
 * Example 2:
 * <p>
 * Input: [16,17,18]
 * Output: 2
 * Explanation: Friend requests are made 17 -> 16, 18 -> 17.
 * Example 3:
 * <p>
 * Input: [20,30,100,110,120]
 * Output: 3
 * Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.
 * <p>
 * <p>
 * Notes:
 * <p>
 * 1 <= ages.length <= 20000.
 * 1 <= ages[i] <= 120.
 */
public class LC825 {

    /**
     * Instead of processing all 20000 people, we can process pairs of (age, count) representing how many people are that age. Since there are only 120 possible ages, this is a much faster loop.
     * <p>
     * Algorithm
     * <p>
     * For each pair (ageA, countA), (ageB, countB), if the conditions are satisfied with respect to age, then countA * countB pairs of people made friend requests.
     * <p>
     * If ageA == ageB, then we overcounted: we should have countA * (countA - 1) pairs of people making friend requests instead,
     * as you cannot friend request yourself.
     * <p>
     * <p>
     * Complexity Analysis
     * <p>
     * Time Complexity: O(A^2 + N) where N is the number of people, and A is the number of ages.
     * <p>
     * Space Complexity: O(A), the space used to store count.
     */
    public int numFriendRequests(int[] ages) {
        /**
         * Here is a Notes from problem
         * 1 <= ages[i] <= 120.
         * 1 <= ages.length <= 20000.
         */
        // Ages are within range of 0 to 120

        //STEP 1: Get map of Age and Count.
        int[] ageToCountMap = new int[121];
        for (int age : ages) {
            ageToCountMap[age]++;
        }

        // STEP 2: Take ageA and compare with all ages (ageB).
        int totalRequests = 0;
        for (int ageA = 0; ageA < ageToCountMap.length; ageA++) {
            for (int ageB = 0; ageB < ageToCountMap.length; ageB++) {
                if (ageA == ageB) {

                    //we should have countA * (countA - 1) pairs of people making friend requests instead,
                    // as you cannot friend request yourself.
                    int countA = ageToCountMap[ageA];
                    // we can also do
                    // (countA * countA) - countA, its also same as below
                    totalRequests += countA * (countA - 1);

                } else if (makeFriendRequest(ageA, ageB)) {
                    totalRequests += ageToCountMap[ageA] * ageToCountMap[ageB];
                }
            }
        }

        return totalRequests;
    }

    private boolean makeFriendRequest(int A, int B) {
        /** <p>
         * Person A will NOT friend request person B (B != A) if any of the following conditions are true:
         * <p>
         * age[B] <= 0.5 * age[A] + 7
         * age[B] > age[A]
         * age[B] > 100 && age[A] < 100
         * Otherwise, A will friend request B. *
         **/
        // Here A and B is an age not an index, So using it directly
        boolean condition1 = B <= 0.5 * A + 7;
        boolean condition2 = B > A;
        boolean condition3 = B > 100 && A < 100;

        if (condition1 || condition2 || condition3) {
            return false;
        }

        return true;
    }
}
