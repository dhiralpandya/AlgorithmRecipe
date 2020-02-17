package com.omtlab.algorithmrecipe.bit;

/**
 * 191. Number of 1 Bits
 * 
 * Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the 
 * Hamming weight).
 *
 *
 *
 * Example 1:
 *
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * Example 2:
 *
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * Example 3:
 *
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 *
 *
 * Note:
 *
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given
 * as signed integer type and should not affect your implementation, as the internal binary representation of the 
 * integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above 
 * the input represents the signed integer -3.
 *
 *
 * Follow up:
 *
 * If this function is called many times, how would you optimize it?
 */
public class LC191 {

    /**
     * Approach #2 (Bit Manipulation Trick) [Accepted]
     * Algorithm
     *
     * We can make the previous algorithm simpler and a little faster. Instead of checking every bit of the number, 
     * we repeatedly flip the least-significant 1-bit of the number to 0, and add 1 to the sum. As soon as the 
     * number becomes 0, we know that it does not have any more 1-bits, and we return the sum.
     *
     * The key idea here is to realize that for any number nn, doing a bit-wise AND of nn and n - 1 flips the 
     * least-significant 1-bit in nn to 0. Why? Consider the binary representations of nn and n - 1.
     *
     * Number of 1 Bits
     *
     * Figure 1. AND-ing nn and n-1n−1 flips the least-significant 1-bit to 0.
     *
     * In the binary representation, the least significant 11-bit in nn always corresponds to a 0-bit in n−1. 
     * Therefore, anding the two numbers nn and n - 1 always flips the least significant 1-bit in n to 0, and 
     * keeps all other bits the same.
     *
     * Using this trick, the code becomes very simple.
     */

    /**
     * NOTE : How to flip the least-significant 1-bit to 0
     * Here is the equation : N & N-1 will change least significant 1 bit to 0
     *
     * Example :
     * 3 = 0011
     * 3-1 is 2 = 0010
     * now 3&=(3-1) = 0010
     */

    public int hammingWeight(int n) {
        int sum = 0;
        while(n!=0){
            n&=n-1;
            sum++;
        }
        return sum;
    }

}
