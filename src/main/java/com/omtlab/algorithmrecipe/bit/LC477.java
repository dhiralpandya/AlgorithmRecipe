package com.omtlab.algorithmrecipe.bit;

/**
 * 477. Total Hamming Distance
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.
 *
 * Example:
 * Input: 4, 14, 2
 *
 * Output: 6
 *
 * Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
 * showing the four bits relevant in this case). So the answer will be:
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * Note:
 * Elements of the given array are in the range of 0 to 10^9
 * Length of the array will not exceed 10^4.
 */
public class LC477 {

    /**
     * Here we only have 0 or 1, It means at each position 
     * which has different digits can be calculate : NumberOfOnes * NumberOfZeros at each position
     * 
     * Example :
     * Lets say we have 5 integers [2,2,2,0,0]
     * Binary for above 5 integers are [10,10,10,00,00]
     *  
     * Not at position ZERO[0] all integer has 0, Means we have Five 0 and Zero 1 
     * So total of different digits at position zero is Sum = 5[Zeros] * 0[Ones] = 0
     * 
     * Now lets move to position One. We have Three 1 and Two 2. 
     * So total of different digits at position one is Sum = 3[One] * 2[Zero] = 6 (Here each 1 will get two 0, So total we have 3 ones means 6 combination)
     * 
     * 
     * 
     */
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        
        for(int i = 0; i < 32; i++){
            int digit = 1 << i;
            int ones = 0;
            int zeros = 0;
            
            for(int n : nums){
                if( (n & digit) > 0){
                    ones++;
                } else {
                    zeros++;
                }
            }
            
            sum+=ones*zeros;
        }
        
        return sum;
    }
    
}
