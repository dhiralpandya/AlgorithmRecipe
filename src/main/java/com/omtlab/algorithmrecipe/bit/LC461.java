package com.omtlab.algorithmrecipe.bit;

/**
 * 461. Hamming Distance
 * 
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 231.
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 * 
 */
public class LC461 {

    public int fasterHammingDistance(int x, int y) {

        int xor = x^y;

        int distance  = 0;

        for(int i=0; i < 32; i++){
            int digit = 1 << i;
            if((digit & xor) > 0){
                distance++;
            }
        }
        return distance;
    }

    public int fasterHammingDistanceUsingLC191(int x, int y) {

        int xor = x^y;

        return new LC191().hammingWeight(xor);
    }
    
    public int hammingDistance(int x, int y) {

        int xor = x^y;
        
        int distance  = 0;
        
        for(char c : Integer.toBinaryString(xor).toCharArray()){
            if(c == '1'){
                distance++;
            }
        }
        return distance;
    }

   
}
