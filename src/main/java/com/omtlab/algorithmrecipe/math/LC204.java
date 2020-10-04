package com.omtlab.algorithmrecipe.math;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 204. Count Primes
 *
 * Count the number of prime numbers less than a non-negative number, n.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * Example 2:
 *
 * Input: n = 0
 * Output: 0
 * Example 3:
 *
 * Input: n = 1
 * Output: 0
 */
public class LC204 {

    /*
    There are two way to solve this problem.
    1. Traditional way
       To find prime between 2 to n, we will go one by one and try to divide by [2,3,5,7],
       if modulo is non zero each time then its prime
    2. New way !!!
       This is reverse of above way, We are going to do multiplication instead of dividing with [2,3,5,7]
       take boolean[]  array of length n
       Set everything false.
       start two for loop
         first one with i=2 to i*i < n
         second will be j=i to j*i < n
          and will do [i*j] and mark boolean true for that.
          at the end we will count false.
       Why we are doing i*i < n ???
          Lets say we have n = 8 and i = 3, i*i == 9 means we are going far off from our limit "n"
          Same for j*i, lets say i=2 and j=5 means j*i = 10 means we are going far off from our limit "n"
     */
    public int countPrimes(int n) {

        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i*i < n;  i++) {
            for(int j = i; j*i < n; j++) {
                isPrime[i*j] = false;
            }
        }

        int count = 0;

        for(int i=2; i < n; i++) {
            if(isPrime[i]) {
                count++;
            }
        }

        return count;
    }
}
